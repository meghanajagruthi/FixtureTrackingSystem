package com.elecnor.lighting.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elecnor.lighting.bean.ADesign;
import com.elecnor.lighting.bean.AtticStock;
import com.elecnor.lighting.bean.BadFixtureLamp;
import com.elecnor.lighting.bean.ChangeOrder;
import com.elecnor.lighting.bean.EDesign;
import com.elecnor.lighting.bean.FixtureIssue;
import com.elecnor.lighting.bean.FixtureMaster;
import com.elecnor.lighting.bean.FixtureTracking;
import com.elecnor.lighting.bean.ProjectMaster;
import com.elecnor.lighting.bean.UserProfile;
import com.elecnor.lighting.dao.FixtureDAO;
import com.elecnor.lighting.dao.FixtureInDetailDAO;
import com.elecnor.lighting.dao.UserProfileDAO;
import com.elecnor.lighting.service.FixtureInDetailService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class FixtureInDetailController {

	@Autowired
	FixtureInDetailService fixInDetailService;
	@Autowired
	FixtureInDetailDAO fixDetailDAO;
	@Autowired
	UserProfileDAO userDao;
	@Autowired
	FixtureDAO fixtureDAO;

	@RequestMapping("/fixtureInDetail")
	public String getMasterFixture() {
		return "fixtureInDetail";
	}

	@ModelAttribute(value = "eSheetForm")
	public EDesign getESheetRegisteration() {
		return new EDesign();
	}

	@RequestMapping(value = "fixtureInDetailInit", method = RequestMethod.POST)
	@ResponseBody
	public String fixtureInDetailInit(HttpSession session) {

		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		ProjectMaster projectObj = (ProjectMaster) session
				.getAttribute("selectedProject");
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");

		if (userObj == null || projectObj == null || fixtureObj == null) {
			return "Failed";
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		FixtureMaster fixMaster = new FixtureMaster();
		HashMap<String, Object> fixtureSummaryMap = fixDetailDAO
				.getFixtureInDetailSummaryData(fixtureObj.getFixtureId());
		fixMaster.setQtyPerBaseOrder(((Long) fixtureSummaryMap
				.get("ADesignCount") >= (Long) fixtureSummaryMap
				.get("EDesignCount") ? (Long) fixtureSummaryMap
				.get("ADesignCount") : (Long) fixtureSummaryMap
				.get("EDesignCount"))
				+ (Long) fixtureSummaryMap.get("atticCount")
				+ (Long) fixtureSummaryMap.get("spareCount")
				+ ((Long) fixtureSummaryMap.get("changeOrder")));
		fixMaster.setFixtureQuantity(((Long) fixtureSummaryMap
				.get("fixtureQty")).intValue());
		fixMaster.setLampQuantity(((Long) fixtureSummaryMap.get("lampQty"))
				.intValue());
		fixMaster.setFixtureGood(((Long) fixtureSummaryMap.get("fixtureGood"))
				.intValue());
		fixMaster.setLampGood(((Long) fixtureSummaryMap.get("lampGood"))
				.intValue());
		fixMaster.setChangeOrder(((Long) fixtureSummaryMap.get("changeOrder"))
				.intValue());

		map.put("selectedUser", userObj);
		map.put("selectedProject", projectObj);
		map.put("selectedFixture", fixtureObj);
		map.put("fixMaster", fixMaster);

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@RequestMapping(value = "eSheetAction", method = RequestMethod.POST)
	@ResponseBody
	public String handleESheetDetails(
			@ModelAttribute("eSheetForm") EDesign edesign,
			@RequestParam("actionForESheet") String actionForESheet,
			@RequestParam(value = "eDesignId", defaultValue = "-1") Long eDesignId,
			HttpSession session) {

		if (actionForESheet.equalsIgnoreCase("delete")) {
			fixDetailDAO.deleteESheet(eDesignId);
		} else if (actionForESheet.equalsIgnoreCase("update")) {
			edesign.setEDesignId(eDesignId);
			fixInDetailService.updateESheet(edesign, session);
		} else if (actionForESheet.equalsIgnoreCase("save")) {
			fixInDetailService.addESheetDetails(edesign, session);
		}

		HashedMap map = new HashedMap();
		map.put("result", "success");
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@ModelAttribute(value = "aSheetForm")
	public ADesign getASheetRegisteration() {
		return new ADesign();
	}

	@RequestMapping(value = "aSheetAction", method = RequestMethod.POST)
	@ResponseBody
	public String handleASheetDetails(
			@ModelAttribute("aSheetForm") ADesign aDesign,
			@RequestParam("actionForASheet") String actionForASheet,
			@RequestParam(value = "aDesignId", defaultValue = "-1") Long aDesignId,
			HttpSession session) {

		if (actionForASheet.equalsIgnoreCase("delete")) {
			fixDetailDAO.deleteASheet(aDesignId);
		} else if (actionForASheet.equalsIgnoreCase("save")) {
			fixInDetailService.addASheetDetails(aDesign, session);
		} else if (actionForASheet.equalsIgnoreCase("update")) {
			aDesign.setADesignId(aDesignId);
			fixInDetailService.updateASheet(aDesign, session);
		}
		HashedMap map = new HashedMap();
		map.put("result", "success");
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@ModelAttribute(value = "attStockForm")
	public AtticStock getAttickRegistration() {
		return new AtticStock();
	}

	@RequestMapping(value = "attStockAction", method = RequestMethod.POST)
	@ResponseBody
	public String handleAttickDetails(
			@ModelAttribute("attStockForm") AtticStock atticStock,
			@RequestParam("actionForAtticStock") String actionForAtticStock,
			@RequestParam(value = "atticStockId", defaultValue = "-1") Long atticStockId,
			HttpSession session) {

		if (actionForAtticStock.equalsIgnoreCase("delete")) {
			fixDetailDAO.deleteAtticStock(atticStockId);
		} else if (actionForAtticStock.equalsIgnoreCase("save")) {
			fixInDetailService.addAttickDetails(atticStock, session);
		} else if (actionForAtticStock.equalsIgnoreCase("update")) {
			atticStock.setAtticStockId(atticStockId);
			fixInDetailService.updateAtticStock(atticStock, session);
		}
		HashedMap map = new HashedMap();
		map.put("result", "success");
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@RequestMapping(value = "/getSheetDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getAllSheetDetails(HttpSession session) {

		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		ProjectMaster projectObj = (ProjectMaster) session
				.getAttribute("selectedProject");
		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");

		HashMap<String, Object> map = new HashMap<String, Object>();

		if (userObj != null && projectObj != null && fixtureObj != null) {
			List<EDesign> eDesignList = fixInDetailService
					.getESheetDetails(session);
			List<ADesign> aDesignList = fixInDetailService
					.getASheetDetails(session);
			List<AtticStock> atticStockList = fixInDetailService
					.getAtticStockDetails(session);
			map.put("atticStockList", atticStockList);
			map.put("aDesignList", aDesignList);
			map.put("eDesignList", eDesignList);
		}
		map.put("selectedUser", userObj);
		map.put("selectedProject", projectObj);
		map.put("selectedFixture", fixtureObj);

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@ModelAttribute(value = "issueForm")
	public FixtureIssue getIssueRegistration() {
		return new FixtureIssue();
	}

	@RequestMapping(value = "/issueAction", method = RequestMethod.POST)
	@ResponseBody
	public String handleIssueDetail(
			@ModelAttribute(value = "issueForm") FixtureIssue issue,
			@RequestParam(value = "actionForIssue") String actionForIssue,
			@RequestParam(value = "issueId", defaultValue = "-1") Long issueId,
			HttpSession session) {
		if (actionForIssue.equalsIgnoreCase("delete")) {
			fixDetailDAO.deleteIssueDetails(issueId);
		} else if (actionForIssue.equalsIgnoreCase("update")) {
			issue.setIssueId(issueId);
			fixInDetailService.updateIssues(issue, session);
		} else if (actionForIssue.equalsIgnoreCase("save")) {
			fixInDetailService.addIssueDetails(issue, session);
		}
		HashedMap map = new HashedMap();
		map.put("result", "success");
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@RequestMapping(value = "/getIssueDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getIssueDetails(HttpSession session) {
		List<FixtureIssue> issueList = fixInDetailService
				.getIssueDetails(session);
		HashMap<String, List<FixtureIssue>> map = new HashMap<String, List<FixtureIssue>>();
		map.put("issueList", issueList);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@ModelAttribute(value = "changeOrderForm")
	public ChangeOrder getChangeRegistration() {
		return new ChangeOrder();
	}

	@RequestMapping(value = "/changeOrderAction", method = RequestMethod.POST)
	@ResponseBody
	public String handleChangeOrderDetail(
			@ModelAttribute(value = "changeOrderForm") ChangeOrder changeOrder,
			@RequestParam(value = "actionForChngOrdr") String actionForChngOrdr,
			@RequestParam(value = "changeOrderId", defaultValue = "-1") Long changeOrderId,
			HttpSession session) {

		if (actionForChngOrdr.equalsIgnoreCase("delete")) {
			fixDetailDAO.deleteChangeOrder(changeOrderId);
		} else if (actionForChngOrdr.equalsIgnoreCase("save")) {
			fixInDetailService.addChangeOrderDetails(changeOrder, session);
		} else if (actionForChngOrdr.equalsIgnoreCase("update")) {
			changeOrder.setChangeOrderId(changeOrderId);
			fixInDetailService.updateChangeOrder(changeOrder, session);
		}

		HashedMap map = new HashedMap();
		map.put("result", "success");
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@RequestMapping(value = "/getChangeOrderDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getChangeOrderDetails(HttpSession session) {
		List<ChangeOrder> changeOdrList = fixInDetailService
				.getChangeOrderDetails(session);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("changeOdrList", changeOdrList);

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@ModelAttribute("trackingBeanId")
	public FixtureTracking getFixtureTracking() {
		return new FixtureTracking();
	}

	@RequestMapping(value = "/trackingController", method = RequestMethod.POST)
	@ResponseBody
	public String handelTrackingForm(
			@ModelAttribute FixtureTracking fixtureTracking,
			@RequestParam(value = "actionForTracking", defaultValue = "") String actionForTracking,
			@RequestParam(value = "trackingIdUI", defaultValue = "") String trackingId,
			HttpSession session) {
		String res = null;
		if (actionForTracking.equalsIgnoreCase("Save")) {
			fixInDetailService.addUpdateTrackingDetails(fixtureTracking,
					session);
		} else if (actionForTracking.equalsIgnoreCase("Update")) {
			fixtureTracking.setTrackingId(trackingId);
			res = fixInDetailService.addUpdateTrackingDetails(fixtureTracking,
					session);
		} else if (actionForTracking.equalsIgnoreCase("Delete")) {
			fixDetailDAO.deleteTracking(Long.parseLong(trackingId));
		}
		HashedMap map = new HashedMap();
		if (res == null) {
			map.put("result", "success");
		} else {
			map.put("result", res);
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@RequestMapping(value = "/getTrackingDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getTrackingDetails(HttpSession session) {

		FixtureMaster fixtureObj = (FixtureMaster) session
				.getAttribute("selectedFixture");

		List<FixtureTracking> trackingList = fixDetailDAO
				.getFixtureTrackingDetails(fixtureObj.getFixtureId());
		HashMap<String, List<FixtureTracking>> map = new HashMap<String, List<FixtureTracking>>();
		map.put("trackingList", trackingList);

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@RequestMapping(value = "/getBadLampDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getBadLampDetails(HttpSession session,
			@RequestBody String requestBody) {

		JsonObject requestBodyJson = new JsonParser().parse(requestBody)
				.getAsJsonObject();

		String sample = requestBodyJson.get("mode").getAsString();
		long trackingId = Long.parseLong(sample);
		List<BadFixtureLamp> badLampList = fixDetailDAO
				.getBadFixtureLampDetails(trackingId);

		HashMap<String, List<BadFixtureLamp>> map = new HashMap<String, List<BadFixtureLamp>>();
		map.put("badLampList", badLampList);

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@RequestMapping(value = "fixtureInDetailDefaultAction", method = RequestMethod.GET)
	@ResponseBody
	public String fixtureInDetailDetails(HttpSession session) {
		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		ProjectMaster projectObj = (ProjectMaster) session
				.getAttribute("selectedProject");

		if (userObj == null || projectObj == null) {
			return "Failed";
		}
		Iterator<Object[]> fixtureIterator = fixtureDAO
				.getFixtureSummaryByProject(projectObj.getJobId());
		List<FixtureMaster> fixtureList = new ArrayList<FixtureMaster>();
		FixtureMaster fixMaster = null;
		HashedMap map = new HashedMap();
		while (fixtureIterator.hasNext()) {
			fixMaster = new FixtureMaster();
			Object[] tuple = fixtureIterator.next();
			fixMaster.setFixtureId(tuple[0] == null ? 0L : (Long) tuple[0]);
			fixMaster.setFixtureType((tuple[1] == null ? "" : tuple[1]
					.toString()));
			fixtureList.add(fixMaster);
		}
		map.put("fixture", fixtureList);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}
}
