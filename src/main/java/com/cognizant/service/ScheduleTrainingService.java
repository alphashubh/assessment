package com.cognizant.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.ScheduleTrainingDAO;
import com.cognizant.entity.ScheduleTraining;
import com.cognizant.entity.TrainerInfo;
@Component
public class ScheduleTrainingService {
	
	@Autowired
	
	ScheduleTrainingDAO scheduleTrainingDAO;
	TrainerInfo trainerInfo;
	public void insertTrainerInfo(TrainerInfo trainerInfo) {
		System.out.println("in service"+trainerInfo);
		scheduleTrainingDAO.insertTrainerInfo(trainerInfo);
		System.out.println("in service"+trainerInfo);
	}
	
	@Transactional
	public void insertScheduleTraining(ScheduleTraining sTraining, TrainerInfo inputtrainerInfo) throws ParseException {
		int id=inputtrainerInfo.getTrainerId();
		TrainerInfo trainerInfo=scheduleTrainingDAO.insertScheduleTraining(id);
		System.out.println("gggggggggggggggggg"+trainerInfo);
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis()); 
		System.out.println("dateeeeeeeeee"+sTraining.getStartDate());
		Date inputDate=(Date) sTraining.getStartDate();
		//Date inputDate=new SimpleDateFormat("dd/MM/yyyy").parse(dateFormat.format(sTraining.getStartDate()));
		System.out.println("++++++++++++++++"+currentDate+"+++++++"+inputDate+"+++++++++");
		System.out.println("*************============**********"+inputDate.compareTo(currentDate));
		if(trainerInfo!=null){
			
			if(!inputDate.before(currentDate) || inputDate.compareTo(currentDate)==-1){
			System.out.println("******************************");
			sTraining.setTrainerInfo(trainerInfo); 
			System.out.println("List******"+inputtrainerInfo);
			List<ScheduleTraining> sTrainingList=new ArrayList<ScheduleTraining>();
			
			sTrainingList.add(sTraining);
			System.out.println("List22222******"+sTrainingList);
			trainerInfo.setScheduleTraining(sTrainingList);
			}
			else{
				System.out.println("Invaild Date");
			}
		}
		else{
			if(!inputDate.before(currentDate) || inputDate.compareTo(currentDate)==-1){
			System.out.println("TrainerId not existed*******************************");
			
			scheduleTrainingDAO.insertboth(sTraining, inputtrainerInfo);
			
			
			trainerInfo=scheduleTrainingDAO.insertScheduleTraining(inputtrainerInfo.getTrainerId());
			sTraining.setTrainerInfo(trainerInfo); 
			System.out.println("List******"+inputtrainerInfo);
			List<ScheduleTraining> sTrainingList=new ArrayList<ScheduleTraining>();
			
			sTrainingList.add(sTraining);
			System.out.println("List22222******"+sTrainingList);
			trainerInfo.setScheduleTraining(sTrainingList);
			}
			else{
				System.out.println("Invaild Date");
			}
			
		}
		
		
	}

	public  List<ScheduleTraining> retriveSchedule(Date date) throws ParseException {
		
		scheduleTrainingDAO.retriveSchedule(date);
		List <ScheduleTraining> ls=scheduleTrainingDAO.retriveSchedule(date);
		System.out.println("9090909909090909009909090909090909009090909090990990"+ls);
		return ls;
	}

}
