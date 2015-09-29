package com.elecnor.lighting.bean;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the fixture_tracking database table.
 * 
 */
@Entity
@Table(name = "FIXTURE_TRACKING")
@NamedQuery(name = "FixtureTracking.findAll", query = "SELECT f FROM FixtureTracking f")
public class FixtureTracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TRACKING_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	private String trackingId;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ACTUAL_DELIVERY")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Expose
	private Date dateActualDelivery;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ACTUAL_RECEIVED")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Expose
	private Date dateActualReceived;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_APPROVED")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Expose
	private Date dateApproved;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ESTIMATED_DELIVERY")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Expose
	private Date dateEstimatedDelivery;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ESTIMATED_RECEIVED")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Expose
	private Date dateEstimatedReceived;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_NEEDED_ONSITE")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Expose
	private Date dateNeededOnsite;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_RELEASE_VENDOR")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Expose
	private Date dateReleaseVendor;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_SUBMITTED")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Expose
	private Date dateSubmitted;

	/* ==============Fixture Transient Details============ */
	@Transient
	@Expose
	private Integer badFixtureQty;
	@Transient
	@Expose
	private String fixIssue;
	@Transient
	@Expose
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date fixRecorderDate;
	@Transient
	@Expose
	private String fixPictureTaken;
	@Transient
	@Expose
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date fixPmInformedDate;
	@Transient
	@Expose
	private String fixType;
	@Transient
	@Expose
	private String fixVendor;
	@Transient
	@Expose
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date fixVendorInformedDate;

	/* ==============Lamp Transient Details============ */

	@Transient
	@Expose
	private Integer badLampQty;
	@Transient
	@Expose
	private String lampIssue;
	@Transient
	@Expose
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date lampRecorderDate;
	@Transient
	@Expose
	private String lampPictureTaken;
	@Transient
	@Expose
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date lampPmInformedDate;
	@Transient
	@Expose
	private String lampType;
	@Transient
	@Expose
	private String lampVendor;
	@Transient
	@Expose
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date lampVendorInformedDate;
	@Transient
	@Expose
	private FixtureTracking BadFixtureForfixtureTracking;

	public Integer getBadFixtureQty() {
		return badFixtureQty;
	}

	public void setBadFixtureQty(Integer badFixtureQty) {
		this.badFixtureQty = badFixtureQty;
	}

	public Integer getBadLampQty() {
		return badLampQty;
	}

	public void setBadLampQty(Integer badLampQty) {
		this.badLampQty = badLampQty;
	}

	public FixtureTracking getBadFixtureForfixtureTracking() {
		return BadFixtureForfixtureTracking;
	}

	public String getFixIssue() {
		return fixIssue;
	}

	public void setFixIssue(String fixIssue) {
		this.fixIssue = fixIssue;
	}

	public Date getFixRecorderDate() {
		return fixRecorderDate;
	}

	public void setFixRecorderDate(Date fixRecorderDate) {
		this.fixRecorderDate = fixRecorderDate;
	}

	public String getFixPictureTaken() {
		return fixPictureTaken;
	}

	public void setFixPictureTaken(String fixPictureTaken) {
		this.fixPictureTaken = fixPictureTaken;
	}

	public Date getFixPmInformedDate() {
		return fixPmInformedDate;
	}

	public void setFixPmInformedDate(Date fixPmInformedDate) {
		this.fixPmInformedDate = fixPmInformedDate;
	}

	public String getFixType() {
		return fixType;
	}

	public void setFixType(String fixType) {
		this.fixType = fixType;
	}

	public String getFixVendor() {
		return fixVendor;
	}

	public void setFixVendor(String fixVendor) {
		this.fixVendor = fixVendor;
	}

	public Date getFixVendorInformedDate() {
		return fixVendorInformedDate;
	}

	public void setFixVendorInformedDate(Date fixVendorInformedDate) {
		this.fixVendorInformedDate = fixVendorInformedDate;
	}

	public String getLampIssue() {
		return lampIssue;
	}

	public void setLampIssue(String lampIssue) {
		this.lampIssue = lampIssue;
	}

	public Date getLampRecorderDate() {
		return lampRecorderDate;
	}

	public void setLampRecorderDate(Date lampRecorderDate) {
		this.lampRecorderDate = lampRecorderDate;
	}

	public String getLampPictureTaken() {
		return lampPictureTaken;
	}

	public void setLampPictureTaken(String lampPictureTaken) {
		this.lampPictureTaken = lampPictureTaken;
	}

	public Date getLampPmInformedDate() {
		return lampPmInformedDate;
	}

	public void setLampPmInformedDate(Date lampPmInformedDate) {
		this.lampPmInformedDate = lampPmInformedDate;
	}

	public String getLampType() {
		return lampType;
	}

	public void setLampType(String lampType) {
		this.lampType = lampType;
	}

	public String getLampVendor() {
		return lampVendor;
	}

	public void setLampVendor(String lampVendor) {
		this.lampVendor = lampVendor;
	}

	public Date getLampVendorInformedDate() {
		return lampVendorInformedDate;
	}

	public void setLampVendorInformedDate(Date lampVendorInformedDate) {
		this.lampVendorInformedDate = lampVendorInformedDate;
	}

	public void setBadFixtureForfixtureTracking(
			FixtureTracking badFixtureForfixtureTracking) {
		BadFixtureForfixtureTracking = badFixtureForfixtureTracking;
	}

	@Column(name = "FIXTURE_GOOD")
	@Expose
	private Integer fixtureGood;

	@Column(name = "LAMP_GOOD")
	@Expose
	private Integer lampGood;

	@Column(name = "FIXTURE_QTY")
	@Expose
	private Integer fixtureQty;

	@Column(name = "LAMP_QTY")
	@Expose
	private Integer lampQty;

	@Temporal(TemporalType.DATE)
	@Column(name = "SUBMITTED_DATE")
	private Date submittedDate;

	// bi-directional many-to-one association to BadFixtureLamp
	@OneToMany(mappedBy = "BadFixtureForfixtureTracking")
	private Set<BadFixtureLamp> badFixtureLamps;

	// bi-directional many-to-one association to FixtureMaster
	@ManyToOne
	@JoinColumn(name = "FIXTURE_ID")
	private FixtureMaster fixtureTrackingForFixtureMaster;

	@Column(name = "SUBMITTED_BY_ID")
	@Expose
	private Long submittedById;
	
	@Column(name = "SUBMITTED_BY_NAME")
	@Expose
	private String submittedByName;

	public FixtureTracking() {
	}

	public String getTrackingId() {
		return this.trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public Date getDateActualDelivery() {
		return this.dateActualDelivery;
	}

	public void setDateActualDelivery(Date dateActualDelivery) {
		this.dateActualDelivery = dateActualDelivery;
	}

	public Date getDateActualReceived() {
		return this.dateActualReceived;
	}

	public void setDateActualReceived(Date dateActualReceived) {
		this.dateActualReceived = dateActualReceived;
	}

	public Date getDateApproved() {
		return this.dateApproved;
	}

	public void setDateApproved(Date dateApproved) {
		this.dateApproved = dateApproved;
	}

	public Date getDateEstimatedDelivery() {
		return this.dateEstimatedDelivery;
	}

	public void setDateEstimatedDelivery(Date dateEstimatedDelivery) {
		this.dateEstimatedDelivery = dateEstimatedDelivery;
	}

	public Date getDateEstimatedReceived() {
		return this.dateEstimatedReceived;
	}

	public void setDateEstimatedReceived(Date dateEstimatedReceived) {
		this.dateEstimatedReceived = dateEstimatedReceived;
	}

	public Date getDateNeededOnsite() {
		return this.dateNeededOnsite;
	}

	public void setDateNeededOnsite(Date dateNeededOnsite) {
		this.dateNeededOnsite = dateNeededOnsite;
	}

	public Date getDateReleaseVendor() {
		return this.dateReleaseVendor;
	}

	public void setDateReleaseVendor(Date dateReleaseVendor) {
		this.dateReleaseVendor = dateReleaseVendor;
	}

	public Date getDateSubmitted() {
		return this.dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Integer getFixtureGood() {
		return this.fixtureGood;
	}

	public void setFixtureGood(Integer fixtureGood) {
		this.fixtureGood = fixtureGood;
	}

	public Integer getFixtureQty() {
		return this.fixtureQty;
	}

	public void setFixtureQty(Integer fixtureQty) {
		this.fixtureQty = fixtureQty;
	}

	public Integer getLampQty() {
		return this.lampQty;
	}

	public void setLampQty(Integer lampQty) {
		this.lampQty = lampQty;
	}

	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Set<BadFixtureLamp> getBadFixtureLamps() {
		return this.badFixtureLamps;
	}

	public void setBadFixtureLamps(Set<BadFixtureLamp> badFixtureLamps) {
		this.badFixtureLamps = badFixtureLamps;
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

	public FixtureMaster getFixtureTrackingForFixtureMaster() {
		return fixtureTrackingForFixtureMaster;
	}

	public void setFixtureTrackingForFixtureMaster(
			FixtureMaster fixtureTrackingForFixtureMaster) {
		this.fixtureTrackingForFixtureMaster = fixtureTrackingForFixtureMaster;
	}

	public Integer getLampGood() {
		return lampGood;
	}

	public void setLampGood(Integer lampGood) {
		this.lampGood = lampGood;
	}

	@Override
	public String toString() {
		return "trackingId : " + trackingId + " dateActualDelivery:"
				+ dateActualDelivery + " dateActualReceived:"
				+ dateActualReceived + " dateApproved: " + dateApproved
				+ " dateEstimatedDelivery:" + dateEstimatedDelivery
				+ " dateEstimatedReceived:" + dateEstimatedReceived
				+ " dateNeededOnsite: " + dateNeededOnsite
				+ " dateReleaseVendor" + dateReleaseVendor + " dateSubmitted"
				+ dateSubmitted + " fixtureGood:" + fixtureGood + " fixtureQty"
				+ fixtureQty + " lampQty : " + lampQty + "fixtureVendor : "
				+ fixVendor + "fixIssue: " + fixIssue + "fixPictureTaken: "
				+ fixPictureTaken + "fixPmInformedDate: " + fixPmInformedDate
				+ "fixVendorInformedDate: " + fixVendorInformedDate
				+ "fixRecorderDate: " + fixRecorderDate+"fixType: "+fixType;
	}
}