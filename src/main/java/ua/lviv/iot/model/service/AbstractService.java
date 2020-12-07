package ua.lviv.iot.model.service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractService<T> {
	protected abstract JpaRepository<T, Integer> getJpaRepository();

	public List<T> findAll() {
		return getJpaRepository().findAll();
	}

	public T getById(Integer id) {
		return getJpaRepository().findById(id).orElse(null);
	}

	@Transactional
	public T saveToDatabase(T newObject) {
		return getJpaRepository().save(newObject);
	}

	public boolean deleteById(Integer id) {
		if (getJpaRepository().existsById(id)) {
			getJpaRepository().deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public T update(Integer id, T newObject, T oldObject) {
		if (getJpaRepository().existsById(id)) {
			BeanUtils.copyProperties(getJpaRepository().findById(id).get(), oldObject);
			getJpaRepository().save(newObject);
		}
		return oldObject;
	}
}
