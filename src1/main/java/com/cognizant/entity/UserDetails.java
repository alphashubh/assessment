package com.cognizant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Component
@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	
	@Id
	@Column(name="ACCOUNT_NUMBER")
	Long accountNumber;
	@Column(name="ACCOUNT_TYPE")
	String accountType;
	@Column(name="ACCOUNT_HOLDER_NAME")
	String accountHolderName;
	@Column(name="ACCOUNT_BALANCE")
	Double accountBalance;
	
	@JsonManagedReference 
	@OneToMany(mappedBy="userDetails", cascade=CascadeType.ALL)
	private List<TransactionDetails> TransactionDetails;
	public List<TransactionDetails> getTransactionDetails() {
		return TransactionDetails;
	}
	public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
		this.TransactionDetails = transactionDetails;
	}
	@JsonManagedReference
	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ApplyHomeLoan> homeLoan;
	public List<ApplyHomeLoan> getHomeLoan() {
		return homeLoan;
	}

	public void setHomeLoan(List<ApplyHomeLoan> homeLoan) {
		this.homeLoan = homeLoan;
	}
	@JsonManagedReference
	@OneToMany(mappedBy="userDetails",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	List<ApplyEducationLoan> apply;
	
	public List<ApplyEducationLoan> getApply() {
		return apply;
	}
	public void setApply(List<ApplyEducationLoan> apply) {
		this.apply = apply;
	}
	
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAcountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	

	public UserDetails(){
		
	}
	
	public UserDetails(Long accountNumber, String accountType, String accountHolderName, Double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}
	public UserDetails(Long accountNumber, String accountType, String accountHolderName, Double accountBalance,
			List<TransactionDetails> transactionDetails) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.TransactionDetails = transactionDetails;
		this.accountBalance = accountBalance;
	}
	
	
	public UserDetails(long accountNumber, String accountType, String accountHolderName, Double accountBalance,
			List<ApplyEducationLoan> apply) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.apply = apply;
	}
	@Override
	public String toString() {
		return "UserDetails [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountHolderName="
				+ accountHolderName + ", accountBalance=" + accountBalance + ", TransactionDetails="
				+ TransactionDetails + ", homeLoan=" + homeLoan + ", apply=" + apply + "]";
	}
	
	
}
