package com.cognizant.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.UserDetails;

@Component
public class ViewEducationLoanDao {
	@PersistenceContext
    private EntityManager em;

    @Transactional
	public UserDetails findEducationLoanDetails(long loanAccountNumber) {
		
    	UserDetails usd=em.find(UserDetails.class,loanAccountNumber);
		return usd;
		
	}

}
