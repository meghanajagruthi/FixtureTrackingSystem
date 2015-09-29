package com.elecnor.lighting.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.elecnor.lighting.bean.ReportIssue;
import com.elecnor.lighting.dao.ReportIssueDAO;

@Repository
public class ReportIssueDAOImpl implements ReportIssueDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addIssueIntoDatabase(ReportIssue reportIssue) {
		Session session = null;
		try {
			session = (Session) sessionFactory.getCurrentSession();
			session.merge(reportIssue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
