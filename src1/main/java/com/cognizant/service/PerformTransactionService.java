package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.PerformTransactionDAO;
import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.TransactionTypeExceptions;

@Component
public class PerformTransactionService {

	private static final Logger logger = Logger.getLogger(PerformTransactionService.class);

	@Autowired
	PerformTransactionDAO performTransactionDao;

	public void addUserDetails(UserDetails userdetails) throws TransactionTypeExceptions {

		if (userdetails.getAccountNumber().toString().length() == 16) {
			performTransactionDao.addUserDetails(userdetails);

		} else {
			throw new TransactionTypeExceptions("Account Number Should Be Of 16 Digits");
		}
	}

	@Transactional
	public void updateTransactionDetails(TransactionDetails trans1, long accountNumber)
			throws TransactionTypeExceptions {
		performTransactionDao.updateTransactionDetails(accountNumber);
		UserDetails usd = performTransactionDao.updateTransactionDetails(accountNumber);
		long transactionId = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
		trans1.setTransactionId(transactionId);
		double transactionAmount = trans1.getTransactionAmount();
		double accountBaance = usd.getAccountBalance();

		if (trans1.getTransactiontype().equals("deposit")) {
			accountBaance = accountBaance + transactionAmount;
			usd.setAccountBalance(accountBaance);
		} else {
			accountBaance = accountBaance - transactionAmount;
			if (accountBaance < 5000 && usd.getAccountType().equals("Savings")) {
				throw new TransactionTypeExceptions(
						"transactionAmount:Your Account Balance must be maintain atleast 5000");

			} else if (accountBaance < 0) {
				throw new TransactionTypeExceptions("transactionAmount:Insufficient Balance");
			} else {
				usd.setAccountBalance(accountBaance);
			}
		}

		trans1.setUserDetails(usd);
		List<TransactionDetails> transactionList = new ArrayList<TransactionDetails>();

		transactionList.add(trans1);
		usd.setTransactionDetails(transactionList);

	}

	public List<TransactionDetails> retriveTransactionDetails(long accountNumber) {
		performTransactionDao.retriveTransactionDetails(accountNumber);
		List<TransactionDetails> t = new ArrayList<TransactionDetails>();

		t = performTransactionDao.retriveTransactionDetails(accountNumber);
		return t;

	}

}
