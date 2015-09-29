package com.elecnor.lighting.daoimpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elecnor.lighting.bean.FixtureMaster;
import com.elecnor.lighting.dao.FixtureDAO;

@Repository
public class FixtureDAOImpl implements FixtureDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public String addUpdateFixtureDetails(FixtureMaster fixture) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.merge(fixture);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<FixtureMaster> getFixtureByProject(long projectId) {
		List<FixtureMaster> fixtureList = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			fixtureList = session
					.createQuery(
							"from com.elecnor.lighting.bean.FixtureMaster where PROJECT_ID=:project_id")
					.setLong("project_id", projectId).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fixtureList;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Iterator<Object[]> getFixtureSummaryByProject(long projectId) {
		Iterator<Object[]> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			list = session
					.createQuery(
							"SELECT fixtureId,fixtureType from FixtureMaster where PROJECT_ID=:project_id and STATUS=:status")
					.setLong("project_id", projectId)
					.setString("status", "ACTIVE").list().iterator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	@Transactional
	public void setProjectToDelete(long fixtureNumber) {
		try {
			Session session = sessionFactory.getCurrentSession();
			FixtureMaster fixture = (FixtureMaster) session.get(
					FixtureMaster.class, fixtureNumber);
			fixture.setStatus("INACTIVE");
			session.update(fixture);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
