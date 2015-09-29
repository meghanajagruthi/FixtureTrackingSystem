package com.elecnor.lighting.dao;

import java.util.Iterator;
import java.util.List;

import com.elecnor.lighting.bean.FixtureMaster;

public interface FixtureDAO {
	public String addUpdateFixtureDetails(FixtureMaster fixture);

	List<FixtureMaster> getFixtureByProject(long projectId);

	public void setProjectToDelete(long fixtureNumber);

	Iterator<Object[]> getFixtureSummaryByProject(long projectId);	
}
