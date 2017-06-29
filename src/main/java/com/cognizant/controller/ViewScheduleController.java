package com.cognizant.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.entity.ScheduleTraining;
import com.cognizant.entity.TransactionDetails;
import com.cognizant.service.ScheduleTrainingService;

@Controller
public class ViewScheduleController {
	@Autowired
	ScheduleTrainingService scheduleTrainingService;
		@RequestMapping(value = "/viewschedule", method = RequestMethod.GET)
	public String getList(Model model) {
	return "ViewScheduleTraining";
}

	@RequestMapping(value = "/viewschedule1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ScheduleTraining> list(Model model, @RequestParam("startDate") Date startDate) throws ParseException {
		System.out.println("214564545454542541514564561254562151515");
		System.out.println("dtdtdtdtdtdtdtdttt"+startDate);
		List<ScheduleTraining> t = new ArrayList<ScheduleTraining>();
		List<ScheduleTraining> t1 = new ArrayList<ScheduleTraining>();
		t = scheduleTrainingService.retriveSchedule(startDate);
		for(int i=0;i<t.size();i++)
		{
			ScheduleTraining trainerSchedule1 = t.get(i);
			 trainerSchedule1.getTrainerInfo().setScheduleTraining(null);
			 t1.add(trainerSchedule1);
		}
		System.out.println("Controller*******************" + t);
		return t;
		
	/*	List<TrainerSchedule> trainers=  viewTrainerService.viewTrainerServiceMethod(dat);
		List<TrainerSchedule> trainers1 = new ArrayList<TrainerSchedule>();
		for(int i=0;i<trainers.size();i++)
		{
			TrainerSchedule trainerSchedule1 = trainers.get(i);
			 trainerSchedule1.getTrainer().setSchedule(null);
			trainers1.add(trainerSchedule1);
		}*/
}

}
