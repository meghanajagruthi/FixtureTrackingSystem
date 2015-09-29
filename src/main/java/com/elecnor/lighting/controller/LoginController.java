package com.elecnor.lighting.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elecnor.lighting.bean.UserProfile;
import com.elecnor.lighting.service.UserProfileService;
import com.elecnor.lighting.util.FMSConstants;
import com.elecnor.lighting.util.FtsUtility;
import com.elecnor.lighting.util.PropertyFileReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class LoginController {

	@Autowired
	UserProfileService userProfileService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String LoginAuthentication(
			@RequestParam(value = "userName", defaultValue = "-1") String userName,
			@RequestParam(value = "password", defaultValue = "-1") String password,
			HttpSession session, HttpServletRequest request) {

		String resultView = FMSConstants.FMS_REDIRECT_TO_INDEX_PAGE;

		try {
			resultView = userProfileService.AuthenticateUser(userName,
					password, request);
		} catch (Exception e) {
			resultView = FMSConstants.FMS_REDIRECT_TO_ERROR_PAGE;
			e.printStackTrace();
		}
		return resultView;
	}

	// this method is just for returning to index page when user redirected from
	// Ecosystem and hiding that redirect url from user(for security)
	@RequestMapping(value = "/projectsHome", method = RequestMethod.GET)
	public String LoginAuthentication1(HttpSession session) {
		if (session.getAttribute(FMSConstants.FMS_LOGGED_USER_SESSION_NAME) != null)
			return FMSConstants.FMS_STRING_INDEX;
		else
			return FMSConstants.FMS_REDIRECT_TO_SESSIONEXPIRE_PAGE;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String LoginAuthenticationGetMethod(HttpSession session,
			HttpServletRequest request) {
		if (session.getAttribute(FMSConstants.FMS_LOGGED_USER_SESSION_NAME) != null) {
			session.setAttribute("selectedProjId",
					request.getParameter("projId"));
			return FMSConstants.FMS_STRING_INDEX;
		} else {
			return FMSConstants.FMS_REDIRECT_TO_SESSIONEXPIRE_PAGE;
		}

	}

	/*@RequestMapping(value = "/redirectToIssueTrackerApp", method = RequestMethod.POST)
	@ResponseBody
	public String redirectToIssueTrackerApp(HttpSession session) {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		FtsUtility utilRef = new FtsUtility();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.setDateFormat("MM-dd-yyyy").create();
		try {
			PropertyFileReader pfr = PropertyFileReader.getInstance();
			String appId = pfr
					.getStringProperty("ftsApplicationIDInIssueTrackerDB");
			UserProfile logedInUserDetails = (UserProfile) session
					.getAttribute(FMSConstants.FMS_LOGGED_USER_SESSION_NAME);
			responseMap.put("issueTrackerUrl",
					utilRef.getIssuetrackerUrlForReportIssue());
			responseMap.put("emailId", logedInUserDetails.getEmailId());
			responseMap.put("password", logedInUserDetails.getPassword());
			responseMap.put("applicationId", appId);
			responseMap.put("ajaxResult", "success");
		} catch (Exception e) {
			responseMap.put("ajaxResult", "failure");
			responseMap.put("reason", e.getMessage());
			e.printStackTrace();
		}
		return gson.toJson(responseMap);

	}*/

}
