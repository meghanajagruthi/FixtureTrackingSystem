package com.elecnor.lighting.bean;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.util.Set;


/**
 * The persistent class for the fixture_description database table.
 * 
 */
@Entity
@Table(name="FIXTURE_DESCRIPTION")
public class FixtureDescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DESC_ID")
	@Expose
	private int descId;

	@Column(name="DESC_TYPE")
	@Expose
	private String descType;

	//bi-directional many-to-one association to FixtureMaster
	@OneToMany(mappedBy="fixtureDescription")
	private Set<FixtureMaster> fixtureMasters;

	public FixtureDescription() {
    }

	public int getDescId() {
		return this.descId;
	}

	public void setDescId(int descId) {
		this.descId = descId;
	}

	public String getDescType() {
		return this.descType;
	}

	public void setDescType(String descType) {
		this.descType = descType;
	}

	public Set<FixtureMaster> getFixtureMasters() {
		return this.fixtureMasters;
	}

	public void setFixtureMasters(Set<FixtureMaster> fixtureMasters) {
		this.fixtureMasters = fixtureMasters;
	}
	
}