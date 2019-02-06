package io.gdiazs.banking.accounts;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "accounts")
public class Account {

	@EmbeddedId
	private AccountId accountId;
	
	@Column(name = "ACCOUNT_ALIAS")
	private String accountAlias;
	
	@Column(name = "ACCOUNT_BALANCE", columnDefinition="DECIMAL(12,2)")
	private BigDecimal accountBalance;
	
	@Column(name = "ACCOUNT_CURRENCY")
	private String accountCurrency;
	
	@Column(name = "ACCOUNT_ENABLED")
	private Boolean enabled;
	
	@Column(name = "ACCOUNT_VERSION")
	@Version
	private Integer version;
	
	
	

	public Account() {

	}




	public String getAccountAlias() {
		return accountAlias;
	}

	public void setAccountAlias(String accountAlias) {
		this.accountAlias = accountAlias;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountCurrency() {
		return accountCurrency;
	}

	public void setAccountCurrency(String accountCurrency) {
		this.accountCurrency = accountCurrency;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
}
