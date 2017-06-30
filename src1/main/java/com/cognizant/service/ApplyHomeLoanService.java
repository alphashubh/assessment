package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.ApplyHomeLoanDAO;
import com.cognizant.entity.ApplyHomeLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.BankManagementException;

@Component
public class ApplyHomeLoanService {

	private static final Logger logger = Logger.getLogger(ApplyHomeLoanService.class);

	@Autowired
	private ApplyHomeLoanDAO homeLoanDao;

	public void insertHomeLoanDetails(List<ApplyHomeLoan> homeLoan, UserDetails userDetails) throws Exception {

		for (ApplyHomeLoan homeLoan2 : homeLoan) {
			homeLoan2.setLoanAccountNumber(generateLoanAccNumber());
			homeLoan2.setHomeLoanId(generateHomeLoanId(userDetails.getAccountNumber()));
		}
		userDetails.setHomeLoan(homeLoan);
		homeLoanDao.insertHomeLoanDetails(userDetails);

	}

	public String generateHomeLoanId(long accountNumber) {

		StringBuffer sb = new StringBuffer();
		String s1 = Long.toString(accountNumber);
		sb.append(s1);
		String lan = sb.toString();

		String idNumberLast = lan.substring(13, 16);

		String homeLoanId = "HL-".concat(idNumberLast);

		return homeLoanId;

	}

	public long generateLoanAccNumber() {
		Long num = (long) (Math.random() * 10000000000000000L);
		return num;
	}

	@Transactional
	public void updateLoanDetails(Long accountNumber, ApplyHomeLoan h2) throws BankManagementException {

		if (h2.getLoanDuration() == 5 || h2.getLoanDuration() == 10 || h2.getLoanDuration() == 15
				|| h2.getLoanDuration() == 20) {

			long income = h2.getAnnualIncome();
			long loanAmount = h2.getLoanAmount();
			if (income != (.10 * loanAmount)) {
				throw new BankManagementException("loanAmount:Please enter loan amount 10% more than annual income.");

			}

			homeLoanDao.updateLoanDetails(accountNumber);
			UserDetails userDetails = homeLoanDao.updateLoanDetails(accountNumber);
			h2.setUserDetails(userDetails);

			String id = generateHomeLoanId(userDetails.getAccountNumber());
			h2.setHomeLoanId(id);
			h2.setLoanAccountNumber(generateLoanAccNumber());

			List<ApplyHomeLoan> hLoan = new ArrayList<ApplyHomeLoan>();
			hLoan.add(h2);

			userDetails.setHomeLoan(hLoan);

		} else {

			throw new BankManagementException("loanDuration:Loan Duration must be either 5, 10, 15 or 20 years");
		}

	}

}
