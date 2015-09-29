package com.elecnor.lighting.dao;

import java.util.List;

import com.elecnor.lighting.bean.FixtureDescription;
import com.elecnor.lighting.bean.FixtureManufacturer;
import com.elecnor.lighting.bean.FixtureVariant;
import com.elecnor.lighting.bean.LampCatalogNum;
import com.elecnor.lighting.bean.LampManufacturer;

public interface MastreFixtureDAO {

	// Adding and Getting method for Fixture Variant
	public void addFixtureVariant(FixtureVariant fixVariantType);

	public List<FixtureVariant> getFixtureVariant();

	// Adding and Getting method for Fixture Description
	public void addFixtureDescription(FixtureDescription fixDesc);

	public List<FixtureDescription> getFixtureDescription();

	// Adding and Getting method for Fixture Manufacturer
	public void addFixtureManufacturer(FixtureManufacturer fixManufacturer);

	public List<FixtureManufacturer> getFixtureManufacturer();

	// Adding and Getting method for Lamp Manufacturer
	public void addLampManufacturer(LampManufacturer lampManufacturer);

	public List<LampManufacturer> getLampManufacturerDetails();

	// Adding and Getting method for Lamp Catalog Number
	public void addLampCatalogNo(LampCatalogNum lampCatalogNum);

	public List<LampCatalogNum> getLampCatalogNoDetails();

}
