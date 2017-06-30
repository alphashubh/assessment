package com.cognizant.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.entity.UserDetails;

@Component
public class ApplyHomeLoanDAO {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void insertHomeLoanDetails(UserDetails userDetails) {

		em.persist(userDetails);

	}

	public UserDetails updateLoanDetails(Long account_number) {

		UserDetails user = em.find(UserDetails.class, account_number);
		return user;

	}

}
