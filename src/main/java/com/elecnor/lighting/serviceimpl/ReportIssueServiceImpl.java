package com.elecnor.lighting.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elecnor.lighting.bean.ReportIssue;
import com.elecnor.lighting.dao.ReportIssueDAO;
import com.elecnor.lighting.service.ReportIssueService;

@Service
public class ReportIssueServiceImpl implements ReportIssueService {

	@Autowired
	ReportIssueDAO reportDAO;

	@Override
	public void submitIssue(ReportIssue reportIssue) {
		reportDAO.addIssueIntoDatabase(reportIssue);
	}

}
