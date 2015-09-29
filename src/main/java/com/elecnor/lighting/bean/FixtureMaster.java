package com.elecnor.lighting.bean;

import java.io.Serializable;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the fixture_master database table.
 * 
 */
@Entity
@Table(name = "FIXTURE_MASTER")
public class FixtureMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FIXTURE_ID")
	@Expose
	private Long fixtureId;

	@Column(name = "ADDITIONAL_PART")
	@Expose
	private String additionalPart;

	@Column(name = "COMMENTS")
	@Expose
	private String comments;

	@Column(name = "FIXRURE_CATALOG_NUM")
	@Expose
	private String fixrureCatalogNum;

	@Column(name = "FIXTURE_TYPE")
	@Expose
	private String fixtureType;

	@Column(name = "LAMP_QTY_PER_FIXTURE")
	@Expose
	private Integer lampQtyPerFixture;
  
	@Column(name = "SUBMITTED_BY_ID")
	private Long submittedById;
	
	@Column(name = "SUBMITTED_BY_NAME")
	private String submittedByName;
	
	
	@Column(name = "STATUS")
	@Expose
	private String status;

	@Transient
	private String fixtureVariantTrans;
	@Transient
	private String fixDescriptionTrans;
	@Transient
	private String fixManufacturerTrans;
	@Transient
	private String lampMadeByTrans;
	@Transient
	private String lampCatalogNoTrans;

	@Transient
	@Expose
	private Long aSheetCount;
	@Transient
	@Expose
	private Long eSheetCount;
	@Transient
	@Expose
	private Long attickCount;
	@Transient
	@Expose
	private Long spareCount;
	@Transient
	@Expose
	private Long qtyPerBaseOrder;
	@Transient
	@Expose
	private Integer fixtureQuantity;
	@Transient
	@Expose
	private Integer lampQuantity;
	@Transient
	@Expose
	private Integer fixtureGood;
	@Transient
	@Expose
	private Integer lampGood;
	@Transient
	@Expose
	private Integer issueCount;
	@Transient
	@Expose
	private Integer changeOrder;

	@Override
	public String toString() {
		return " fix id : " + fixtureId + "  fixtureType: " + fixtureType
				+ "  fixrureCatalogNum: " + fixrureCatalogNum + "  "
				+ additionalPart + comments + " fixtureVariantTrans : "
				+ fixtureVariantTrans + " fixDescriptionTrans : "
				+ fixDescriptionTrans + " fixManufacturerTrans : "
				+ fixManufacturerTrans + " lampMadeByTrans : "
				+ lampMadeByTrans + " lampCatalogNoTrans : "
				+ lampCatalogNoTrans;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SUBMITTED_DATE")
	private Date submittedDate;

	// bi-directional many-to-one association to ADesign
	@OneToMany(mappedBy = "aDesignForFixtureID")
	private Set<ADesign> ADesigns;

	// bi-directional many-to-one association to EDesign
	@OneToMany(mappedBy = "eDesignForFixtureID")
	private Set<EDesign> EDesigns;

	
	// bi-directional many-to-one association to FixtureIssue
	@OneToMany(mappedBy = "issuesForFixtureID")
	private Set<FixtureIssue> fixtureIssues;

	@Column(name = "PROJECT_ID")
	@Expose
	private Long projectMasterId;
	
	@Column(name = "PROJECT_NAME")
	@Expose
	private String projectName;
	
	@Column(name = "PROJECT_NUMBER")
	@Expose
	private String projectNumber;

	// bi-directional many-to-one association to FixtureVariant
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FIXTURE_VARIANT_ID")
	@Expose
	private FixtureVariant fixtureVariant;

	// bi-directional many-to-one association to FixtureDescription
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FIXTURE_DESC_ID")
	@Expose
	private FixtureDescription fixtureDescription;

	// bi-directional many-to-one association to FixtureManufacturer
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FIXTURE_MANUFACTURER_ID")
	@Expose
	private FixtureManufacturer fixtureManufacturer;

	// bi-directional many-to-one association to LampManufacturer
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LAMP_MANUFACTURER_ID")
	@Expose
	private LampManufacturer lampManufacturer;

	// bi-directional many-to-one association to LampCatalogNum
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LAMP_CATALOG_NUM_ID")
	@Expose
	private LampCatalogNum lampCatalogNum;

	// bi-directional many-to-one association to AtticStock
	@OneToMany(mappedBy = "atticStockForFixtureMaster")
	private Set<AtticStock> atticStocks;

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

	// bi-directional many-to-one association to ADesign
	@OneToMany(mappedBy = "fixtureTrackingForFixtureMaster")
	private Set<FixtureTracking> fixtureTracking;

	public FixtureMaster() {
	}

	public Long getFixtureId() {
		return this.fixtureId;
	}

	public void setFixtureId(Long fixtureId) {
		this.fixtureId = fixtureId;
	}

	public String getAdditionalPart() {
		return this.additionalPart;
	}

	public void setAdditionalPart(String additionalPart) {
		this.additionalPart = additionalPart;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getFixrureCatalogNum() {
		return this.fixrureCatalogNum;
	}

	public void setFixrureCatalogNum(String fixrureCatalogNum) {
		this.fixrureCatalogNum = fixrureCatalogNum;
	}

	public String getFixtureType() {
		return this.fixtureType;
	}

	public void setFixtureType(String fixtureType) {
		this.fixtureType = fixtureType;
	}

	public Integer getLampQtyPerFixture() {
		return this.lampQtyPerFixture;
	}

	public void setLampQtyPerFixture(Integer lampQtyPerFixture) {
		this.lampQtyPerFixture = lampQtyPerFixture;
	}

	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Set<ADesign> getADesigns() {
		return this.ADesigns;
	}

	public void setADesigns(Set<ADesign> ADesigns) {
		this.ADesigns = ADesigns;
	}

	public Set<EDesign> getEDesigns() {
		return this.EDesigns;
	}

	public void setEDesigns(Set<EDesign> EDesigns) {
		this.EDesigns = EDesigns;
	}

	
	public Set<FixtureIssue> getFixtureIssues() {
		return this.fixtureIssues;
	}

	public void setFixtureIssues(Set<FixtureIssue> fixtureIssues) {
		this.fixtureIssues = fixtureIssues;
	}


	public Long getProjectMasterId() {
		return projectMasterId;
	}

	public void setProjectMasterId(Long projectMasterId) {
		this.projectMasterId = projectMasterId;
	}


	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public FixtureVariant getFixtureVariant() {
		return this.fixtureVariant;
	}

	public void setFixtureVariant(FixtureVariant fixtureVariant) {
		this.fixtureVariant = fixtureVariant;
	}

	public FixtureDescription getFixtureDescription() {
		return this.fixtureDescription;
	}

	public void setFixtureDescription(FixtureDescription fixtureDescription) {
		this.fixtureDescription = fixtureDescription;
	}

	public FixtureManufacturer getFixtureManufacturer() {
		return this.fixtureManufacturer;
	}

	public void setFixtureManufacturer(FixtureManufacturer fixtureManufacturer) {
		this.fixtureManufacturer = fixtureManufacturer;
	}

	public LampManufacturer getLampManufacturer() {
		return this.lampManufacturer;
	}

	public void setLampManufacturer(LampManufacturer lampManufacturer) {
		this.lampManufacturer = lampManufacturer;
	}

	public LampCatalogNum getLampCatalogNum() {
		return this.lampCatalogNum;
	}

	public void setLampCatalogNum(LampCatalogNum lampCatalogNum) {
		this.lampCatalogNum = lampCatalogNum;
	}

	public Set<AtticStock> getAtticStocks() {
		return this.atticStocks;
	}

	public void setAtticStocks(Set<AtticStock> atticStocks) {
		this.atticStocks = atticStocks;
	}

	public String getFixtureVariantTrans() {
		return fixtureVariantTrans;
	}

	public void setFixtureVariantTrans(String fixtureVariantTrans) {
		this.fixtureVariantTrans = fixtureVariantTrans;
	}

	public String getFixDescriptionTrans() {
		return fixDescriptionTrans;
	}

	public void setFixDescriptionTrans(String fixDescriptionTrans) {
		this.fixDescriptionTrans = fixDescriptionTrans;
	}

	public String getFixManufacturerTrans() {
		return fixManufacturerTrans;
	}

	public void setFixManufacturerTrans(String fixManufacturerTrans) {
		this.fixManufacturerTrans = fixManufacturerTrans;
	}

	public String getLampMadeByTrans() {
		return lampMadeByTrans;
	}

	public void setLampMadeByTrans(String lampMadeByTrans) {
		this.lampMadeByTrans = lampMadeByTrans;
	}

	public String getLampCatalogNoTrans() {
		return lampCatalogNoTrans;
	}

	public void setLampCatalogNoTrans(String lampCatalogNoTrans) {
		this.lampCatalogNoTrans = lampCatalogNoTrans;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getaSheetCount() {
		return aSheetCount;
	}

	public void setaSheetCount(Long aSheetCount) {
		this.aSheetCount = aSheetCount;
	}

	public Long geteSheetCount() {
		return eSheetCount;
	}

	public void seteSheetCount(Long eSheetCount) {
		this.eSheetCount = eSheetCount;
	}

	public Long getQtyPerBaseOrder() {
		return qtyPerBaseOrder;
	}

	public void setQtyPerBaseOrder(Long qtyPerBaseOrder) {
		this.qtyPerBaseOrder = qtyPerBaseOrder;
	}

	public Long getAttickCount() {
		return attickCount;
	}

	public void setAttickCount(Long attickCount) {
		this.attickCount = attickCount;
	}

	public Long getSpareCount() {
		return spareCount;
	}

	public void setSpareCount(Long spareCount) {
		this.spareCount = spareCount;
	}

	public Set<FixtureTracking> getFixtureTracking() {
		return fixtureTracking;
	}

	public void setFixtureTracking(Set<FixtureTracking> fixtureTracking) {
		this.fixtureTracking = fixtureTracking;
	}

	public Integer getFixtureQuantity() {
		return fixtureQuantity;
	}

	public void setFixtureQuantity(Integer fixtureQuantity) {
		this.fixtureQuantity = fixtureQuantity;
	}

	public Integer getLampQuantity() {
		return lampQuantity;
	}

	public void setLampQuantity(Integer lampQuantity) {
		this.lampQuantity = lampQuantity;
	}

	public Integer getFixtureGood() {
		return fixtureGood;
	}

	public void setFixtureGood(Integer fixtureGood) {
		this.fixtureGood = fixtureGood;
	}

	public Integer getLampGood() {
		return lampGood;
	}

	public void setLampGood(Integer lampGood) {
		this.lampGood = lampGood;
	}

	public Integer getIssueCount() {
		return issueCount;
	}

	public void setIssueCount(Integer issueCount) {
		this.issueCount = issueCount;
	}

	public Integer getChangeOrder() {
		return changeOrder;
	}

	public void setChangeOrder(Integer changeOrder) {
		this.changeOrder = changeOrder;
	}
}