package com.elecnor.lighting.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.elecnor.lighting.bean.ProjectMaster;
import com.elecnor.lighting.bean.UserProfile;
import com.elecnor.lighting.dao.ProjectMasterDAO;
import com.elecnor.lighting.dao.UserProfileDAO;
import com.elecnor.lighting.service.ProjectMasterService;
import com.elecnor.lighting.service.UserProfileService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class ProjectController {
	// @Autowired
	// UserProfileDAO userProfileDao;

	@Autowired
	UserProfileService userProfileService;
	// @Autowired
	// ProjectMasterDAO projectMasterDao;
	@Autowired
	ProjectMasterService projectMasterService;

	@RequestMapping(value = "/getProjDetails", method = RequestMethod.POST)
	public @ResponseBody String getProjDetails(HttpSession session) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		UserProfile user = (UserProfile) session.getAttribute("selectedUser");
		if (user != null) {
			
			ArrayList<UserProfile> userList = userProfileService
					.getAllUserProfiles(user.getDomainIdTransient());
			ArrayList<ProjectMaster> projList = projectMasterService
					.getAllProjectList(user.getDomainIdTransient());
			map.put("aaData", projList);
			map.put("userList", userList);
			map.put("projId", (String) session.getAttribute("selectedProjId"));
		}
		map.put("selectedUser", user);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@ModelAttribute(value = "projectForm")
	public ProjectMaster getRegisteration() {
		return new ProjectMaster();
	}

	// @RequestMapping(value = "projectActionController", method =
	// RequestMethod.POST)
	// public @ResponseBody String handelProjectAction(
	// @ModelAttribute("projectForm") ProjectMaster projBean,
	// @RequestParam("actionFor") String actionFor,
	// @RequestParam(value = "projectId", defaultValue = "-1") long projectId,
	// @RequestParam(value = "projManager", defaultValue = "-1") int
	// projManager,
	// @RequestParam(value = "projSupervisor", defaultValue = "-1") int
	// projSupervisor,
	// HttpSession session) {
	// String exceptionThrown=null;
	// if (actionFor.equalsIgnoreCase("delete")) {
	// exceptionThrown=projectMasterDao.setProjectToDelete(projectId);
	// } else if (actionFor.equalsIgnoreCase("save")) {
	// projBean.setStatus("ACTIVE");
	// exceptionThrown=projectMasterService.addOrUpdateProject(projBean,
	// projManager,
	// projSupervisor,session);
	// } else if (actionFor.equalsIgnoreCase("update")) {
	// projBean.setJobId(projectId);
	// exceptionThrown=projectMasterService.addOrUpdateProject(projBean,
	// projManager,
	// projSupervisor,session);
	// }
	// return exceptionThrown;
	// }

	@RequestMapping(value = "projectFormController", method = RequestMethod.POST)
	public ModelAndView handelProjectPageRequest(
			@ModelAttribute("projectForm") ProjectMaster projBean,
			@RequestParam("actionFor") String actionFor,
			@RequestParam(value = "projectId", defaultValue = "-1") long projectId,
			@RequestParam(value = "projManager", defaultValue = "-1") int projManager,
			@RequestParam(value = "projSupervisor", defaultValue = "-1") int projSupervisor,
			HttpSession session) {
		ModelAndView mav = new ModelAndView("index");
		if (actionFor.equalsIgnoreCase("select")) {
			ProjectMaster projList = projectMasterService
					.getProjectDetailsById(projectId);
			if (projList != null) {
				session.setAttribute("selectedProject", projList);
				mav.setViewName("fixture");
			}
		}
		return mav;
	}
}