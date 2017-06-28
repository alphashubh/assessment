package com.cog.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.dao.ApplyEducationLoanDAO;
import com.cognizant.entity.ApplyEducationLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ApplyEducationLoanService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class ApplyEducationLoanTest {
	
	@Autowired
	ApplyEducationLoanDAO educationLoandao;
	@Autowired
	ApplyEducationLoanService educationLoanService;

	//@Test
	public void addUserDetailTest() {
		
		
		
		ApplyEducationLoan loanObj =new ApplyEducationLoan(100000.00,2,150000.00,20000.00,
				"Course","Father",1254785855236142l);
		
		UserDetails	userDetails=new UserDetails(1254785855236142l,"Saving","Raj",1000000.00);
		educationLoanService.insertUser(loanObj,userDetails);
		
		
   assertTrue(true);
	}
	
	@Test
	public void insertLoan() {
		long accountNumber=1254785855236142l;
		ApplyEducationLoan loanObj =new ApplyEducationLoan(107800.00,5,15000.00,20000.00,
				"Course","Father",841287895475396l);
		educationLoanService.insertEducationLoan(loanObj,accountNumber);
		 assertTrue(true);
   
	}
	

	/*@Test
	public void loanDuration() {
		
	}*/
	
}
