package com.elecnor.lighting.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elecnor.lighting.bean.ProjectMaster;
import com.elecnor.lighting.bean.ReportIssue;
import com.elecnor.lighting.bean.UserProfile;
import com.elecnor.lighting.dao.ProjectMasterDAO;
import com.elecnor.lighting.dao.UserProfileDAO;
import com.elecnor.lighting.service.ProjectMasterService;
import com.elecnor.lighting.service.ReportIssueService;
import com.elecnor.lighting.util.EmailThread;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class ReportIssueController {
	@Autowired
	UserProfileDAO userProfileDao;
	// @Autowired
	// ProjectMasterDAO projectMasterDao;
	@Autowired
	ProjectMasterService projectMasterService;
	@Autowired
	ReportIssueService reportService;

	@RequestMapping(value = "/getProjDetailsForIssue", method = RequestMethod.POST)
	public @ResponseBody String getProjDetails(HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		UserProfile user = (UserProfile) session.getAttribute("selectedUser");
		if (user != null) {
			ArrayList<ProjectMaster> projList = projectMasterService
					.getAllProjectList(user.getDomainIdTransient());
			map.put("projList", projList);
		}
		map.put("selectedUser", user);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json;
	}

	@ModelAttribute(value = "issueForm")
	public ReportIssue getRegistration() {
		return new ReportIssue();
	}

	@RequestMapping(value = "submitIssue", method = RequestMethod.POST)
	public @ResponseBody String submitIssue(
			@ModelAttribute("issueForm") ReportIssue reportBean,
			HttpSession session) {

		HashMap<String, String> map = new HashMap<String, String>();
		UserProfile user = (UserProfile) session.getAttribute("selectedUser");
		reportBean.setSubmittedBy(user.getFirstName());
		reportBean.setUpdatedBy(user.getFirstName());
		reportService.submitIssue(reportBean);
		String to = "ankur.srivastav@cerridsolutions.com,ashutosh.tripathi@cerridsolutions.com";
		String cc = "";
		String msg = "Related Project : " + reportBean.getRelatedProject()
				+ "<br><br> Severity : " + reportBean.getSeverity()
				+ "<br><br> Module : " + reportBean.getRelatedModule()
				+ "<br><br> Description : " + reportBean.getDescription()
				+ " <br><br> Additional Comments :"
				+ reportBean.getAddnlComment() + " <br><br>Submitted By :"
				+ user.getFirstName() + " " + user.getLastName() + " - "
				+ user.getFirstName() + "<br> <br>" + user.getEmailId();
		Thread thread = new Thread(new EmailThread(to, cc, "FTS Bug Reported",
				msg, null));
		thread.start();
		map.put("reportStatus",
				"Issue has been reported to the Dev team.Dev team will get back to you once this issue is fixed.");
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(map);
		return json.toString();
	}

}
