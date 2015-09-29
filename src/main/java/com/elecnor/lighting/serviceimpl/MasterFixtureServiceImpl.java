package com.elecnor.lighting.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elecnor.lighting.bean.FixtureDescription;
import com.elecnor.lighting.bean.FixtureManufacturer;
import com.elecnor.lighting.bean.FixtureVariant;
import com.elecnor.lighting.bean.LampCatalogNum;
import com.elecnor.lighting.bean.LampManufacturer;
import com.elecnor.lighting.dao.MastreFixtureDAO;
import com.elecnor.lighting.service.MasterFixtureService;

@Service
public class MasterFixtureServiceImpl implements MasterFixtureService {

	@Autowired
	MastreFixtureDAO maFixtureDAO;

	@Override
	public void addFixtureVariant(String fixVariantType) {

		FixtureVariant fixtureVariant = new FixtureVariant();
		fixtureVariant.setVariantType(fixVariantType);
		maFixtureDAO.addFixtureVariant(fixtureVariant);
	}

	@Override
	public List<FixtureVariant> getFixtureVariant() {

		List<FixtureVariant> list = maFixtureDAO.getFixtureVariant();
		return list;
	}

	@Override
	public void addFixtureDescription(String fixDesc) {

		FixtureDescription fixtureDescription = new FixtureDescription();
		fixtureDescription.setDescType(fixDesc);
		maFixtureDAO.addFixtureDescription(fixtureDescription);
	}

	@Override
	public List<FixtureDescription> getFixtureDescription() {
		List<FixtureDescription> list = maFixtureDAO.getFixtureDescription();
		return list;
	}

	@Override
	public void addFixtureManufacturer(String fixManufacturer) {

		FixtureManufacturer fixtureManufacturer = new FixtureManufacturer();
		fixtureManufacturer.setManufacturerType(fixManufacturer);
		maFixtureDAO.addFixtureManufacturer(fixtureManufacturer);

	}

	@Override
	public List<FixtureManufacturer> getFixtureManufacturer() {
		List<FixtureManufacturer> list = maFixtureDAO.getFixtureManufacturer();
		return list;
	}

	@Override
	public void addLampManufacturer(String lampManufacturer) {

		LampManufacturer lamManufacturer = new LampManufacturer();
		lamManufacturer.setManufacturerType(lampManufacturer);
		maFixtureDAO.addLampManufacturer(lamManufacturer);
	}

	@Override
	public List<LampManufacturer> getLampManufacturerDetails() {
		List<LampManufacturer> list = maFixtureDAO.getLampManufacturerDetails();
		return list;
	}

	@Override
	public void addLampCatalogNo(String lampCatalog) {

		LampCatalogNum lampCatalogNum = new LampCatalogNum();
		lampCatalogNum.setCatalogType(lampCatalog);
		maFixtureDAO.addLampCatalogNo(lampCatalogNum);
	}

	@Override
	public List<LampCatalogNum> getLampCatalogNoDetails() {
		List<LampCatalogNum> list = maFixtureDAO.getLampCatalogNoDetails();
		return list;
	}

}
