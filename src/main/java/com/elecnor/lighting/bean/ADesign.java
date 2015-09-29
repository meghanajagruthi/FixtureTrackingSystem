package com.elecnor.lighting.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * The persistent class for the a_design database table.
 * 
 */
@Entity
@Table(name = "A_DESIGN")
public class ADesign implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "A_DESIGN_ID")
	@Expose
	private Long aDesignId;

	@Column(name = "A_DESIGN_AREA")
	@Expose
	private String aDesignArea;

	@Column(name = "A_DESIGN_COUNT")
	@Expose
	private Integer aDesignCount;

	@Column(name = "A_DESIGN_DESC")
	@Expose
	private String aDesignDesc;

	@Column(name = "A_DESIGN_LOCATION")
	@Expose
	private String aDesignLocation;

	@Column(name = "A_DESIGN_NUM")
	@Expose
	private String aDesignNum;

	@Column(name = "COMMENTS")
	@Expose
	private String aSheetComments;

	@Temporal(TemporalType.DATE)
	@Column(name = "SUBMITTED_DATE")
	@Expose
	private Date submittedDate;

	// bi-directional many-to-one association to FixtureMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIXTURE_ID")
	@Expose
	private FixtureMaster aDesignForFixtureID;

	@Column(name = "SUBMITTED_BY_ID")
	@Expose
	private Long submittedById;
	
	@Column(name = "SUBMITTED_BY_NAME")
	@Expose
	private String submittedByName;

	public ADesign() {
	}

	public Long getADesignId() {
		return this.aDesignId;
	}

	public void setADesignId(Long aDesignId) {
		this.aDesignId = aDesignId;
	}

	public String getADesignArea() {
		return this.aDesignArea;
	}

	public void setADesignArea(String aDesignArea) {
		this.aDesignArea = aDesignArea;
	}

	public Integer getADesignCount() {
		return this.aDesignCount;
	}

	public void setADesignCount(Integer aDesignCount) {
		this.aDesignCount = aDesignCount;
	}

	public String getADesignDesc() {
		return this.aDesignDesc;
	}

	public void setADesignDesc(String aDesignDesc) {
		this.aDesignDesc = aDesignDesc;
	}

	public String getADesignLocation() {
		return this.aDesignLocation;
	}

	public void setADesignLocation(String aDesignLocation) {
		this.aDesignLocation = aDesignLocation;
	}

	public String getADesignNum() {
		return this.aDesignNum;
	}

	public void setADesignNum(String aDesignNum) {
		this.aDesignNum = aDesignNum;
	}

	public String getaSheetComments() {
		return aSheetComments;
	}

	public void setaSheetComments(String aSheetComments) {
		this.aSheetComments = aSheetComments;
	}

	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	/**
	 * @return the aDesignForFixtureID
	 */
	public FixtureMaster getaDesignForFixtureID() {
		return aDesignForFixtureID;
	}

	/**
	 * @param aDesignForFixtureID
	 *            the aDesignForFixtureID to set
	 */
	public void setaDesignForFixtureID(FixtureMaster aDesignForFixtureID) {
		this.aDesignForFixtureID = aDesignForFixtureID;
	}

	public Long getSubmittedById() {
		return submittedById;
	}

	public void setSubmittedById(Long submittedById) {
		this.submittedById = submittedById;
	}

	public Long getaDesignId() {
		return aDesignId;
	}

	public void setaDesignId(Long aDesignId) {
		this.aDesignId = aDesignId;
	}

	public String getaDesignArea() {
		return aDesignArea;
	}

	public void setaDesignArea(String aDesignArea) {
		this.aDesignArea = aDesignArea;
	}

	public Integer getaDesignCount() {
		return aDesignCount;
	}

	public void setaDesignCount(Integer aDesignCount) {
		this.aDesignCount = aDesignCount;
	}

	public String getaDesignDesc() {
		return aDesignDesc;
	}

	public void setaDesignDesc(String aDesignDesc) {
		this.aDesignDesc = aDesignDesc;
	}

	public String getaDesignLocation() {
		return aDesignLocation;
	}

	public void setaDesignLocation(String aDesignLocation) {
		this.aDesignLocation = aDesignLocation;
	}

	public String getaDesignNum() {
		return aDesignNum;
	}

	public void setaDesignNum(String aDesignNum) {
		this.aDesignNum = aDesignNum;
	}

	public String getSubmittedByName() {
		return submittedByName;
	}

	public void setSubmittedByName(String submittedByName) {
		this.submittedByName = submittedByName;
	}

}