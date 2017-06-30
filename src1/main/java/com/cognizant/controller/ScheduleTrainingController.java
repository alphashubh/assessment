package com.cognizant.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.entity.Schedule;
import com.cognizant.entity.ScheduleTraining;
import com.cognizant.entity.TrainerInfo;
import com.cognizant.entity.TransactionDetails;
import com.cognizant.exception.ScheduleTrainingException;
import com.cognizant.exception.TransactionTypeExceptions;
import com.cognizant.service.ScheduleTrainingService;

@Controller
public class ScheduleTrainingController {
	
	private static final Logger log = Logger.getLogger(PerformTransactionController.class);
	
	@Autowired
	ScheduleTrainingService scheduleTrainingService;
	
	@RequestMapping(value = "/scheduletraining", method = RequestMethod.GET)
	public String getScheduleTraining(@ModelAttribute("schedule") @Valid Schedule schedule,
			BindingResult result, Model model) {
		return "ScheduleTraining";
	}

	@RequestMapping(value = "/scheduletraining", method = RequestMethod.POST)
	public String ScheduleTraining( @Valid Schedule schedule,
			BindingResult result, Model model)  {
		
		TrainerInfo inputtrainerInfo=schedule.getTrainerInfo();
		ScheduleTraining sTraining=schedule.getScheduleTraining();
		System.out.println("00000000000000000"+sTraining.getStartDate());
		try {
			scheduleTrainingService.insertScheduleTraining(sTraining,inputtrainerInfo);
		}catch (ConstraintViolationException e) {
			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while (iterator.hasNext()) {
				ConstraintViolation<?> next = iterator.next();
				log.error("Validation message: " + next.getMessage());
				log.error("Invalid field: " + next.getPropertyPath());
				log.error("Validation class/bean: " + next.getRootBean());
				result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());
			}
		}
		catch (ScheduleTrainingException e) {
			// TODO Auto-generated catch block
			String sb = e.getMessage();
			String sb1[] = sb.split(":");
			result.rejectValue(sb1[0].toString(), "", sb1[1].toString());
		}
		if(result.hasErrors()){
			return "ScheduleTraining";
		}
		else{
			return "ScheduleSuccess";
		}
		
	}
}
