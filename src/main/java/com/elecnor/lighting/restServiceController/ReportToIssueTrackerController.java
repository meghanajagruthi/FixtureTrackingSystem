package com.elecnor.lighting.restServiceController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.elecnor.lighting.bean.UserProfile;
import com.elecnor.lighting.util.FtsUtility;
import com.elecnor.lighting.util.PropertyFileReader;
import com.google.gson.Gson;

@RestController
public class ReportToIssueTrackerController {

	@Value("${application.name}")
	String applicationName;

	@Value("${application.id}")
	Integer applicationId;

	@Value("${issueTracker.url}")
	String issueTrackerUrl;

	MultiValueMap<String, Object> uploadForm = new LinkedMultiValueMap<String, Object>();

	@RequestMapping(value = "/RedirectedFromDownStreamApp/getApplicationDetailsFromIssueTracker")
	public String getApplicationDetails(HttpServletRequest request) {

		FtsUtility util = new FtsUtility();
		HashMap<Object, Object> applicationDetails = new HashMap<Object, Object>();
		applicationDetails.put(applicationId, applicationName);
		return util.getJsonResult(applicationDetails);
	}

	@RequestMapping(value = "/getAllIssueTypesFromIssueTracker", method = RequestMethod.GET)
	public String getAllIssueTypesFromIssueTracker() {

		FtsUtility util = new FtsUtility();
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> issueTypesList = null;
		try {
			issueTypesList = restTemplate
					.getForEntity(
							issueTrackerUrl
									+ "RedirectedFromDownStreamApp/getAllIssueTypesFromIssueTracker",
							String.class);
		} catch (Exception e) {

			HashMap<Object, Object> resultMap = new HashMap<Object, Object>();
			util.handleException(resultMap, e);
			e.printStackTrace();
			return null;
		}
		return issueTypesList.getBody();
	}

	/*
	 * @RequestMapping(value = "/getAllStatusFromIssueTracker", method =
	 * RequestMethod.GET) public String getAllStatusFromIssueTracker() {
	 * 
	 * FtsUtility util = new FtsUtility(); RestTemplate restTemplate = new
	 * RestTemplate(); ResponseEntity<String> statusList = null; try {
	 * statusList = restTemplate .getForEntity(
	 * "http://localhost:8080/ElecnorIssueTracker/RedirectedFromDownStreamApp/getAllStatusFromIssueTracker"
	 * , String.class); } catch (Exception e) {
	 * 
	 * HashMap<Object, Object> resultMap = new HashMap<Object, Object>();
	 * util.handleException(resultMap, e); e.printStackTrace(); } return
	 * statusList.getBody(); }
	 */

	@RequestMapping(value = "/getAllSeverityFromIssueTracker", method = RequestMethod.GET)
	public String getAllSeverityFromIssueTracker() {
		FtsUtility util = new FtsUtility();
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> severityList = null;
		try {
			severityList = restTemplate
					.getForEntity(
							issueTrackerUrl
									+ "RedirectedFromDownStreamApp/getAllSeveritiesFromIssueTracker",
							String.class);
		} catch (Exception e) {

			HashMap<Object, Object> resultMap = new HashMap<Object, Object>();
			util.handleException(resultMap, e);
			e.printStackTrace();
			return null;
		}
		return severityList.getBody();
	}

	@RequestMapping(value = "/getAllModulesFromIssueTracker", method = RequestMethod.POST)
	public String getAllModulesFromIssueTracker(HttpServletRequest request) {

		FtsUtility util = new FtsUtility();
		RestTemplate restTemplate = new RestTemplate();
		String json = null;
		try {
			json = restTemplate
					.getForObject(
							issueTrackerUrl
									+ "RedirectedFromDownStreamApp/getAllModulesFromIssueTracker?applicationId=4",
							String.class);
		} catch (Exception e) {

			HashMap<Object, Object> resultMap = new HashMap<Object, Object>();
			util.handleException(resultMap, e);
			e.printStackTrace();
		}
		return json;
	}

	@RequestMapping(value = "/getAllProjectsFromIssueTracker", method = RequestMethod.POST)
	public String getAllProjectsFromIssueTracker(HttpServletRequest request,
			HttpSession session) {

		UserProfile userDetail = (UserProfile) session
				.getAttribute("selectedUser");
		Long domainId = userDetail.getDomainIdTransient();
		FtsUtility util = new FtsUtility();
		RestTemplate restTemplate = new RestTemplate();
		String json = null;
		try {
			json = restTemplate
					.getForObject(
							issueTrackerUrl
									+ "RedirectedFromDownStreamApp/getAllProjectsFromIssueTracker?applicationId=4&domainId="
									+ domainId, String.class);

		} catch (Exception e) {

			HashMap<Object, Object> resultMap = new HashMap<Object, Object>();
			util.handleException(resultMap, e);
			e.printStackTrace();
		}
		return json;
	}

	@RequestMapping(value = "/reportToIssueTracker", method = RequestMethod.POST)
	public String reportToIssueTracker(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			@RequestParam("uploadFile") List<MultipartFile> attachedFile) {

		String status = null;
		try {

			UserProfile logedInUser = (UserProfile) session
					.getAttribute("selectedUser");
			System.out.println(attachedFile.size());
			RestTemplate restTemplate = new RestTemplate();
			HashMap<String, Object> form = new HashMap<String, Object>();
			form.put("applicationId", request.getParameter("applicationId"));
			form.put("applicationModuleId",
					request.getParameter("applicationModuleId"));
			form.put("relatedProject", request.getParameter("relatedProject"));
			form.put("issueType", request.getParameter("issueTypeId"));
			form.put("summary", request.getParameter("summary"));
			form.put("description", request.getParameter("description"));
			form.put("statusId", request.getParameter("statusId"));
			form.put("severityId", request.getParameter("severityId"));
			form.put("startDate", request.getParameter("startDate"));
			form.put("dueDate", request.getParameter("dueDate"));
			form.put("reportedById", logedInUser.getsNo().toString());
			form.put("reportedByName", logedInUser.getFirstName());
			form.put("reportedByEmailId", logedInUser.getEmailId());
			HashMap<String, String> attachmentMap = new HashMap<String, String>();
			if (attachedFile != null && !attachedFile.isEmpty()) {
				Iterator<MultipartFile> iter = attachedFile.iterator();
				MultipartFile tempFile = null;
				while (iter.hasNext()) {
					tempFile = iter.next();
					if (tempFile.getSize() > 0) {
						attachmentMap.put(tempFile.getOriginalFilename(),
								new String(tempFile.getBytes()));
					}

				}
			}

			form.put("attchmentMap", attachmentMap);
			// Converting "form" MAP for JSON String and sending it to Ecosystem
			// through rest API.
			Gson gson = new Gson();
			String requestStr = gson.toJson(form);
			status = restTemplate.postForObject(issueTrackerUrl
					+ "RedirectedFromDownStreamApp/saveRaisedTickets",
					requestStr, String.class);

		} catch (Exception e) {

			System.out.println("error while creating issue");
			e.printStackTrace();
		}
		return status;
	}

	@RequestMapping(value = "/redirectToIssueTrackerApp", method = RequestMethod.POST)
	public String redirectToIssueTrackerApp(HttpSession session) {
		HashMap<Object, Object> responseMap = new HashMap<Object, Object>();
		FtsUtility util = new FtsUtility();
		try {
			
			String issueTrackerURL = issueTrackerUrl
					+ "excludeIntercepterRedirectedFromApps";
			UserProfile selectedUser = (UserProfile) session
					.getAttribute("selectedUser");
			responseMap.put("issueTrackerUrl", issueTrackerURL);
			responseMap.put("emailId", selectedUser.getEmailId());
			responseMap.put("password", selectedUser.getPassword());
			responseMap.put("applicationId", applicationId);
			responseMap.put("ajaxResult", "success");
		} catch (Exception e) {
			responseMap.put("ajaxResult", "failure");
			responseMap.put("reason", e.getMessage());
			util.handleException(responseMap, e);
			e.printStackTrace();
		}
		return util.getJsonResult(responseMap);
	}

}
