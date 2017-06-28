/*package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.ApplyHomeLoanDAO;
import com.cognizant.dao.ViewHomeLoanDAO;
import com.cognizant.entity.ApplyHomeLoan;
import com.cognizant.entity.UserDetails;


@Component
public class ViewHomeLoanService {
	@Autowired
	private	ViewHomeLoanDAO homeLoanDao;
	//private UserDetails userDetails;
	List<ApplyHomeLoan> loanDetails;
	
	public List<ApplyHomeLoan> retrieveLoanDetails(long ACCOUNT_NUMBER) {
		
	//	loanDetails=new ApplyHomeLoan();
	System.out.println("IN SERVICE");
		loanDetails=homeLoanDao.retrieveLoanDetails( ACCOUNT_NUMBER);
	
	System.out.println("AFTER SERVICE");
		System.out.println(loanDetails);
		return loanDetails;
		
		
		
		
	}


}
*/