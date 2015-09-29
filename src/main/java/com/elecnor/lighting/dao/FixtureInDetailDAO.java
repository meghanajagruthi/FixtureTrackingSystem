package com.elecnor.lighting.dao;

import java.util.HashMap;
import java.util.List;

import com.elecnor.lighting.bean.ADesign;
import com.elecnor.lighting.bean.AtticStock;
import com.elecnor.lighting.bean.BadFixtureLamp;
import com.elecnor.lighting.bean.ChangeOrder;
import com.elecnor.lighting.bean.EDesign;
import com.elecnor.lighting.bean.FixtureIssue;
import com.elecnor.lighting.bean.FixtureTracking;

public interface FixtureInDetailDAO {
	
	public void addESheetDetails(EDesign edisgn);
	public List<EDesign> getESheetDetails(Long fixId);
	public String deleteESheet(long eSheetID);
	public String updateESheet(EDesign edesign);
	
	public void addASheetDetails(ADesign aDesign);
	public List<ADesign> getASheetDetails(Long fixtureId);
	public String deleteASheet(long aDesignId);
	public String updateASheet(ADesign aDesign);
	
	public void addAttickDetails(AtticStock atticStock);
	public List<AtticStock> getAtticStockDetails(Long fixtureId);
	public String deleteAtticStock(long atticStockId);
	public String updateAtticStock(AtticStock atticStock);
	
	public void addIssueDetail(FixtureIssue issue);
	public void deleteIssueDetails(long issueId);
	public void updateIssues(FixtureIssue issue);
	public List<FixtureIssue> getIssueDetails(Long fixtureId);
	
	
	public void deleteChangeOrder(Long changeOrderId);
	public void addChangeOrderDetail(ChangeOrder changeOrder);
	public void updateChangeOrder(ChangeOrder changeOrder);
	public List<ChangeOrder> getChangeOrderDetails(Long fixtureId);
	
	public String addUpdateTrackingDetails(FixtureTracking fixtureTracking, BadFixtureLamp badFixtureObj, BadFixtureLamp badLampObj);
	public List<FixtureTracking> getFixtureTrackingDetails(Long fixtureId);
	public int deleteTracking(long tracking);
	HashMap<String, Object> getFixtureInDetailSummaryData(Long fixtureId);
	
	public List<BadFixtureLamp> getBadFixtureLampDetails(long trackingId);
		
	

}
