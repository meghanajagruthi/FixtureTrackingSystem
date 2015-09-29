package com.elecnor.lighting.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.elecnor.lighting.bean.ProjectMaster;

public interface ProjectMasterService {
//	public String addOrUpdateProject(ProjectMaster projBean, int projManager, int projSupervisor, HttpSession session);
	public ArrayList<ProjectMaster> getAllProjectList(long domainId);
	public ProjectMaster getProjectDetailsById(long jobId);

}
