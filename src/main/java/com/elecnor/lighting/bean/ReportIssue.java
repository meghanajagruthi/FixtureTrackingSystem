package com.elecnor.lighting.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="REPORT_ISSUE")
public class ReportIssue implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ISSUE_ID")
	private int issueId;
	
	@Column(name = "RELATED_PROJECT")
	private String relatedProject;
	
	@Column(name = "SEVERITY")
	private String severity;
	
	@Column(name = "RELATED_MODULE")
	private String relatedModule;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "COMMENT")
	private String addnlComment;
	
	@Column(name = "DEV_LOG")
	private String devLog;

	@Column(name="SUBMITTED_BY")
	private String submittedBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Transient
	private MultipartFile attachedFile;

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getRelatedProject() {
		return relatedProject;
	}

	public void setRelatedProject(String relatedProject) {
		this.relatedProject = relatedProject;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getRelatedModule() {
		return relatedModule;
	}

	public void setRelatedModule(String relatedModule) {
		this.relatedModule = relatedModule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddnlComment() {
		return addnlComment;
	}

	public void setAddnlComment(String addnlComment) {
		this.addnlComment = addnlComment;
	}

	public String getDevLog() {
		return devLog;
	}

	public void setDevLog(String devLog) {
		this.devLog = devLog;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public MultipartFile getAttachedFile() {
		return attachedFile;
	}

	public void setAttachedFile(MultipartFile attachedFile) {
		this.attachedFile = attachedFile;
	}
}
