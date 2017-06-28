package com.cog.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.dao.ViewHomeLoanDAO;
import com.cognizant.entity.ApplyHomeLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ApplyHomeLoanService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")


public class TestViewHomeLoan {
	@Autowired
	ViewHomeLoanDAO viewLoanDao;
	UserDetails userDetails;
	

		@Test
	public void viewLoanDao() {
		
	System.out.println("IN TEST");
	userDetails=viewLoanDao.retrieveLoanDetails(1234567890987656l);
	System.out.println(userDetails);
		System.out.println("AFTER TEST");
	}
	
}

