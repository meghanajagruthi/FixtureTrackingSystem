package com.elecnor.lighting.serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elecnor.lighting.bean.FixtureMaster;
import com.elecnor.lighting.dao.FixtureDAO;
import com.elecnor.lighting.dao.MastreFixtureDAO;
import com.elecnor.lighting.helper.MasterFixtureHelper;
import com.elecnor.lighting.service.FixtureService;

@Service
public class FixtureServiceImpl implements FixtureService {

	@Autowired
	MastreFixtureDAO mastreFixtureDAO;
	@Autowired
	FixtureDAO fixtureDAO;

	@Override
	public String addUpdateFixtureDetails(FixtureMaster fixture) {
		fixture.setFixtureVariant(MasterFixtureHelper.getFixtureVariantById(
				fixture.getFixtureVariantTrans(),
				mastreFixtureDAO.getFixtureVariant()));
		fixture.setFixtureDescription(MasterFixtureHelper
				.getFixtureDescriptionById(fixture.getFixDescriptionTrans(),
						mastreFixtureDAO.getFixtureDescription()));
		fixture.setFixtureManufacturer(MasterFixtureHelper
				.getFixtureManufacturerById(fixture.getFixManufacturerTrans(),
						mastreFixtureDAO.getFixtureManufacturer()));
		fixture.setLampCatalogNum(MasterFixtureHelper
				.getLampCatalogNoDetailsById(fixture.getLampCatalogNoTrans(),
						mastreFixtureDAO.getLampCatalogNoDetails()));
		fixture.setLampManufacturer(MasterFixtureHelper
				.getLampManufacturerDetailsById(fixture.getLampMadeByTrans(),
						mastreFixtureDAO.getLampManufacturerDetails()));
		fixture.setStatus("ACTIVE");
		fixture.setSubmittedDate(new Date());
		fixtureDAO.addUpdateFixtureDetails(fixture);
		return null;
	}

}
