package com.elecnor.lighting.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.elecnor.lighting.bean.FixtureTracking;
import com.google.gson.annotations.Expose;

/**
 * The persistent class for the bad_fixture_lamp database table.
 * 
 */
@Entity
@Table(name = "BAD_FIXTURE_LAMP")
@NamedQuery(name = "BadFixtureLamp.findAll", query = "SELECT b FROM BadFixtureLamp b")
public class BadFixtureLamp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BAD_FIXTURE_ID")
	@Expose
	private String badFixtureId;

	@Column(name = "BAD_FIXTURE_QTY")
	@Expose
	private Integer badFixtureQty;

	@Column(name = "BAD_LAMP_QTY")
	@Expose
	private Integer badLampQty;

	@Temporal(TemporalType.DATE)
	@Column(name = "FIXTURE_RECORDER_DATE")
	@Expose
	private Date fixtureRecorderDate;

	@Column(name = "ISSUE")
	@Expose
	private String issue;

	@Column(name = "PICTURE_TAKEN")
	@Expose
	private String pictureTaken;

	@Temporal(TemporalType.DATE)
	@Expose
	@Column(name = "PM_INFORMED_DATE")
	private Date pmInformedDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "SUBMITTED_DATE")
	@Expose
	private Date submittedDate;

	@Column(name = "TYPE")
	@Expose
	private String type;

	@Column(name = "VENDOR")
	@Expose
	private String vendor;

	@Temporal(TemporalType.DATE)
	@Column(name = "VENDOR_INFORMED_DATE")
	@Expose
	private Date vendorInformedDate;

	// bi-directional many-to-one association to FixtureTracking
	@ManyToOne
	@JoinColumn(name = "TRACKING_ID")
	private FixtureTracking BadFixtureForfixtureTracking;

	@Column(name = "SUBMITTED_BY_ID")
	@Expose
	private Long submittedById;
	
	@Column(name = "SUBMITTED_BY_NAME")
	@Expose
	private String submittedByName;

	public BadFixtureLamp() {
	}

	public String getBadFixtureId() {
		return this.badFixtureId;
	}

	public void setBadFixtureId(String badFixtureId) {
		this.badFixtureId = badFixtureId;
	}

	public Integer getBadFixtureQty() {
		return this.badFixtureQty;
	}

	public void setBadFixtureQty(Integer badFixtureQty) {
		this.badFixtureQty = badFixtureQty;
	}

	public Integer getBadLampQty() {
		return this.badLampQty;
	}

	public void setBadLampQty(Integer badLampQty) {
		this.badLampQty = badLampQty;
	}

	public Date getFixtureRecorderDate() {
		return this.fixtureRecorderDate;
	}

	public void setFixtureRecorderDate(Date fixtureRecorderDate) {
		this.fixtureRecorderDate = fixtureRecorderDate;
	}

	public String getIssue() {
		return this.issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getPictureTaken() {
		return this.pictureTaken;
	}

	public void setPictureTaken(String pictureTaken) {
		this.pictureTaken = pictureTaken;
	}

	public Date getPmInformedDate() {
		return this.pmInformedDate;
	}

	public void setPmInformedDate(Date pmInformedDate) {
		this.pmInformedDate = pmInformedDate;
	}

	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Date getVendorInformedDate() {
		return this.vendorInformedDate;
	}

	public void setVendorInformedDate(Date vendorInformedDate) {
		this.vendorInformedDate = vendorInformedDate;
	}

	public FixtureTracking getBadFixtureForfixtureTracking() {
		return BadFixtureForfixtureTracking;
	}

	public void setBadFixtureForfixtureTracking(
			FixtureTracking badFixtureForfixtureTracking) {
		BadFixtureForfixtureTracking = badFixtureForfixtureTracking;
	}

	public Long getSubmittedById() {
		return submittedById;
	}

	public void setSubmittedById(Long submittedById) {
		this.submittedById = submittedById;
	}

	public String getSubmittedByName() {
		return submittedByName;
	}

	public void setSubmittedByName(String submittedByName) {
		this.submittedByName = submittedByName;
	}

}