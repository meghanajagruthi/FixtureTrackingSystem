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

import com.elecnor.lighting.bean.UserProfile;
import com.elecnor.lighting.dao.UserProfileDAO;
import com.elecnor.lighting.service.UserProfileService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class UserProfileController {

	@Autowired
	UserProfileDAO userProfileDAO;
	@Autowired
	UserProfileService userProfileService;

	@RequestMapping("/manageUser")
	public String getMasterFixture() {
		return "manageUsers";
	}

	@ModelAttribute(value = "/manageUserForm")
	public UserProfile registerUserProfile() {
		return new UserProfile();
	}

	// @RequestMapping(value = "/manageUserAction", method = RequestMethod.POST)
	// public @ResponseBody String handleUserDetails(
	// @ModelAttribute("manageUserForm") UserProfile userProfile,
	// @RequestParam(value = "sNo", defaultValue = "-1") Long sNo,
	// @RequestParam(value = "actionForUser") String actionForUser,
	// HttpSession session) {
	//
	// // ModelAndView mav = new ModelAndView("manageUsers");
	// String ex = null;
	//
	// if (actionForUser.equalsIgnoreCase("save")) {
	// ex = userProfileService.addUserDetails(userProfile, session);
	// } else if (actionForUser.equalsIgnoreCase("update")) {
	// userProfile.setsNo(sNo);
	// ex = userProfileService.updateUserDetails(userProfile, session);
	// } else if (actionForUser.equalsIgnoreCase("delete")) {
	// ex = userProfileDAO.deleteUser(sNo.intValue());
	// }
	// HashMap<String, Object> map = new HashMap<String, Object>();
	// map.put("result", ex);
	// Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
	// .create();
	// String json = gson.toJson(map);
	// return json;
	// }

	// @RequestMapping(value = "/getUserDetails", method = RequestMethod.POST)
	// @ResponseBody
	// public String getUserDetails() {
	//
	// ArrayList<UserProfile> allUserList = userProfileDAO.getAllUserProfile();
	//
	// for (UserProfile userProfile : allUserList) {
	// userProfile.setSupervisorName(userProfile
	// .getSupervisorUserProfile().getFirstName()
	// + " "
	// + userProfile.getSupervisorUserProfile().getLastName());
	// userProfile.setSupervisorId(userProfile.getSupervisorUserProfile()
	// .getsNo().intValue());
	// allUserList.set(allUserList.indexOf(userProfile), userProfile);
	// }
	//
	// HashMap<String, Object> map = new HashMap<String, Object>();
	// map.put("allUserList", allUserList);
	// Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
	// .create();
	// String json = gson.toJson(map);
	// return json;
	// }
}
