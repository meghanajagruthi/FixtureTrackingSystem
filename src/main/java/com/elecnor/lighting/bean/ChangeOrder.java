package com.elecnor.lighting.bean;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * The persistent class for the change_order database table.
 * 
 */

@Entity
@Table(name = "CHANGE_ORDER")
public class ChangeOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CHANGE_ORDER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	private Long changeOrderId;

	@Column(name = "CHANGE_ORDER_COMMENTS")
	@Expose
	private String changeOrderComments;

	@Temporal(TemporalType.DATE)
	@Column(name = "CHANGE_ORDER_DATE")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Expose
	private Date changeOrderDate;

	@Column(name = "GCRFI")
	@Expose
	private String gcrfi;

	@Column(name = "MMC_PCO")
	@Expose
	private String mmcPco;

	@Column(name = "NEW_QUANTITY")
	@Expose
	private Integer newQuantity;

	@Column(name = "QUANTITY")
	@Expose
	private Integer quantity;

	@Temporal(TemporalType.DATE)
	@Column(name = "SUBMITTED_DATE")
	@Expose
	private Date submittedDate;

	// bi-directional many-to-one association to FixtureMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIXTURE_ID")
	@Expose
	private FixtureMaster fixtureMasterForChangeOrder;

	@Column(name = "SUBMITTED_BY_ID")
	@Expose
	private Long submittedById;
	
	@Column(name = "SUBMITTED_BY_NAME")
	@Expose
	private String submittedByName;

	@Transient
	@Expose
	private Long qtyForBaseOrder;
	
	public Long getQtyForBaseOrder() {
		return qtyForBaseOrder;
	}

	public void setQtyForBaseOrder(Long qtyForBaseOrder) {
		this.qtyForBaseOrder = qtyForBaseOrder;
	}

	public ChangeOrder() {
	}

	public Long getChangeOrderId() {
		return changeOrderId;
	}

	public void setChangeOrderId(Long changeOrderId) {
		this.changeOrderId = changeOrderId;
	}

	public String getChangeOrderComments() {
		return changeOrderComments;
	}

	public void setChangeOrderComments(String changeOrderComments) {
		this.changeOrderComments = changeOrderComments;
	}

	public Date getChangeOrderDate() {
		return changeOrderDate;
	}

	public void setChangeOrderDate(Date changeOrderDate) {
		this.changeOrderDate = changeOrderDate;
	}

	public String getGcrfi() {
		return gcrfi;
	}

	public void setGcrfi(String gcrfi) {
		this.gcrfi = gcrfi;
	}

	public String getMmcPco() {
		return mmcPco;
	}

	public void setMmcPco(String mmcPco) {
		this.mmcPco = mmcPco;
	}

	public Integer getNewQuantity() {
		return newQuantity;
	}

	public void setNewQuantity(Integer newQuantity) {
		this.newQuantity = newQuantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public FixtureMaster getFixtureMasterForChangeOrder() {
		return fixtureMasterForChangeOrder;
	}

	public void setFixtureMasterForChangeOrder(
			FixtureMaster fixtureMasterForChangeOrder) {
		this.fixtureMasterForChangeOrder = fixtureMasterForChangeOrder;
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


	/*@Override
	public String toString() {
		return " Change Order id : " + changeOrderId + "  Change Order Date: "
				+ changeOrderDate + "  Change Order Comments: "
				+ changeOrderComments + " MMC PCO: " + mmcPco + " GCRFI: "
				+ gcrfi + " Quantity: " + quantity + " New Quantity: "
				+ newQuantity;
	}*/

}