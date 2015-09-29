package com.elecnor.lighting.bean;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Formula;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * The persistent class for the user_profile database table.
 * 
 */
public class UserProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName ("userId")
	private Long sNo;

	@Expose
	private String emailId;

	@Expose
	private String firstName;

	@Expose
	private String lastName;

	@Expose
	private String middleName;

	@Expose
	private String password;

	@Expose
	private String role;
	
	@Transient
	private String supervisorSelect;
	
	@Expose
	private String status;
	@Transient
	@Expose
	private String supervisorName;
	@Transient
	@Expose
	private Integer supervisorId;

	@Temporal(TemporalType.DATE)
	private Date submittedDate;

	@Expose
	private String userId1;

	private UserProfile supervisorUserProfile;

    @Expose
	private UserProfile submittedBy;

    @Expose
	@Formula("DOMAIN_ID")
	private Long domainIdTransient;
	

	public Long getDomainIdTransient() {
		return domainIdTransient;
	}

	public void setDomainIdTransient(Long domainIdTransient) {
		this.domainIdTransient = domainIdTransient;
	}

    @Expose
	private DomainDetail domainDetail;
    
	public UserProfile() {
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
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


	public String getUserId1() {
		return userId1;
	}

	public void setUserId1(String userId1) {
		this.userId1 = userId1;
	}


	public Long getsNo() {
		return sNo;
	}

	public void setsNo(Long sNo) {
		this.sNo = sNo;
	}

	public UserProfile getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(UserProfile submittedBy) {
		this.submittedBy = submittedBy;
	}

	public DomainDetail getDomainDetail() {
		return domainDetail;
	}

	public void setDomainDetail(DomainDetail domainDetail) {
		this.domainDetail = domainDetail;
	}

	public UserProfile getSupervisorUserProfile() {
		return supervisorUserProfile;
	}

	public void setSupervisorUserProfile(UserProfile supervisorUserProfile) {
		this.supervisorUserProfile = supervisorUserProfile;
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public Integer getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(Integer supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getSupervisorSelect() {
		return supervisorSelect;
	}

	public void setSupervisorSelect(String supervisorSelect) {
		this.supervisorSelect = supervisorSelect;
	}

}