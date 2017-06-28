
package com.cognizant.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.cognizant.entity.UserDetails;

@Entity
@Table(name="Home_Loan_Details")
public class ApplyHomeLoan {

	
	@Column(name="HOME_LOAN_ID")
	String homeLoanId;
	
	@NotNull(message="Mandatory field")
	
	@Range(min=1,max=999999999999999l , message="Please enter valid amount.")
	@Column(name="LOAN_AMOUNT") 
	//@NumberFormat(style = Style.NUMBER)
	Long loanAmount;
	
	@NotNull(message="Mandatory field")
	@Column(name="LOAN_DURATION")
	 Integer loanDuration;
	 
	@Column(name="LOAN_APPLY_DATE")
	Date loanApplyDate;
	
	@NotNull(message="Mandatory field")
	@Range(min=0,max=999999999999999L , message="Please enter valid income.")
	@Column(name="ANNUAL_INCOME")
	 Long annualIncome;
	
	@NotEmpty(message="Mandatory field")
	@Pattern(regexp="^[a-zA-Z\b \b]*$", message = "Only Alphabets are allowed.")
	@Column(name="COMPANY_NAME")
	 String companyName;
	
	@NotEmpty(message="Mandatory field")
	@Pattern(regexp="^[a-zA-Z\b \b]*$", message = "Only Alphabets are allowed.")
	@Column(name="DESIGNATON")
	 String designation;
	
	@NotNull(message="Mandatory field")
	@Range(min=1,max=80, message="Please enter valid experience years.")
	//@Pattern(regexp="^[0-9]*$", message = "Only numerics are allowed.")
	@Column(name="TOTAL_EXP")
	Integer totalExperience;
	
	@NotNull(message="Mandatory field")
	@Range(min=1,max=80, message="Please enter valid experience years.")
	@Column(name="CURRENT_EXP")
	Integer currentExperience;
	 
	 @Id
	 @Column(name="LOAN_ACCOUNT_NUMBER")
	 Long loanAccountNumber;

	public Long getLoanAccountNumber() {
		return loanAccountNumber;
	}
	public void setLoanAccountNumber(Long loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}


	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 @JoinColumn(name = "ACCOUNT_NUMBER")
		private UserDetails userDetails;
	 
	 public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}



	 
	public String getHomeLoanId() {
		return homeLoanId;
	}
	public void setHomeLoanId(String homeLoanId) {
		this.homeLoanId = homeLoanId;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Integer getLoanDuration() {
		return loanDuration;
	}
	public void setLoanDuration(Integer loanDuration) {
		this.loanDuration = loanDuration;
	}
	
	public Date getLoanApplyDate() {
		return loanApplyDate;
	}
	public void setLoanApplyDate(Date loanApplyDate) {
		this.loanApplyDate = loanApplyDate;
	}
	public Long getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(Long annualIncome) {
		this.annualIncome = annualIncome;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Integer getTotalExperience() {
		return totalExperience;
	}
	public void setTotalExperience(Integer totalExperience) {
		this.totalExperience = totalExperience;
	}
	public Integer getCurrentExperience() {
		return currentExperience;
	}
	public void setCurrentExperience(Integer currentExperience) {
		this.currentExperience = currentExperience;
	}
	@Override
	public String toString() {
		return "HomeLoan [homeLoanId=" + homeLoanId + ", loanAmount=" + loanAmount + ", loanDuration=" + loanDuration
				+ ", loanApplyDate=" + loanApplyDate + ", annualIncome="
				+ annualIncome + ", companyName=" + companyName + ", designation=" + designation + ", totalExperience="
				+ totalExperience + ", currentExperience=" + currentExperience + "]";
	}
	public ApplyHomeLoan( Long loanAmount, Integer loanDuration,
			Long annualIncome, String companyName, String designation, Integer totalExperience, Integer currentExperience,UserDetails userDetails) {
		super();
	
		this.loanAmount = loanAmount;
		this.loanDuration = loanDuration;
		//this.loanApplyDate = loanApplyDate;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
		this.designation = designation;
		this.totalExperience = totalExperience;
		this.currentExperience = currentExperience;
		this.userDetails=userDetails;
	}
	
	  
	public ApplyHomeLoan(){}	


public ApplyHomeLoan( Long loanAmount, Integer loanDuration, 
		Long annualIncome, String companyName, String designation, Integer totalExperience, Integer currentExperience) {
	super();

	this.loanAmount = loanAmount;
	this.loanDuration = loanDuration;
	//this.loanApplyDate = loanApplyDate;
	this.annualIncome = annualIncome;
	this.companyName = companyName;
	this.designation = designation;
	this.totalExperience = totalExperience;
	this.currentExperience = currentExperience;
	//this.userDtails=userDetails;
}

public ApplyHomeLoan( String homeLoanId,Long loanAccountNumber,Long loanAmount, Integer loanDuration, Date loanApplyDate,
		Long annualIncome, String companyName, String designation, Integer totalExperience, Integer currentExperience) {
	super();
	this.homeLoanId=homeLoanId;
	this.loanAccountNumber=loanAccountNumber;
	this.loanAmount = loanAmount;
	this.loanDuration = loanDuration;
	this.loanApplyDate = loanApplyDate;
	this.annualIncome = annualIncome;
	this.companyName = companyName;
	this.designation = designation;
	this.totalExperience = totalExperience;
	this.currentExperience = currentExperience;
	//this.userDtails=userDetails;
}

}