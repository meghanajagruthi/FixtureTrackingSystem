package com.elecnor.lighting.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.elecnor.lighting.bean.UserProfile;

public interface UserProfileService {
	
	public String AuthenticateUser(String userName , String Password, HttpServletRequest request);
	
	public ArrayList<UserProfile> getAllUserProfiles(long domainId);
	
//	public String addUserDetails(UserProfile userProfile, HttpSession session);
//
//	public String updateUserDetails(UserProfile userProfile, HttpSession session);

}
