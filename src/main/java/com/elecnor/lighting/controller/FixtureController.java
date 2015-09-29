package com.elecnor.lighting.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.elecnor.lighting.bean.FixtureDescription;
import com.elecnor.lighting.bean.FixtureManufacturer;
import com.elecnor.lighting.bean.FixtureMaster;
import com.elecnor.lighting.bean.FixtureVariant;
import com.elecnor.lighting.bean.LampCatalogNum;
import com.elecnor.lighting.bean.LampManufacturer;
import com.elecnor.lighting.bean.ProjectMaster;
import com.elecnor.lighting.bean.UserProfile;
import com.elecnor.lighting.dao.FixtureDAO;
import com.elecnor.lighting.dao.FixtureInDetailDAO;
import com.elecnor.lighting.dao.MastreFixtureDAO;
import com.elecnor.lighting.service.FixtureService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class FixtureController {

	@Autowired
	MastreFixtureDAO mastreFixtureDao;
	@Autowired
	FixtureService fixtureService;
	@Autowired
	FixtureDAO fixtureDao;
	@Autowired
	FixtureInDetailDAO fixDetailDAO;

	@RequestMapping("/fixture")
	public String getMasterFixture(HttpSession session) {
		return "fixture";
	}

	@RequestMapping("/getFixtureDetails")
	public @ResponseBody String getFixtureDetails(HttpSession session) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		ProjectMaster projectObj = (ProjectMaster) session
				.getAttribute("selectedProject");
		map.put("selectedUser", userObj);
		map.put("selectedProject", projectObj);
		if (userObj == null || projectObj == null) {
			return "Failed";
		}

		List<FixtureVariant> fixVariantList = mastreFixtureDao
				.getFixtureVariant();
		List<FixtureDescription> fixDescList = mastreFixtureDao
				.getFixtureDescription();
		List<FixtureManufacturer> fixManufacList = mastreFixtureDao
				.getFixtureManufacturer();
		List<LampCatalogNum> fixLampCatalogList = mastreFixtureDao
				.getLampCatalogNoDetails();
		List<LampManufacturer> fixLampManufList = mastreFixtureDao
				.getLampManufacturerDetails();

		List<FixtureMaster> fixtureList = fixtureDao
				.getFixtureByProject(((ProjectMaster) (session
						.getAttribute("selectedProject"))).getJobId());

		/* Select Box Data Starts */
		map.put("fixVariantList", fixVariantList);
		map.put("fixDescList", fixDescList);
		map.put("fixManufacList", fixManufacList);
		map.put("fixLampCatalogList", fixLampCatalogList);
		map.put("fixLampManufList", fixLampManufList);
		/* Select Box Data Ends */

		for (FixtureMaster fixMaster : fixtureList) {
			HashMap<String, Object> fixtureSummaryMap = fixDetailDAO
					.getFixtureInDetailSummaryData(fixMaster.getFixtureId());
			fixMaster.setaSheetCount((Long) fixtureSummaryMap
					.get("ADesignCount"));
			fixMaster.seteSheetCount((Long) fixtureSummaryMap
					.get("EDesignCount"));
			fixMaster
					.setAttickCount((Long) fixtureSummaryMap.get("atticCount"));
			fixMaster.setSpareCount((Long) fixtureSummaryMap.get("spareCount"));
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
			fixMaster.setFixtureGood(((Long) fixtureSummaryMap
					.get("fixtureGood")).intValue());
			fixMaster.setLampGood(((Long) fixtureSummaryMap.get("lampGood"))
					.intValue());
			fixMaster
					.setIssueCount(((Long) fixtureSummaryMap.get("issueCount"))
							.intValue());
			fixMaster.setChangeOrder(((Long) fixtureSummaryMap
					.get("changeOrder")).intValue());
			fixtureList.set(fixtureList.indexOf(fixMaster), fixMaster);
		}

		map.put("aaData", fixtureList);
		map.put("selectedUser", userObj);
		map.put("selectedProject", projectObj);

		/* Design Stats Calc Ends */
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;

	}

	@ModelAttribute("fixtureFormModel")
	public FixtureMaster getFixtureMasterAttribute() {
		return new FixtureMaster();
	}

	@RequestMapping(value = "/fixtureActionController", method = RequestMethod.POST)
	public @ResponseBody String handelFixtureFormAction(
			@ModelAttribute(value = "fixtureFormModel") FixtureMaster fixture,
			@RequestParam("actionFor") String actionFor,
			@RequestParam(value = "fixtureNumber", defaultValue = "-1") long fixtureNumber,
			HttpSession session) {
		UserProfile userObj = (UserProfile) session
				.getAttribute("selectedUser");
		if (actionFor.equalsIgnoreCase("delete")) {

			fixtureDao.setProjectToDelete(fixtureNumber);
		} else if (actionFor.equalsIgnoreCase("save")) {
			fixture.setSubmittedById(userObj.getsNo());
			fixture.setSubmittedByName(userObj.getFirstName());
			fixture.setProjectMasterId(((ProjectMaster) session
					.getAttribute("selectedProject")).getJobId());
			fixture.setProjectName(((ProjectMaster) session
					.getAttribute("selectedProject")).getJobName());
			fixture.setProjectNumber(((ProjectMaster) session
					.getAttribute("selectedProject")).getJobNumber());
			fixtureService.addUpdateFixtureDetails(fixture);
		} else if (actionFor.equalsIgnoreCase("update")) {
			fixture.setProjectMasterId(((ProjectMaster) session
					.getAttribute("selectedProject")).getJobId());
			fixture.setProjectName(((ProjectMaster) session
					.getAttribute("selectedProject")).getJobName());
			fixture.setProjectNumber(((ProjectMaster) session
					.getAttribute("selectedProject")).getJobNumber());
			fixture.setFixtureId(fixtureNumber);
			fixture.setSubmittedById(userObj.getsNo());
			fixture.setSubmittedByName(userObj.getFirstName());
			fixtureService.addUpdateFixtureDetails(fixture);
		}
		return null;
	}

	@RequestMapping(value = "/fixtureController", method = RequestMethod.POST)
	public ModelAndView handelFixtureForm(
			@ModelAttribute(value = "fixtureFormModel") FixtureMaster fixture,
			@RequestParam("actionFor") String actionFor,
			@RequestParam(value = "fixtureNumber", defaultValue = "-1") long fixtureNumber,
			HttpSession session) {
		ModelAndView mav = new ModelAndView("fixture");

		if (actionFor.equalsIgnoreCase("select")) {
			List<FixtureMaster> fixList = fixtureDao
					.getFixtureByProject(((ProjectMaster) session
							.getAttribute("selectedProject")).getJobId());
			for (FixtureMaster fix : fixList) {
				if (fix.getFixtureId() == fixtureNumber) {
					session.setAttribute("selectedFixture", fix);
					mav.setViewName("fixtureInDetail");
					break;
				}
			}
		}
		return mav;
	}
}