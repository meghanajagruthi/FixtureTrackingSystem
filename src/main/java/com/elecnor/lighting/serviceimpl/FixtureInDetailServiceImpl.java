package com.elecnor.lighting.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elecnor.lighting.bean.ADesign;
import com.elecnor.lighting.bean.AtticStock;
import com.elecnor.lighting.bean.BadFixtureLamp;
import com.elecnor.lighting.bean.ChangeOrder;
import com.elecnor.lighting.bean.EDesign;
import com.elecnor.lighting.bean.FixtureIssue;
import com.elecnor.lighting.bean.FixtureMaster;
import com.elecnor.lighting.bean.FixtureTracking;
import com.elecnor.lighting.bean.UserProfile;
import com.elecnor.lighting.dao.FixtureInDetailDAO;
import com.elecnor.lighting.dao.UserProfileDAO;
import com.elecnor.lighting.helper.UserProfileHelper;
import com.elecnor.lighting.service.FixtureInDetailService;

@Service
public class FixtureInDetailServiceImpl implements FixtureInDetailService {

	@Autowired
	UserProfileDAO userProfileDAO;
	@Autowired
	FixtureInDetailDAO fixDetailDAO;

	@Override
	public void addESheetDetails(EDesign edisgn, HttpSession session) {

		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		edisgn.setSubmittedDate(new Date());
		edisgn.setSubmittedById(userObj.getsNo());
		edisgn.setSubmittedByName(userObj.getFirstName());
		edisgn.seteDesignForFixtureMaster(fixMaster);
		fixDetailDAO.addESheetDetails(edisgn);
	}

	@Override
	public List<EDesign> getESheetDetails(HttpSession session) {
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		List<EDesign> aList = fixDetailDAO.getESheetDetails(fixMaster
				.getFixtureId());
		return aList;
	}

	@Override
	public void addASheetDetails(ADesign aDesign, HttpSession session) {
		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		aDesign.setSubmittedDate(new Date());
		aDesign.setSubmittedById(userObj.getsNo());
		aDesign.setSubmittedByName(userObj.getFirstName());
		aDesign.setaDesignForFixtureID(fixMaster);
		fixDetailDAO.addASheetDetails(aDesign);
	}

	@Override
	public List<ADesign> getASheetDetails(HttpSession session) {
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		List<ADesign> aList = fixDetailDAO.getASheetDetails(fixMaster
				.getFixtureId());
		return aList;
	}

	@Override
	public void addAttickDetails(AtticStock atticStock, HttpSession session) {
		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		atticStock.setSubmittedDate(new Date());
		atticStock.setSubmittedById(userObj.getsNo());
		atticStock.setAtticStockForFixtureMaster(fixMaster);
		fixDetailDAO.addAttickDetails(atticStock);
	}

	@Override
	public List<AtticStock> getAtticStockDetails(HttpSession session) {
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		List<AtticStock> aList = fixDetailDAO.getAtticStockDetails(fixMaster
				.getFixtureId());
		return aList;
	}

	@Override
	public String updateESheet(EDesign edesign, HttpSession session) {
		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		edesign.setSubmittedById(userObj.getsNo());
		edesign.setSubmittedByName(userObj.getFirstName());
		edesign.setSubmittedDate(new Date());
		edesign.seteDesignForFixtureMaster(fixMaster);
		fixDetailDAO.updateESheet(edesign);
		return null;
	}

	@Override
	public String updateASheet(ADesign aDesign, HttpSession session) {
		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		aDesign.setSubmittedById(userObj.getsNo());
		aDesign.setSubmittedByName(userObj.getFirstName());
		aDesign.setSubmittedDate(new Date());
		aDesign.setaDesignForFixtureID(fixMaster);
		fixDetailDAO.updateASheet(aDesign);
		return null;
	}

	@Override
	public String updateAtticStock(AtticStock atticStock, HttpSession session) {
		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		atticStock.setSubmittedById(userObj.getsNo());
		atticStock.setSubmittedByName(userObj.getFirstName());
		atticStock.setSubmittedDate(new Date());
		atticStock.setAtticStockForFixtureMaster(fixMaster);
		fixDetailDAO.updateAtticStock(atticStock);
		return null;
	}

	@Override
	public void addIssueDetails(FixtureIssue issue, HttpSession session) {
		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		issue.setIssueProb(issue.getIssueProb().trim());
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		issue.setSubmittedDate(new Date());
		issue.setSubmittedById(userObj.getsNo());
		issue.setSubmittedByName(userObj.getFirstName());
		issue.setIssuesForFixtureID(fixMaster);
		fixDetailDAO.addIssueDetail(issue);
	}

	@Override
	public String updateIssues(FixtureIssue issue, HttpSession session) {
		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		issue.setIssueProb(issue.getIssueProb().trim());
		issue.setSubmittedById(userObj.getsNo());
		issue.setSubmittedByName(userObj.getFirstName());
		issue.setSubmittedDate(new Date());
		issue.setIssuesForFixtureID(fixMaster);
		fixDetailDAO.updateIssues(issue);
		return null;
	}

	@Override
	public List<FixtureIssue> getIssueDetails(HttpSession session) {
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		List<FixtureIssue> issueList = fixDetailDAO.getIssueDetails(fixMaster
				.getFixtureId());
		return issueList;
	}

	@Override
	public void addChangeOrderDetails(ChangeOrder changeOrder,
			HttpSession session) {
		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		changeOrder.setSubmittedById(userObj.getsNo());
		changeOrder.setSubmittedByName(userObj.getFirstName());
		changeOrder.setFixtureMasterForChangeOrder(fixMaster);
		changeOrder.setSubmittedDate(new Date());
		fixDetailDAO.addChangeOrderDetail(changeOrder);
	}

	@Override
	public void updateChangeOrder(ChangeOrder changeOrder, HttpSession session) {
		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		changeOrder.setSubmittedById(userObj.getsNo());
		changeOrder.setSubmittedByName(userObj.getFirstName());
		changeOrder.setFixtureMasterForChangeOrder(fixMaster);
		changeOrder.setSubmittedDate(new Date());
		fixDetailDAO.updateChangeOrder(changeOrder);
	}

	@Override
	public List<ChangeOrder> getChangeOrderDetails(HttpSession session) {
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		List<ChangeOrder> changeOdrList = fixDetailDAO
				.getChangeOrderDetails(fixMaster.getFixtureId());
		return changeOdrList;
	}

	@Override
	public String addUpdateTrackingDetails(FixtureTracking fixtureTracking,
			HttpSession session) {

		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");
		FixtureMaster fixMaster = new FixtureMaster();
		fixMaster.setFixtureId(fixtureObj.getFixtureId());
		fixtureTracking.setSubmittedDate(new Date());
		fixtureTracking.setSubmittedById(userObj.getsNo());
		fixtureTracking.setSubmittedByName(userObj.getFirstName());
		fixtureTracking.setFixtureTrackingForFixtureMaster(fixMaster);
		// Start of Bad Fixture/Lamp
		BadFixtureLamp badFixtureObj = new BadFixtureLamp();
		BadFixtureLamp badLampObj = new BadFixtureLamp();

		badFixtureObj.setBadFixtureQty(fixtureTracking.getBadFixtureQty());
		badFixtureObj.setFixtureRecorderDate(fixtureTracking
				.getFixRecorderDate());
		badFixtureObj.setIssue(fixtureTracking.getFixIssue());
		badFixtureObj.setPictureTaken(fixtureTracking.getFixPictureTaken());
		badFixtureObj.setSubmittedById(userObj.getsNo());
		badFixtureObj.setSubmittedByName(userObj.getFirstName());
		badFixtureObj.setVendor(fixtureTracking.getFixVendor());
		badFixtureObj.setPmInformedDate(fixtureTracking.getFixPmInformedDate());
		badFixtureObj.setVendorInformedDate(fixtureTracking
				.getFixVendorInformedDate());

		badLampObj.setBadLampQty(fixtureTracking.getBadLampQty());
		badLampObj
				.setFixtureRecorderDate(fixtureTracking.getLampRecorderDate());
		badLampObj.setIssue(fixtureTracking.getLampIssue());
		badLampObj.setPictureTaken(fixtureTracking.getLampPictureTaken());
		badLampObj.setSubmittedById(userObj.getsNo());
		badLampObj.setSubmittedByName(userObj.getFirstName());
		badLampObj.setVendor(fixtureTracking.getLampVendor());
		badLampObj.setPmInformedDate(fixtureTracking.getLampPmInformedDate());
		badLampObj.setVendorInformedDate(fixtureTracking
				.getLampVendorInformedDate());

		return fixDetailDAO.addUpdateTrackingDetails(fixtureTracking,
				badFixtureObj, badLampObj);
	}

	@Override
	public List<FixtureTracking> getFixtureTrackingDetails(int fixtureId) {
		// TODO Auto-generated method stub
		return null;
	}
}
