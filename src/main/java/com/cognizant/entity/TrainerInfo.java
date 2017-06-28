package com.cognizant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="TRAINER_INFO")
public class TrainerInfo {

	@Id
	@Column(name="TRAINER_ID")
	int trainerId;
	
	@Column(name="TRAINER_NAME")
	String traineName;
	
	@Column(name="COLLEGE_NAME")
	String collegeName;
	
	@Column(name="DOMAIN")
	String domain;
	
	@OneToMany(mappedBy="trainerInfo", cascade=CascadeType.ALL)
	private List<ScheduleTraining> scheduleTraining;

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTraineName() {
		return traineName;
	}

	public void setTraineName(String traineName) {
		this.traineName = traineName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public List<ScheduleTraining> getScheduleTraining() {
		return scheduleTraining;
	}

	public void setScheduleTraining(List<ScheduleTraining> scheduleTraining) {
		this.scheduleTraining = scheduleTraining;
	}

	public TrainerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainerInfo(int trainerId, String traineName, String collegeName, String domain,
			List<ScheduleTraining> scheduleTraining) {
		super();
		this.trainerId = trainerId;
		this.traineName = traineName;
		this.collegeName = collegeName;
		this.domain = domain;
		this.scheduleTraining = scheduleTraining;
	}
	
	public TrainerInfo(int trainerId, String traineName, String collegeName, String domain) {
		super();
		this.trainerId = trainerId;
		this.traineName = traineName;
		this.collegeName = collegeName;
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "TrainerInfo [trainerId=" + trainerId + ", traineName=" + traineName + ", collegeName=" + collegeName
				+ ", domain=" + domain + "]";
	}

/*	@Override
	public String toString() {
		return "TrainerInfo [trainerId=" + trainerId + ", traineName=" + traineName + ", collegeName=" + collegeName
				+ ", domain=" + domain + ", scheduleTraining=" + scheduleTraining + "]";
	}
	*/
	
	
}
