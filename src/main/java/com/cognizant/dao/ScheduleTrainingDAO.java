package com.cognizant.dao;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.ScheduleTraining;
import com.cognizant.entity.TrainerInfo;
@Component
public class ScheduleTrainingDAO {
	@PersistenceContext
	private EntityManager em;
	
	
	
	@Transactional
	public void insertTrainerInfo(TrainerInfo trainerInfo) {
		System.out.println("in dao"+trainerInfo);
		em.persist(trainerInfo);
		System.out.println("in dao"+trainerInfo);
		
	}

	public TrainerInfo insertScheduleTraining(int trainerId) {
		TrainerInfo trainerInfo1=em.find(TrainerInfo.class, trainerId);
		return trainerInfo1;
		
	}

	public TrainerInfo insertboth(ScheduleTraining sTraining, TrainerInfo inputtrainerInfo) {
		// TODO Auto-generated method stub
		em.persist(inputtrainerInfo);
		TrainerInfo trainerInfo=em.find(TrainerInfo.class, inputtrainerInfo.getTrainerId());
		return trainerInfo;
		
	}

	public List<ScheduleTraining> retriveSchedule(Date date) throws ParseException {
	/*	DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		String date1=dateFormat.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(dateFormat.parse(date1));
		c.add(Calendar.DATE, 7);  // number of days to add
		String tdate = dateFormat.format(c.getTime());  // dt is now the new date
		Date tdate1=new SimpleDateFormat("dd/MM/yyyy").parse(tdate);*/
		java.sql.Date sqlDate;
		 java.util.Date javaDate=null;
		 if (date != null) 
			 javaDate = new Date(date.getTime());
	        
			Calendar cal = Calendar.getInstance();
		     
		        cal.setTime(javaDate);
		        cal.add(Calendar.DATE, 7);
		        java.util.Date utilDate = cal.getTime();
		       sqlDate = new java.sql.Date(utilDate.getTime()); 
		Query query=em.createQuery("from ScheduleTraining t where t.startDate>= ? and t.startDate<= ?");
		query.setParameter(1, date);
		query.setParameter(2, utilDate);
		List <ScheduleTraining> ls=query.getResultList();
		System.out.println("****************"+ls);
		return ls;
				
	}

}
