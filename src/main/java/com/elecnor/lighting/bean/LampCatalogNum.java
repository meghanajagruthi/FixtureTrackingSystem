package com.elecnor.lighting.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.util.Set;


/**
 * The persistent class for the lamp_catalog_num database table.
 * 
 */
@Entity
@Table(name="LAMP_CATALOG_NUM")
public class LampCatalogNum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CATALOG_ID")
	@Expose
	private int catalogId;

	@Column(name="CATALOG_TYPE")
	@Expose
	private String catalogType;
	
	//bi-directional many-to-one association to FixtureMaster
	@OneToMany(mappedBy="lampCatalogNum")
	private Set<FixtureMaster> fixtureMasters;

    public LampCatalogNum() {
    }

	public int getCatalogId() {
		return this.catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogType() {
		return this.catalogType;
	}

	public void setCatalogType(String catalogType) {
		this.catalogType = catalogType;
	}

	public Set<FixtureMaster> getFixtureMasters() {
		return this.fixtureMasters;
	}

	public void setFixtureMasters(Set<FixtureMaster> fixtureMasters) {
		this.fixtureMasters = fixtureMasters;
	}
	
}