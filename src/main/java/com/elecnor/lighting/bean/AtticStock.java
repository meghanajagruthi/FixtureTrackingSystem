package com.elecnor.lighting.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.util.Date;


/**
 * The persistent class for the attic_stock database table.
 * 
 */
@Entity
@Table(name="ATTIC_STOCK")
public class AtticStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ATTIC_STOCK_ID")
	@Expose
	private Long atticStockId;

	@Column(name="ATTIC_STOCK_COUNT")
	@Expose
	private Integer atticStockCount;

	@Column(name="SPARE_COUNT")
	@Expose
	private Integer spareCount;

    @Temporal( TemporalType.DATE)
	@Column(name="SUBMITTED_DATE")
    @Expose
	private Date submittedDate;

	//bi-directional many-to-one association to FixtureMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FIXTURE_ID")
	@Expose
	private FixtureMaster atticStockForFixtureMaster;

	@Column(name = "SUBMITTED_BY_ID")
	@Expose
	private Long submittedById;
	
	@Column(name = "SUBMITTED_BY_NAME")
	@Expose
	private String submittedByName;

    public AtticStock() {
    }

	public Long getAtticStockId() {
		return this.atticStockId;
	}

	public Integer getAtticStockCount() {
		return atticStockCount;
	}

	public void setAtticStockCount(Integer atticStockCount) {
		this.atticStockCount = atticStockCount;
	}

	public Integer getSpareCount() {
		return spareCount;
	}

	public void setSpareCount(Integer spareCount) {
		this.spareCount = spareCount;
	}

	public void setAtticStockId(Long atticStockId) {
		this.atticStockId = atticStockId;
	}

	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	/**
	 * @return the atticStockForFixtureMaster
	 */
	public FixtureMaster getAtticStockForFixtureMaster() {
		return atticStockForFixtureMaster;
	}

	/**
	 * @param atticStockForFixtureMaster the atticStockForFixtureMaster to set
	 */
	public void setAtticStockForFixtureMaster(
			FixtureMaster atticStockForFixtureMaster) {
		this.atticStockForFixtureMaster = atticStockForFixtureMaster;
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