package com.elecnor.lighting.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.elecnor.lighting.bean.ProjectMaster;
import com.elecnor.lighting.bean.UserProfile;
import com.elecnor.lighting.dao.ProjectMasterDAO;
import com.elecnor.lighting.service.ProjectMasterService;

@Controller
public class CommonController {
//	@Autowired
//	ProjectMasterDAO projectMasterDao;
	
	@Autowired
	ProjectMasterService projectMasterService;

	@RequestMapping("logOut")
	// @ResponseBody
	public String logOut(HttpSession session) {
		session.invalidate();
		return "logout";
	}

	@RequestMapping(value = "selectProjectForDashBord", method = RequestMethod.POST)
	public String selectProjectForDashBord(
			@RequestParam(value = "projectIdSummary", defaultValue = "-1") long projectId,
			HttpSession session) {
		UserProfile user = (UserProfile) session.getAttribute("selectedUser");
		if (user != null) {
			ProjectMaster projList = projectMasterService.getProjectDetailsById(projectId);
				if (projList != null) {
					session.setAttribute("selectedProject", projList);
					return "dashboard";
				}
			}
		
		return "sessionExpire";

	}
}
