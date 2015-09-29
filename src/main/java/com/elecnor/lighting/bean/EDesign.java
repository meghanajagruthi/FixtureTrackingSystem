package com.elecnor.lighting.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.util.Date;


/**
 * The persistent class for the e_design database table.
 * 
 */
@Entity
@Table(name="E_DESIGN")
public class EDesign implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="E_DESIGN_ID")
	@Expose
	private Long eDesignId;

	@Column(name="COMMENTS")
	@Expose
	private String comments;

	@Column(name="E_DESIGN_AREA")
	@Expose
	private String eDesignArea;

	@Column(name="E_DESIGN_COUNT")
	@Expose
	private Integer eDesignCount;

	@Column(name="E_DESIGN_DESC")
	@Expose
	private String eDesignDesc;

	@Column(name="E_DESIGN_LOCATION")
	@Expose
	private String eDesignLocation;

	@Column(name="E_DESIGN_NUM")
	@Expose
	private String eDesignNum;

    @Temporal( TemporalType.DATE)
    @Expose
	@Column(name="SUBMITTED_DATE")
	private Date submittedDate;

    @Column(name = "SUBMITTED_BY_ID")
 	@Expose
    private Long submittedById;
    
    @Column(name = "SUBMITTED_BY_NAME")
 	@Expose
    private String submittedByName;
    

	//bi-directional many-to-one association to FixtureMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FIXTURE_ID")
	@Expose
	private FixtureMaster eDesignForFixtureID;


    public EDesign() {
    }

	public Long getEDesignId() {
		return this.eDesignId;
	}

	public void setEDesignId(Long eDesignId) {
		this.eDesignId = eDesignId;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getEDesignArea() {
		return this.eDesignArea;
	}

	public void setEDesignArea(String eDesignArea) {
		this.eDesignArea = eDesignArea;
	}

	public Integer getEDesignCount() {
		return this.eDesignCount;
	}

	public void setEDesignCount(Integer eDesignCount) {
		this.eDesignCount = eDesignCount;
	}

	public String getEDesignDesc() {
		return this.eDesignDesc;
	}

	public void setEDesignDesc(String eDesignDesc) {
		this.eDesignDesc = eDesignDesc;
	}

	public String getEDesignLocation() {
		return this.eDesignLocation;
	}

	public void setEDesignLocation(String eDesignLocation) {
		this.eDesignLocation = eDesignLocation;
	}

	public String getEDesignNum() {
		return this.eDesignNum;
	}

	public void setEDesignNum(String eDesignNum) {
		this.eDesignNum = eDesignNum;
	}

	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	/**
	 * @return the eDesignForFixtureMaster
	 */
	public FixtureMaster geteDesignForFixtureMaster() {
		return eDesignForFixtureID;
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

	/**
	 * @param eDesignForFixtureMaster the eDesignForFixtureMaster to set
	 */
	public void seteDesignForFixtureMaster(FixtureMaster eDesignForFixtureID) {
		this.eDesignForFixtureID = eDesignForFixtureID;
	}

}