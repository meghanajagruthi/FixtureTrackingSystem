package com.elecnor.lighting.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.elecnor.lighting.bean.ProjectMaster;
import com.elecnor.lighting.bean.UserProfile;
import com.elecnor.lighting.dao.ProjectMasterDAO;
import com.elecnor.lighting.dao.UserProfileDAO;
import com.elecnor.lighting.helper.UserProfileHelper;
import com.elecnor.lighting.service.ProjectMasterService;
import com.elecnor.lighting.util.FtsUtility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class ProjectMasterServiceImpl implements ProjectMasterService {

	@Autowired
	UserProfileDAO userProfileDAO;
	@Autowired
	ProjectMasterDAO projectMasterDAO;

	@Override
	public ArrayList<ProjectMaster> getAllProjectList(long domainId) {
		ArrayList<ProjectMaster> allJobDetails = null;
		FtsUtility utilRef = new FtsUtility();
		try {
			String url = utilRef.getEcosystemUrl()
					+ "excludeInterceptor/getJobListByDomainId?id=" + domainId;
			RestTemplate restTemplate = new RestTemplate();

			String jobDetails = restTemplate.getForObject(url, String.class);
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setDateFormat("MM-dd-yyyy");
			Gson gson = gsonBuilder.create();

			ProjectMaster[] jobArray = gson.fromJson(jobDetails,
					ProjectMaster[].class);
			allJobDetails = new ArrayList<ProjectMaster>(
					Arrays.asList(jobArray));
		} catch (Exception e) {
			allJobDetails = null;
			e.printStackTrace();
		}
		return allJobDetails;
	}

	@Override
	public ProjectMaster getProjectDetailsById(long jobId) {
		ProjectMaster jobDetails = null;
		FtsUtility utilRef = new FtsUtility();
		try {
			String url = utilRef.getEcosystemUrl()
					+ "excludeInterceptor/getJobDetailsByJobId?jobId=" + jobId;
			RestTemplate restTemplate = new RestTemplate();
			String jsonDetails = restTemplate.getForObject(url, String.class);
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setDateFormat("MM-dd-yyyy");
			Gson gson = gsonBuilder.create();
			jobDetails = gson.fromJson(jsonDetails, ProjectMaster.class);
		} catch (Exception e) {
			jobDetails = null;
			e.printStackTrace();
		}
		return jobDetails;
	}

	// @Override
	// public String addOrUpdateProject(ProjectMaster projBean, int projManager,
	// int projSupervisor, HttpSession session) {
	// String result=null;
	// try{
	// UserProfile userObj = (UserProfile) session
	// .getAttribute("selectedUser");
	//
	//
	// ArrayList<UserProfile> userList = userProfileDAO.getAllUserProfile();
	// projBean.setManager(UserProfileHelper.getUserById(
	// projManager, userList));
	// projBean.setSupervisor(UserProfileHelper.getUserById(
	// projSupervisor, userList));
	// projBean.setSubmittedBy(UserProfileHelper.getUserById(
	// userObj.getsNo().intValue(), userList));
	// projBean.setStatus("ACTIVE");
	// projBean.setSubmittedDate(new Date());
	// projBean.setUpdatedBy(userObj);
	// projectMasterDAO.addOrUpdateOrDeleteProject(projBean);
	// }
	// catch(Exception e)
	// {
	// result=e.getMessage();
	// }
	// return result;
	// }
	//

}
