package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.controller.ApplyEducationLoanController;
import com.cognizant.entity.ApplyHomeLoan;
import com.cognizant.entity.UserDetails;

@Component
public class ViewHomeLoanDAO {
	private static final Logger log = Logger.getLogger(ApplyEducationLoanController.class);
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public UserDetails retrieveLoanDetails(long ACCOUNT_NUMBER) {

		UserDetails ud = em.find(UserDetails.class, ACCOUNT_NUMBER);
		log.info("in viewhome loan" + ud);

		return ud;
	}

}
