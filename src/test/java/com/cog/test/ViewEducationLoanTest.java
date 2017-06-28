package com.cog.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cognizant.dao.ViewEducationLoanDao;
import com.cognizant.entity.UserDetails;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class ViewEducationLoanTest {
	@Autowired
	ViewEducationLoanDao viewEducationLoan;
	@Test
	public void test() {
		
		long accountNumber=1254785855236142l;
		
		UserDetails userDetails=viewEducationLoan.findEducationLoanDetails(accountNumber);	
		System.out.println(userDetails);
		
	}

}
