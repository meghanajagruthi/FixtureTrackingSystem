package com.elecnor.lighting.bean;

import java.io.Serializable;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.util.Set;


/**
 * The persistent class for the fixture_variant database table.
 * 
 */
@Entity
@Table(name="FIXTURE_VARIANT")
public class FixtureVariant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Variant Id is -->"+variantId;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VARIANT_ID")
	@Expose
	private int variantId;

	@Column(name="VARIANT_TYPE")
	@Expose
	private String variantType;

	//bi-directional many-to-one association to FixtureMaster
	@OneToMany(mappedBy="fixtureVariant", fetch=FetchType.LAZY)
	private Set<FixtureMaster> fixtureMasters;

    public FixtureVariant() {
    }

	public int getVariantId() {
		return this.variantId;
	}

	public void setVariantId(int variantId) {
		this.variantId = variantId;
	}

	public String getVariantType() {
		return this.variantType;
	}

	public void setVariantType(String variantType) {
		this.variantType = variantType;
	}

	public Set<FixtureMaster> getFixtureMasters() {
		return this.fixtureMasters;
	}

	public void setFixtureMasters(Set<FixtureMaster> fixtureMasters) {
		this.fixtureMasters = fixtureMasters;
	}
	
}