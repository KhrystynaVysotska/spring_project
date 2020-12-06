package ua.lviv.iot.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	private Integer id;
	private String currentAccountNumber;
	private Integer amount;
	private PinCode pinCodeByPinCodeId;
	private AccountOwner accountOwnerByAccountOwnerId;
	private Bank bankByBankIdentificationCode;
	private Currency currencyByCurrencyId;
	private AccountType accountTypeByAccountTypeId;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "current_account_number")
	public String getCurrentAccountNumber() {
		return currentAccountNumber;
	}

	public void setCurrentAccountNumber(String currentAccountNumber) {
		this.currentAccountNumber = currentAccountNumber;
	}

	@Column(name = "amount")
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
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
		Account other = (Account) obj;
		if (accountOwnerByAccountOwnerId == null) {
			if (other.accountOwnerByAccountOwnerId != null) {
				return false;
			}
		} else if (!accountOwnerByAccountOwnerId.equals(other.accountOwnerByAccountOwnerId)) {
			return false;
		}
		if (accountTypeByAccountTypeId == null) {
			if (other.accountTypeByAccountTypeId != null) {
				return false;
			}
		} else if (!accountTypeByAccountTypeId.equals(other.accountTypeByAccountTypeId)) {
			return false;
		}
		if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
			return false;
		}
		if (bankByBankIdentificationCode == null) {
			if (other.bankByBankIdentificationCode != null) {
				return false;
			}
		} else if (!bankByBankIdentificationCode.equals(other.bankByBankIdentificationCode)) {
			return false;
		}
		if (currencyByCurrencyId == null) {
			if (other.currencyByCurrencyId != null) {
				return false;
			}
		} else if (!currencyByCurrencyId.equals(other.currencyByCurrencyId)) {
			return false;
		}
		if (currentAccountNumber == null) {
			if (other.currentAccountNumber != null) {
				return false;
			}
		} else if (!currentAccountNumber.equals(other.currentAccountNumber)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (pinCodeByPinCodeId == null) {
			if (other.pinCodeByPinCodeId != null) {
				return false;
			}
		} else if (!pinCodeByPinCodeId.equals(other.pinCodeByPinCodeId)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountOwnerByAccountOwnerId == null) ? 0 : accountOwnerByAccountOwnerId.hashCode());
		result = prime * result + ((accountTypeByAccountTypeId == null) ? 0 : accountTypeByAccountTypeId.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((bankByBankIdentificationCode == null) ? 0 : bankByBankIdentificationCode.hashCode());
		result = prime * result + ((currencyByCurrencyId == null) ? 0 : currencyByCurrencyId.hashCode());
		result = prime * result + ((currentAccountNumber == null) ? 0 : currentAccountNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pinCodeByPinCodeId == null) ? 0 : pinCodeByPinCodeId.hashCode());
		return result;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pin_code_id", referencedColumnName = "id", nullable = false)
	public PinCode getPinCodeByPinCodeId() {
		return pinCodeByPinCodeId;
	}

	public void setPinCodeByPinCodeId(PinCode pinCodeByPinCodeId) {
		this.pinCodeByPinCodeId = pinCodeByPinCodeId;
	}

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "account_owner_id", referencedColumnName = "id", nullable = false)
	public AccountOwner getAccountOwnerByAccountOwnerId() {
		return accountOwnerByAccountOwnerId;
	}

	public void setAccountOwnerByAccountOwnerId(AccountOwner accountOwnerByAccountOwnerId) {
		this.accountOwnerByAccountOwnerId = accountOwnerByAccountOwnerId;
	}

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "bank_identification_code", referencedColumnName = "identification_code", nullable = false)
	public Bank getBankByBankIdentificationCode() {
		return bankByBankIdentificationCode;
	}

	public void setBankByBankIdentificationCode(Bank bankByBankIdentificationCode) {
		this.bankByBankIdentificationCode = bankByBankIdentificationCode;
	}

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "currency_id", referencedColumnName = "id")
	public Currency getCurrencyByCurrencyId() {
		return currencyByCurrencyId;
	}

	public void setCurrencyByCurrencyId(Currency currencyByCurrencyId) {
		this.currencyByCurrencyId = currencyByCurrencyId;
	}

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "account_type_id", referencedColumnName = "id")
	public AccountType getAccountTypeByAccountTypeId() {
		return accountTypeByAccountTypeId;
	}

	public void setAccountTypeByAccountTypeId(AccountType accountTypeByAccountTypeId) {
		this.accountTypeByAccountTypeId = accountTypeByAccountTypeId;
	}
}
