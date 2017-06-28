package com.cognizant.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		String date1=dateFormat.format(date);
		Date currentDate= new SimpleDateFormat("dd/MM/yyyy").parse(date1);
		Date inputDate=new SimpleDateFormat("dd/MM/yyyy").parse(dateFormat.format(sTraining.getStartDate()));
		System.out.println("++++++++++++++++"+currentDate+"+++++++"+inputDate);
		
		if(trainerInfo!=null){
			
			if(inputDate.after(currentDate)){
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
			if(inputDate.after(currentDate)){
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

	public void retriveSchedule(Date date) throws ParseException {
		
		scheduleTrainingDAO.retriveSchedule(date);
	}

}
