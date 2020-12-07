package ua.lviv.iot.model.domain;

import java.util.Date;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "transfer")
public class Transfer {
	private Integer id;
	private Integer amount;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private LocalTime time;
	private String purposeOfPayment;
	private Account accountBySenderAccountId;
	private Account accountByRecipientAccountId;
	private Currency currencyByCurrencyId;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "amount")
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "time")
	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Column(name = "purpose_of_payment")
	public String getPurposeOfPayment() {
		return purposeOfPayment;
	}

	public void setPurposeOfPayment(String purposeOfPayment) {
		this.purposeOfPayment = purposeOfPayment;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Transfer other = (Transfer) obj;
		if (accountByRecipientAccountId == null) {
			if (other.accountByRecipientAccountId != null) {
				return false;
			}
		} else if (!accountByRecipientAccountId.equals(other.accountByRecipientAccountId)) {
			return false;
		}
		if (accountBySenderAccountId == null) {
			if (other.accountBySenderAccountId != null) {
				return false;
			}
		} else if (!accountBySenderAccountId.equals(other.accountBySenderAccountId)) {
			return false;
		}
		if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
			return false;
		}
		if (currencyByCurrencyId == null) {
			if (other.currencyByCurrencyId != null) {
				return false;
			}
		} else if (!currencyByCurrencyId.equals(other.currencyByCurrencyId)) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (purposeOfPayment == null) {
			if (other.purposeOfPayment != null) {
				return false;
			}
		} else if (!purposeOfPayment.equals(other.purposeOfPayment)) {
			return false;
		}
		if (time == null) {
			if (other.time != null) {
				return false;
			}
		} else if (!time.equals(other.time)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountByRecipientAccountId == null) ? 0 : accountByRecipientAccountId.hashCode());
		result = prime * result + ((accountBySenderAccountId == null) ? 0 : accountBySenderAccountId.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((currencyByCurrencyId == null) ? 0 : currencyByCurrencyId.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((purposeOfPayment == null) ? 0 : purposeOfPayment.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "sender_account_id", referencedColumnName = "id", nullable = false)
	public Account getAccountBySenderAccountId() {
		return accountBySenderAccountId;
	}

	public void setAccountBySenderAccountId(Account accountBySenderAccountId) {
		this.accountBySenderAccountId = accountBySenderAccountId;
	}

	@ManyToOne
	@JoinColumn(name = "recipient_account_id", referencedColumnName = "id", nullable = false)
	public Account getAccountByRecipientAccountId() {
		return accountByRecipientAccountId;
	}

	public void setAccountByRecipientAccountId(Account accountByRecipientAccountId) {
		this.accountByRecipientAccountId = accountByRecipientAccountId;
	}

	@ManyToOne
	@JoinColumn(name = "currency_id", referencedColumnName = "id")
	public Currency getCurrencyByCurrencyId() {
		return currencyByCurrencyId;
	}

	public void setCurrencyByCurrencyId(Currency currencyByCurrencyId) {
		this.currencyByCurrencyId = currencyByCurrencyId;
	}
}
