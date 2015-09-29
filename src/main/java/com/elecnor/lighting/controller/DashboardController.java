package com.elecnor.lighting.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elecnor.lighting.bean.FixtureMaster;
import com.elecnor.lighting.bean.ProjectMaster;
import com.elecnor.lighting.bean.UserProfile;
import com.elecnor.lighting.dao.FixtureDAO;
import com.elecnor.lighting.dao.FixtureInDetailDAO;
import com.elecnor.lighting.dao.ProjectMasterDAO;
import com.elecnor.lighting.dao.UserProfileDAO;
import com.elecnor.lighting.service.ProjectMasterService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class DashboardController {
	@Autowired
	FixtureDAO fixtureDao;
	@Autowired
	FixtureInDetailDAO fixDetailDAO;
	@Autowired
	UserProfileDAO userProfileDao;
	// @Autowired
	// ProjectMasterDAO projectMasterDao;
	@Autowired
	ProjectMasterService projectMasterService;

	@RequestMapping(value = "/dashboardDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getDashboard(HttpSession session) {
		// Session Mangement
		HashMap<String, Object> map = new HashMap<String, Object>();
		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		ProjectMaster projectObj = (ProjectMaster) session
				.getAttribute("selectedProject");

		if (userObj != null) {
			ArrayList<ProjectMaster> projList = projectMasterService
					.getAllProjectList(userObj.getDomainIdTransient());
			map.put("projList", projList);
		}

		map.put("selectedUser", userObj);
		map.put("selectedProject", projectObj);

		if (userObj == null || projectObj == null) {
			return "Failed";
		}
		Iterator<Object[]> fixtureIterator = fixtureDao
				.getFixtureSummaryByProject(projectObj.getJobId());
		List<FixtureMaster> fixtureList = new ArrayList<FixtureMaster>();
		FixtureMaster fixMaster = null;
		while (fixtureIterator.hasNext()) {
			fixMaster = new FixtureMaster();
			Object[] tuple = fixtureIterator.next();
			fixMaster.setFixtureId(tuple[0] == null ? 0L : (Long) tuple[0]);
			fixMaster.setFixtureType((tuple[1] == null ? "" : tuple[1]
					.toString()));
			HashMap<String, Object> fixtureSummaryMap = fixDetailDAO
					.getFixtureInDetailSummaryData(fixMaster.getFixtureId());

			fixMaster.setQtyPerBaseOrder(((Long) fixtureSummaryMap
					.get("ADesignCount") >= (Long) fixtureSummaryMap
					.get("EDesignCount") ? (Long) fixtureSummaryMap
					.get("ADesignCount") : (Long) fixtureSummaryMap
					.get("EDesignCount"))
					+ (Long) fixtureSummaryMap.get("atticCount")
					+ (Long) fixtureSummaryMap.get("spareCount")
					+ ((Long) fixtureSummaryMap.get("changeOrder")).intValue());
			fixMaster.setFixtureQuantity(((Long) fixtureSummaryMap
					.get("fixtureQty")).intValue());
			fixMaster.setLampQuantity(((Long) fixtureSummaryMap.get("lampQty"))
					.intValue());
			fixMaster.setFixtureGood(((Long) fixtureSummaryMap
					.get("fixtureGood")).intValue());
			fixMaster.setLampGood(((Long) fixtureSummaryMap.get("lampGood"))
					.intValue());
			fixtureList.add(fixMaster);
		}
		map.put("aaData", fixtureList);

		/* Design Stats Calc Ends */
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@RequestMapping("/dashboard")
	public String getDashBoardPage(HttpSession session) {
		return "dashboard";
	}

	@RequestMapping("/setProjSelectedInDashboard")
	public String setProjSelectedInDashboard(HttpSession session) {
		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		ProjectMaster projectObj = (ProjectMaster) session
				.getAttribute("selectedProject");
		if (userObj == null || projectObj == null) {
			return "login";
		}

		return "dashboard";
	}
}
