package com.cognizant.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;




@Entity
@Table(name="Education_Loan_Details")
public class ApplyEducationLoan {
	
	@Column(name="Education_Loan_Id")
    String educationLoanId;

	@Id
	@Column(name="Edu_loan_Account_Number")
	Long eduLoanAccountNumber;
	
	@javax.validation.constraints.NotNull(message="Mandatory Field")
	@Range(min=1,max=999999999999999l , message="Please enter valid amount.")
	@Column(name="Edu_Loan_Amount")
	Double eduLoanAmount;
	
	@Column(name="Edu_Loan_Apply_Date")
	Date eduLoanApplyDate;
	
	@javax.validation.constraints.NotNull(message="Mandatory Field")
	@Range(min=1,max=10 , message="Please enter valid Duration.")
	@Column(name="Edu_Loan_Duration")
	Integer eduLoanDuration;
	
	@javax.validation.constraints.NotNull(message="Mandatory Field")
	@Range(min=1,max=2000000, message="Please enter valid Annual Income.")
	@Column(name="Father_Annual_Income")
	Double fatherAnnualIncome;
	
	@javax.validation.constraints.NotNull(message="Mandatory Field")
	@Range(min=1,max=999999999999999l , message="Please enter valid Course fee.")
	@Column(name="Course_Fee")
	Double courseFee;
	
	@NotEmpty(message="Mandatory Field")
	@Pattern(regexp="^[a-zA-Z\b \b]*$", message = "Only Alphabets are allowed.")
	@Column(name="Course_Name")
	String courseName;
	
	@NotEmpty(message="Mandatory Field")
	@Pattern(regexp="^[a-zA-Z\b \b]*$", message = "Only Alphabets are allowed.")
	@Column(name="Father_Name")
	String fatherName;
	
	@javax.validation.constraints.NotNull(message="Mandatory Field")
	@Range(min=16, message="ID card number can not be empty.")
	@Column(name="ID_Card_Number")
	Long idCardNumber;
	
@ManyToOne(cascade= CascadeType.ALL)
@JoinColumn(name="Account_Number")
private UserDetails userDetails;
public ApplyEducationLoan(){
	
}




public ApplyEducationLoan(String educationLoanId, Long eduLoanAccountNumber, Double eduLoanAmount,
		Date eduLoanApplyDate, Integer eduLoanDuration, Double fatherAnnualIncome, Double courseFee, String courseName,
		String fatherName, Long idCardNumber, UserDetails userDetails) {
	super();
	this.educationLoanId = educationLoanId;
	this.eduLoanAccountNumber = eduLoanAccountNumber;
	this.eduLoanAmount = eduLoanAmount;
	this.eduLoanApplyDate = eduLoanApplyDate;
	this.eduLoanDuration = eduLoanDuration;
	this.fatherAnnualIncome = fatherAnnualIncome;
	this.courseFee = courseFee;
	this.courseName = courseName;
	this.fatherName = fatherName;
	this.idCardNumber = idCardNumber;
	this.userDetails = userDetails;
}




public ApplyEducationLoan(String educationLoanId, Long eduLoanAccountNumber, Double eduLoanAmount,
		Date eduLoanApplyDate, Integer eduLoanDuration, Double fatherAnnualIncome, Double courseFee, String courseName,
		String fatherName, Long idCardNumber) {
	super();
	this.educationLoanId = educationLoanId;
	this.eduLoanAccountNumber = eduLoanAccountNumber;
	this.eduLoanAmount = eduLoanAmount;
	this.eduLoanApplyDate = eduLoanApplyDate;
	this.eduLoanDuration = eduLoanDuration;
	this.fatherAnnualIncome = fatherAnnualIncome;
	this.courseFee = courseFee;
	this.courseName = courseName;
	this.fatherName = fatherName;
	this.idCardNumber = idCardNumber;
}




public String getEducationLoanId() {
	return educationLoanId;
}

public void setEducationLoanId(String educationLoanId) {
	this.educationLoanId = educationLoanId;
}

public Long getEduLoanAccountNumber() {
	return eduLoanAccountNumber;
}

public ApplyEducationLoan(Double eduLoanAmount, Integer eduLoanDuration, Double fatherAnnualIncome,
		Double courseFee, String courseName, String fatherName, Long idCardNumber) {
	super();
	this.eduLoanAmount = eduLoanAmount;
	this.eduLoanDuration = eduLoanDuration;
	this.fatherAnnualIncome = fatherAnnualIncome;
	this.courseFee = courseFee;
	this.courseName = courseName;
	this.fatherName = fatherName;
	this.idCardNumber = idCardNumber;
}
public void setEduLoanAccountNumber(Long eduLoanAccountNumber) {
	this.eduLoanAccountNumber = eduLoanAccountNumber;
}

public Double getEduLoanAmount() {
	return eduLoanAmount;
}

public void setEduLoanAmount(Double eduLoanAmount) {
	this.eduLoanAmount = eduLoanAmount;
}

public Date getEduLoanApplyDate() {
	return eduLoanApplyDate;
}

public void setEduLoanApplyDate(Date eduLoanApplyDate) {
	this.eduLoanApplyDate = eduLoanApplyDate;
}

public Integer getEduLoanDuration() {
	return eduLoanDuration;
}

public void setEduLoanDuration(Integer eduLoanDuration) {
	this.eduLoanDuration = eduLoanDuration;
}

public Double getFatherAnnualIncome() {
	return fatherAnnualIncome;
}

public void setFatherAnnualIncome(Double fatherAnnualIncome) {
	this.fatherAnnualIncome = fatherAnnualIncome;
}

public Double getCourseFee() {
	return courseFee;
}

public void setCourseFee(Double courseFee) {
	this.courseFee = courseFee;
}

public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public String getFatherName() {
	return fatherName;
}

public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
}

public Long getIdCardNumber() {
	return idCardNumber;
}

public void setIdCardNumber(Long idCardNumber) {
	this.idCardNumber = idCardNumber;
}

public UserDetails getUserDetails() {
	return userDetails;
}

public void setUser(UserDetails userDetails) {
	this.userDetails = userDetails;
}




@Override
public String toString() {
	return "ApplyEducationLoan [educationLoanId=" + educationLoanId + ", eduLoanAccountNumber=" + eduLoanAccountNumber
			+ ", eduLoanAmount=" + eduLoanAmount + ", eduLoanApplyDate=" + eduLoanApplyDate + ", eduLoanDuration="
			+ eduLoanDuration + ", fatherAnnualIncome=" + fatherAnnualIncome + ", courseFee=" + courseFee
			+ ", courseName=" + courseName + ", fatherName=" + fatherName + ", idCardNumber=" + idCardNumber + "]";
}



	
}
