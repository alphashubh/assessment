
package com.cognizant.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="TRANSACTION_DETAILS")
public class TransactionDetails {
	@Id
	@Column(name="TRANSACTION_ID")
	private long  transactionId;
	
	@NotEmpty(message="Mandatory Field.")
	@Pattern(regexp="^[a-zA-Z\b \b]*$", message = "Only Alphabets are allowed.")
	@Column(name="TRANSACTION_DESCRIPTION")
	private String transactiondescription;
	
	/*@Column(name="ACCOUNT_NUMBER")
	private long accountNumber;*/
	@NotEmpty(message="Mandatory Field")
	@Column(name="TRANSACTION_TYPE")
	private String transactiontype;
	
	@Range(min=1,max=999999999999999l , message="Please enter valid amount.")
	@Column(name="TRANSACTION_AMOUNT")
	private double transactionAmount;
	
	
	
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	@JsonBackReference 
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ACCOUNT_NUMBER")
	private UserDetails userDetails;
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactiondescription() {
		return transactiondescription;
	}
	@Override
	public String toString() {
		return "TransactionDetails [transactionId=" + transactionId + ", transactiondescription="
				+ transactiondescription +  ", transactiontype=" + transactiontype
				+ ", transactionAmount=" + transactionAmount + "]";
	}
	public void setTransactiondescription(String transactiondescription) {
		this.transactiondescription = transactiondescription;
	}
	
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public TransactionDetails(){
		
	}
	public TransactionDetails(String transactionId, String transactiondescription, 
			String transactiontype, double transactionAmount, UserDetails userDetails) {
		super();
		this.userDetails= userDetails;
		/*this.transactionId = transactionId;*/
		this.transactiondescription = transactiondescription;
		//this.accountNumber = accountNumber;
		this.transactiontype = transactiontype;
		this.transactionAmount = transactionAmount;
	}
	public TransactionDetails(String transactionId, String transactiondescription, 
			String transactiontype, double transactionAmount) {
		super();
		/*this.transactionId = transactionId;*/
		this.transactiondescription = transactiondescription;
		
		this.transactiontype = transactiontype;
		this.transactionAmount = transactionAmount;
		
	}
	public TransactionDetails( String transactiondescription, 
			String transactiontype, double transactionAmount) {
		super();
		
		this.transactiondescription = transactiondescription;
		
		this.transactiontype = transactiontype;
		this.transactionAmount = transactionAmount;
		
	}
	
	
}
	
	


	
