package com.elecnor.lighting.helper;

import java.util.ArrayList;

import com.elecnor.lighting.bean.UserProfile;

public class UserProfileHelper {
	public static UserProfile getUserById(int id, ArrayList<UserProfile> userList) {
		for (UserProfile user : userList) {
			if (user.getsNo() == id) {
				return user;
			}
		}
		return null;
	}
	
	public static String getUserRole(long userId) throws Exception{
		String roleTemp = "ADMIN";
		
		try {
			if(userId == 2){
				roleTemp = "SUPERVISOR";
			} else if(userId == 3){
				roleTemp = "MANAGER";
			} else if(userId == 2){
				roleTemp = "FOREMAN";
			} else {
				roleTemp = "ADMIN";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return roleTemp;
	}
}
