package com.cog.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.entity.ScheduleTraining;
import com.cognizant.entity.TrainerInfo;
import com.cognizant.service.ScheduleTrainingService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class ScheduleTrainingTest {
	
	@Autowired
	ScheduleTrainingService scheduleTrainingService;
	
	ScheduleTraining sTraining;
	TrainerInfo trainerInfo;
	

	//@Test
	public void insertTrainerInfo(){
		TrainerInfo trainerInfo=new TrainerInfo(123458,"Sunil","SRM Unversity","Spring");
		System.out.println("in test"+trainerInfo);
		scheduleTrainingService.insertTrainerInfo(trainerInfo);
		System.out.println("out test"+trainerInfo);
		assertTrue(true);
	}
	
/*	@Test
	public void insertScheduleTraining() throws ParseException{
		int TrainerId=123458;
		String date1="30/06/2017";
		Date date=new SimpleDateFormat("dd/MM/yyyy").parse(date1);
		System.out.println("****************"+date);
		ScheduleTraining sTraining=new ScheduleTraining(1,date,20);
		scheduleTrainingService.insertScheduleTraining(TrainerId,sTraining);
		
	}*/
	//@Test
	public void insertScheduleTraining() throws ParseException{
		TrainerInfo inputtrainerInfo=new TrainerInfo(123455,"ramesh","SRM Unversity","hibernate");
		String date1="28/07/2017";
		Date date=new SimpleDateFormat("dd/MM/yyyy").parse(date1);
		System.out.println("****************"+date);
		ScheduleTraining sTraining=new ScheduleTraining(8,date,40);
		scheduleTrainingService.insertScheduleTraining(sTraining,inputtrainerInfo);
		
	}
	
	@Test
	public void retriveSchedule() throws ParseException{
		String date1="30/06/2017";
		Date date=new SimpleDateFormat("dd/MM/yyyy").parse(date1);
		scheduleTrainingService.retriveSchedule(date);
	}

}
