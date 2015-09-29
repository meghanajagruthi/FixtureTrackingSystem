package com.elecnor.lighting.serviceimpl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.elecnor.lighting.bean.UserProfile;
import com.elecnor.lighting.dao.UserProfileDAO;
import com.elecnor.lighting.service.UserProfileService;
import com.elecnor.lighting.util.FMSConstants;
import com.elecnor.lighting.util.FtsUtility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileDAO userProfileDao;

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<UserProfile> getAllUserProfiles(long domainId) {
		ArrayList<UserProfile> allUserProfiles = null;
		FtsUtility utilRef = new FtsUtility();
		try {
			String url = utilRef.getEcosystemUrl()
					+ "excludeInterceptor/getUserListByDomain?id=" + domainId;
			RestTemplate restTemplate = new RestTemplate();

			String jobDetails = restTemplate.getForObject(url, String.class);
			Gson gson = new Gson();
			allUserProfiles = gson.fromJson(jobDetails, ArrayList.class);
		} catch (Exception e) {
			allUserProfiles = null;
			e.printStackTrace();
		}
		return allUserProfiles;
	}

	@Override
	public String AuthenticateUser(String userName, String password,
			HttpServletRequest request) {

		FtsUtility utilRef = new FtsUtility();
		UserProfile logedUser = null;
		String resultView = FMSConstants.FMS_REDIRECT_TO_INDEX_PAGE;
		HttpSession htpSession = request.getSession(false);
		try {
			/*if (userName.trim().equalsIgnoreCase("-1")
					|| password.trim().equalsIgnoreCase("-1")
					|| password.length() <= 50) {*/
				/*if (htpSession.getAttribute(FMSConstants.FMS_LOGGED_USER_SESSION_NAME) != null) {
					logedUser = (UserProfile) htpSession
							.getAttribute(FMSConstants.FMS_LOGGED_USER_SESSION_NAME);
				}*/
			/*} else {*/
				
				String url = utilRef.getEcosystemUrl()
						+ "excludeInterceptor/getUserDetails?emailId="
						+ userName.trim();
				RestTemplate restTemplate = new RestTemplate();
				String jsonDetails = restTemplate.getForObject(url, String.class);
				GsonBuilder gsonBuilder = new GsonBuilder();
				gsonBuilder.setDateFormat("MM-dd-yyyy");
				Gson gson = gsonBuilder.create();
				// if we will get the response as "failed" then user is not
				// authenticated or plan is not active
				if (jsonDetails.contains("failed") && jsonDetails.length() == 8) {
					resultView = FMSConstants.FMS_REDIRECT_TO_ERROR_PAGE;
				} else if (jsonDetails.contains("autfai") && jsonDetails.length() == 8) {
					resultView = FMSConstants.FMS_REDIRECT_TO_UNAUTHENTICATED_PAGE;
				}  else {
					logedUser = gson.fromJson(jsonDetails, UserProfile.class);
					logedUser.setRole(request.getParameter("userRoleName").toUpperCase());
				}
				
			//}
			
			if (logedUser != null) {
				htpSession.setAttribute("selectedProjId",
						request.getParameter("projId"));
				htpSession.setAttribute(FMSConstants.FMS_LOGGED_USER_SESSION_NAME, logedUser);
				resultView =  FMSConstants.FMS_REDIRECT_TO_INDEX_PAGE;
			} 

		} catch (Exception e) {
			resultView = FMSConstants.FMS_REDIRECT_TO_ERROR_PAGE;
			e.printStackTrace();
		}
		return resultView;

		// List<UserProfile> userList =
		// userProfileDao.AuthenticateUser(userName,
		// password);
		// if(userList.isEmpty()){
		// request.setAttribute("loginErrorMsg", "Incorrect Login");
		// }
		// for (UserProfile user : userList) {
		// if (user.getUserId().equals(userName)
		// && user.getPassword().equals(password)) {
		// return user;
		// } else {
		// String savedPassword = "";
		// String savedUserId = "";
		// savedPassword = user.getPassword().trim();
		// savedUserId = user.getUserId().trim();
		//
		// if ((!savedUserId.equals(userName)) ||
		// (!savedPassword.equals(password))) {
		// request.setAttribute("loginErrorMsg", "Incorrect Login");
		// return null;
		// }
		// }
		// }
		// return null;
	}


	// @Override
	// public String addUserDetails(UserProfile userProfile, HttpSession
	// session) {
	// String res=null;
	// ArrayList<UserProfile> userList = userProfileDao.getAllUserProfile();
	// UserProfile userObj = (UserProfile) session
	// .getAttribute("selectedUser");
	// try {
	// userProfile.setSupervisorUserProfile(UserProfileHelper.getUserById(
	// Integer.parseInt(userProfile.getSupervisorSelect()),
	// userList));
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// }
	// userProfile.setSubmittedByUserProfile(UserProfileHelper.getUserById(
	// userObj.getsNo().intValue(), userList));
	// userProfile.setStatus("ACTIVE");
	// userProfile.setSubmittedDate(new Date());
	// return userProfileDao.addUserDetails(userProfile);
	//
	// }
	//
	// @Override
	// public String updateUserDetails(UserProfile userProfile, HttpSession
	// session) {
	// ArrayList<UserProfile> userList = userProfileDao.getAllUserProfile();
	// UserProfile userObj = (UserProfile) session
	// .getAttribute("selectedUser");
	// try {
	// userProfile.setSupervisorUserProfile(UserProfileHelper.getUserById(
	// Integer.parseInt(userProfile.getSupervisorSelect()),
	// userList));
	// } catch (NumberFormatException e) {
	//
	// }
	// userProfile.setSubmittedByUserProfile(UserProfileHelper.getUserById(
	// userObj.getsNo().intValue(), userList));
	// userProfile.setStatus("ACTIVE");
	// userProfile.setSubmittedDate(new Date());
	// return userProfileDao.updateUserDetails(userProfile);
	//
	// }

}
