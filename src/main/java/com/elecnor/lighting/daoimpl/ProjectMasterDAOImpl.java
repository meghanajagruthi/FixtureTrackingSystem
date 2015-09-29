package com.elecnor.lighting.daoimpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elecnor.lighting.bean.ProjectMaster;
import com.elecnor.lighting.dao.ProjectMasterDAO;

@Repository
public class ProjectMasterDAOImpl implements ProjectMasterDAO {
	private ArrayList<ProjectMaster> projList;

//	@Autowired
//	private SessionFactory sessionFactory;
//
//	@Override
//	@Transactional
//	public String addOrUpdateOrDeleteProject(ProjectMaster projBean) {
//		String ex = null;
//		Session ses = null;
//		boolean isFound = false;
//		try {
//			ses = (Session) sessionFactory.getCurrentSession();
//			ProjectMaster obj = (ProjectMaster) ses.merge(projBean);
//			System.out.println(projList.size());
//			for (ProjectMaster project : projList) {
//				if (obj.getJobId() == project.getJobId()) {
//					projList.set(projList.indexOf(project), obj);
//					isFound = true;
//					break;
//				}
//			}
//			if (!isFound) {
//				projList.add(obj);
//			}
//		} catch (Exception e) {
//			ex = e.getMessage();
//			e.printStackTrace();
//		}
//		return ex;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	@Transactional
//	public ArrayList<ProjectMaster> getAllProjectList() {
//		try {
//			if (projList == null) {
//				projList = new ArrayList<ProjectMaster>();
//				Session session = sessionFactory.getCurrentSession();
//				projList = (ArrayList<ProjectMaster>) session.createCriteria(
//						ProjectMaster.class).list();
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return projList;
//	}
//
//	@Override
//	@Transactional
//	public String setProjectToDelete(long id) {
//		String result=null;
//		try {
//			Session session = sessionFactory.getCurrentSession();
//			ProjectMaster project = (ProjectMaster) session.get(
//					ProjectMaster.class, id);
//			project.setStatus("INACTIVE");
//			session.update(project);
//			for (ProjectMaster proj : projList) {
//				if (proj.getJobId().equals(id)) {
//					projList.set(projList.indexOf(proj), project);
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//		    result=e.getMessage();
//			e.printStackTrace();
//		}
//		return result;
//	}

}
