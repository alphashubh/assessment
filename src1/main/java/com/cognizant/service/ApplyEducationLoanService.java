package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.ApplyEducationLoanDAO;
import com.cognizant.entity.ApplyEducationLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.BankManagementException;

@Component
public class ApplyEducationLoanService {
	@Autowired
	ApplyEducationLoanDAO educationLoandao;

	public long generateEduLoanAccountNumber() {

		long time = System.nanoTime();
		Random rd = new Random();
		int i = rd.nextInt(10);
		String random = Integer.toString(i);
		String timeInString1 = Long.toString(time);
		StringBuffer sb = new StringBuffer();
		sb.append(timeInString1).append(random);
		String sb2 = sb.toString();
		long accNumber = Long.parseLong(sb2);
		return accNumber;
	}

	public String generateEduLoanId(ApplyEducationLoan loanObj) {
		StringBuffer sb3 = new StringBuffer();
		long idNumber = loanObj.getIdCardNumber();
		String account = Long.toString(idNumber);
		String firstFiveDigits = account.substring(0, 5);
		sb3.append("EL").append("-").append(firstFiveDigits);
		String loanId = sb3.toString();
		return loanId;
	}

	@Transactional
	public void insertEducationLoan(ApplyEducationLoan loanObj, long accountNumber) throws BankManagementException {
		UserDetails userDetails = new UserDetails();
		ApplyEducationLoanService educationLoanServices = new ApplyEducationLoanService();
		loanObj.setEduLoanAccountNumber(educationLoanServices.generateEduLoanAccountNumber());
		loanObj.setEducationLoanId(educationLoanServices.generateEduLoanId(loanObj));

		if (loanObj.getEduLoanDuration() == 5 || loanObj.getEduLoanDuration() == 10) {
			if (loanObj.getCourseFee() < 2000000.00) {

				userDetails = educationLoandao.insertEducationLoan(accountNumber);
				loanObj.setUser(userDetails);
				List<ApplyEducationLoan> educationLoanList = new ArrayList<ApplyEducationLoan>();
				educationLoanList.add(loanObj);
				userDetails.setApply(educationLoanList);
			} else {
				throw new BankManagementException("courseFee:Course Fee cannot be greater than 20 Lakhs");
			}

		} else {
			throw new BankManagementException("eduLoanDuration:Loan Duration can be either 5 or 10 years");
		}
	}

	@Transactional
	public void insertUser(ApplyEducationLoan loanObj, UserDetails userDetails) {
		ApplyEducationLoanService educationLoanServices = new ApplyEducationLoanService();
		loanObj.setEduLoanAccountNumber(educationLoanServices.generateEduLoanAccountNumber());
		loanObj.setEducationLoanId(educationLoanServices.generateEduLoanId(loanObj));

		loanObj.setUser(userDetails);
		List<ApplyEducationLoan> educationLoanList = new ArrayList<ApplyEducationLoan>();
		educationLoanList.add(loanObj);
		userDetails.setApply(educationLoanList);

		educationLoandao.addUser(userDetails);

	}
}
