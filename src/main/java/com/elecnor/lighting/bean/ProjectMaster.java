package com.elecnor.lighting.bean;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the project_master database table.
 * 
 */
public class ProjectMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Expose
	private Long jobId;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Expose
	private Date endDate;

	@Expose
	private String jobName;

	@Expose
	private String jobNumber;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Expose
	private Date startDate;

	@Expose
	private String status;

	@Temporal(TemporalType.DATE)
	private Date submittedDate;

	// bi-directional many-to-one association to FixtureMaster
	@OneToMany(mappedBy = "projectMaster")
	private Set<FixtureMaster> fixtureMasters;

	// bi-directional many-to-one association to UserProfile
	@Expose
	private UserProfile manager;

	// bi-directional many-to-one association to UserProfile
	
	@Expose
	private UserProfile supervisor;

	// bi-directional many-to-one association to UserProfile
	@Expose
	private UserProfile submittedBy;

	// bi-directional many-to-one association to UserProfile
    @Expose
	private UserProfile updatedBy;

	public ProjectMaster() {
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Set<FixtureMaster> getFixtureMasters() {
		return this.fixtureMasters;
	}

	public void setFixtureMasters(Set<FixtureMaster> fixtureMasters) {
		this.fixtureMasters = fixtureMasters;
	}


	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public UserProfile getManager() {
		return manager;
	}

	public void setManager(UserProfile manager) {
		this.manager = manager;
	}

	public UserProfile getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(UserProfile supervisor) {
		this.supervisor = supervisor;
	}

	public UserProfile getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(UserProfile submittedBy) {
		this.submittedBy = submittedBy;
	}

	public UserProfile getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(UserProfile updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "Proj Name : " + jobName + "Number : " + jobNumber
				+ "Id : " + jobId + "Start Da : " + startDate + "End Da : "
				+ endDate + "Stat : " + status;
	}

}