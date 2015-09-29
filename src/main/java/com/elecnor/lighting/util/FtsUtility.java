package com.elecnor.lighting.util;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FtsUtility {

	public String getJsonResult(Object resultMap) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("MM-dd-yyyy").create();
		String json = gson.toJson(resultMap);
		return json;

	}

	public String getJsonResultWithoutExpose(HashMap<Object, Object> resultMap) {
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(resultMap);
		return json;

	}
	public HashMap<Object, Object> handleException(HashMap<Object, Object> resultMap, Exception e) {
		resultMap.put("ajaxResult", "failure");
		resultMap.put("reason", e.getMessage());
		// sendExceptionEmail(e);
		return resultMap;
	}
	public String getJsonResultWithExpose(HashMap<Object, Object> resultMap) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(resultMap);
		return json;

	}

	public String getEcosystemUrl() {

		try {
			PropertyFileReader propertyFileInstance = PropertyFileReader
					.getInstance();
			String hostName = propertyFileInstance
					.getStringProperty("PDHostName");
			String portNum = propertyFileInstance
					.getStringProperty("PDPortNumber");
			String protocol = propertyFileInstance
					.getStringProperty("PDProtocol");
			String ecosystemDeployementName = propertyFileInstance
					.getStringProperty("ecosystemDeployementName");
			String url = protocol + "://" + hostName + ":" + portNum + "/"
					+ ecosystemDeployementName + "/";
			return url;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public String getIssuetrackerUrlForReportIssue()throws Exception {

		String url = null;
		try {
			PropertyFileReader propertyFileInstance = PropertyFileReader
					.getInstance();
			String hostName = propertyFileInstance
					.getStringProperty("PDHostName");
			String portNum = propertyFileInstance
					.getStringProperty("PDPortNumber");
			String protocol = propertyFileInstance
					.getStringProperty("PDProtocol");
			String issueTrackerDeployementName = propertyFileInstance
					.getStringProperty("issueTrackerDeployementName");
			url = protocol + "://" + hostName + ":" + portNum + "/"
					+ issueTrackerDeployementName + "/excludeIntercepterRedirectedFromApps";
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return url;
	}
}
