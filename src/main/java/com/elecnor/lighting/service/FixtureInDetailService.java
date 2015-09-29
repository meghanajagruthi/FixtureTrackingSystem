package com.elecnor.lighting.service;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.elecnor.lighting.bean.ADesign;
import com.elecnor.lighting.bean.AtticStock;
import com.elecnor.lighting.bean.ChangeOrder;
import com.elecnor.lighting.bean.EDesign;
import com.elecnor.lighting.bean.FixtureIssue;
import com.elecnor.lighting.bean.FixtureTracking;

public interface FixtureInDetailService {

	
	public void addESheetDetails(EDesign edisgn, HttpSession session);
	public List<EDesign> getESheetDetails(HttpSession session);
	public String updateESheet(EDesign edesign, HttpSession session);
	
	public void addASheetDetails(ADesign aDesign, HttpSession session);
	public List<ADesign> getASheetDetails(HttpSession session);
	public String updateASheet(ADesign aDesign, HttpSession session);
	
	public void addAttickDetails(AtticStock atticStock, HttpSession session);
	public List<AtticStock> getAtticStockDetails(HttpSession session);
	public String updateAtticStock(AtticStock atticStock, HttpSession session);
	
	public void addIssueDetails(FixtureIssue issue, HttpSession session);
	public String updateIssues(FixtureIssue issue, HttpSession session);
	public List<FixtureIssue> getIssueDetails(HttpSession session);
	
	public void addChangeOrderDetails(ChangeOrder changeOrder, HttpSession session);
	public void updateChangeOrder(ChangeOrder changeOrder, HttpSession session);
	public List<ChangeOrder> getChangeOrderDetails(HttpSession session);
	
	public String addUpdateTrackingDetails(FixtureTracking fixtureTracking, HttpSession session);
	public List<FixtureTracking> getFixtureTrackingDetails(int fixtureId);
	
	

}
