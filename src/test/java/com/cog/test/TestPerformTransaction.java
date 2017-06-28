package com.cog.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.TransactionTypeExceptions;
import com.cognizant.service.PerformTransactionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestPerformTransaction {
	
	@Autowired
	PerformTransactionService performtransactionservice;
	
	UserDetails userdetails;
	TransactionDetails transactiondetails;
	List<TransactionDetails> transactionlist;

	//@Test
	public void addUserDetails() throws Exception {
		userdetails=new UserDetails(1254785855236142l,"Savings","Amir Khan",200000.00);
		 
		System.out.println("in test");
		performtransactionservice.addUserDetails(userdetails);
		System.out.println("after test");
		assertTrue(true);
			
	}
	

	
	
	//@Test
	public void updateTransactionDetails() throws TransactionTypeExceptions{
		long accountNumber=1254785855236142l;
		//TransactionDetails trans1=new TransactionDetails("TR_12","vacation","withdrawl",50000.00);
		//TransactionDetails trans1=new TransactionDetails("TR_14","gym2","withdrawl",80000.00);
		TransactionDetails trans1=new TransactionDetails("bonus","deposit",20000.00);
		performtransactionservice.updateTransactionDetails(trans1, accountNumber);
		
	}
	
	
	
	//@Test
	public void retriveTransactionDetails(){
		long accountNumber=1254785855236142l;
		
		performtransactionservice.retriveTransactionDetails(accountNumber);
	}
	/*
	//@Test
	public void updateTransactionBalance(){
		
		//userdetails=new UserDetails()
	}*/
	

}


