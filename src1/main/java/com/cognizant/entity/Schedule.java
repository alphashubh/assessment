package com.cognizant.entity;

import javax.validation.Valid;

public class Schedule {
	
	@Valid
	ScheduleTraining scheduleTraining;
	@Valid
	 TrainerInfo trainerInfo;
	public ScheduleTraining getScheduleTraining() {
		return scheduleTraining;
	}
	public void setScheduleTraining(ScheduleTraining scheduleTraining) {
		this.scheduleTraining = scheduleTraining;
	}
	public TrainerInfo getTrainerInfo() {
		return trainerInfo;
	}
	public void setTrainerInfo(TrainerInfo trainerInfo) {
		this.trainerInfo = trainerInfo;
	}

}
