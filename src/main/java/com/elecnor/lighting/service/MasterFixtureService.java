package com.elecnor.lighting.service;

import java.util.List;

import com.elecnor.lighting.bean.FixtureDescription;
import com.elecnor.lighting.bean.FixtureManufacturer;
import com.elecnor.lighting.bean.FixtureVariant;
import com.elecnor.lighting.bean.LampCatalogNum;
import com.elecnor.lighting.bean.LampManufacturer;

public interface MasterFixtureService {

	//Adding and Getting method for Fixture Variant
	public void addFixtureVariant(String fixVariantType);
	public List<FixtureVariant> getFixtureVariant();

	//Adding and Getting method for Fixture Description
	public void addFixtureDescription(String fixDesc);
	public List<FixtureDescription> getFixtureDescription();
	
	//Adding and Getting method for Fixture Manufacturer
	public void addFixtureManufacturer(String fixManufacturer);
	public List<FixtureManufacturer> getFixtureManufacturer();
	
	//Adding and Getting method for Lamp Manufacturer
	public void addLampManufacturer(String lampManufacturer);
	public List<LampManufacturer> getLampManufacturerDetails();
	
	//Adding and Getting method for Lamp Catalog Number
	public void addLampCatalogNo(String lampCatalog);
	public List<LampCatalogNum> getLampCatalogNoDetails();
	
	
	
}
