package com.elecnor.lighting.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.util.Set;


/**
 * The persistent class for the fixture_manufacturer database table.
 * 
 */
@Entity
@Table(name="FIXTURE_MANUFACTURER")
public class FixtureManufacturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MANUFACTURER_ID")
	@Expose
	private int manufacturerId;

	@Column(name="MANUFACTURER_TYPE")
	@Expose
	private String manufacturerType;
	
	//bi-directional many-to-one association to FixtureMaster
	@OneToMany(mappedBy="fixtureManufacturer")
	private Set<FixtureMaster> fixtureMasters;

    public FixtureManufacturer() {
    }

	public int getManufacturerId() {
		return this.manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerType() {
		return this.manufacturerType;
	}

	public void setManufacturerType(String manufacturerType) {
		this.manufacturerType = manufacturerType;
	}

	public Set<FixtureMaster> getFixtureMasters() {
		return this.fixtureMasters;
	}

	public void setFixtureMasters(Set<FixtureMaster> fixtureMasters) {
		this.fixtureMasters = fixtureMasters;
	}
	
}