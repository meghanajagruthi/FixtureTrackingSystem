package com.elecnor.lighting.bean;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * The persistent class for the fixture_issues database table.
 * 
 */
@Entity
@Table(name = "FIXTURE_ISSUES")
public class FixtureIssue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ISSUE_ID")
	@Expose
	private Long issueId;

	@Column(name = "ASSIGNED_TO")
	@Expose
	private String assignedTo;

	@Temporal(TemporalType.DATE)
	@Column(name = "ISSUE_DATE")
	@Expose
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date issueDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "RESOLVED_DATE")
	@Expose
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date resolvedDate;

	@Column(name = "STATUS")
	@Expose
	private String issueStatus;

	@Column(name = "ISSUE")
	@Expose
	private String issueProb;

	@Temporal(TemporalType.DATE)
	@Column(name = "SUBMITTED_DATE")
	@Expose
	private Date submittedDate;

	@Column(name = "SUBMITTED_BY_ID")
	@Expose
	private Long submittedById;
	
	@Column(name = "SUBMITTED_BY_NAME")
	@Expose
	private String submittedByName;

	// bi-directional many-to-one association to FixtureMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIXTURE_ID")
	@Expose
	private FixtureMaster issuesForFixtureID;

	public FixtureIssue() {
	}

	@Override
	public String toString() {
		return " Issue id : " + issueId + "  Issue: " + issueProb
				+ "  Issue Status: " + issueStatus + " Issue Date: "
				+ issueDate + " Resolved Date: " + resolvedDate;
	}

	public Long getIssueId() {
		return this.issueId;
	}

	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	public String getAssignedTo() {
		return this.assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public String getIssueProb() {
		return issueProb;
	}

	public void setIssueProb(String issueProb) {
		this.issueProb = issueProb;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	/**
	 * @return the issuesForFixtureID
	 */
	public FixtureMaster getIssuesForFixtureID() {
		return issuesForFixtureID;
	}

	/**
	 * @param issuesForFixtureID
	 *            the issuesForFixtureID to set
	 */
	public void setIssuesForFixtureID(FixtureMaster issuesForFixtureID) {
		this.issuesForFixtureID = issuesForFixtureID;
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