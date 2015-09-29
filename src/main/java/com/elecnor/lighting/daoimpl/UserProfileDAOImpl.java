package com.elecnor.lighting.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elecnor.lighting.bean.UserProfile;
import com.elecnor.lighting.dao.UserProfileDAO;

@Repository
public class UserProfileDAOImpl implements UserProfileDAO {

//	@Autowired
//	private SessionFactory sessionFactory;
//	private static ArrayList<UserProfile> userList;
//
//	@SuppressWarnings("unchecked")
//	@Transactional
//	public List<UserProfile> AuthenticateUser(String userName, String password) {
//		try {
//			Query query = sessionFactory.getCurrentSession().createQuery(
//					"from UserProfile where userId = :userId");
//			query.setParameter("userId", userName);
//			return query.list();
//		} catch (HibernateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Override
//	public ArrayList<UserProfile> getAllUserProfile() {
//		try {
//			if (userList == null) {
//				Query query = sessionFactory.getCurrentSession().createQuery(
//						"from UserProfile");
//				userList = (ArrayList<UserProfile>) query.list();
//			}
//		} catch (HibernateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return userList;
//	}
//
//	@Override
//	@Transactional
//	public String addUserDetails(UserProfile userProfile) {
//		Session session = null;
//		String res = null;
//		try {
//
//			session = sessionFactory.getCurrentSession();
//			UserProfile users = (UserProfile) session.merge(userProfile);
//			userList.add(users);
//		} catch (Exception e) {
//			e.printStackTrace();
//			res = e.getMessage();
//		}
//		return res;
//	}
//
//	@Override
//	@Transactional
//	public String deleteUser(Integer sNo) {
//		String ex = null;
//		Session session = null;
//		try {
//			session = sessionFactory.getCurrentSession();
//			UserProfile userProfile = (UserProfile) session.get(
//					UserProfile.class, sNo);
//			userProfile.setStatus("INACTIVE");
//			session.update(userProfile);
//			for (UserProfile users : userList) {
//				if (users.getsNo().equals(sNo)) {
//					users.setStatus("INACTIVE");
//					userList.set(userList.indexOf(users), users);
//					break;
//				}
//			}
//		} catch (Exception e) {
//			ex = e.getMessage();
//			e.printStackTrace();
//		}
//		return ex;
//	}
//
//	@Override
//	@Transactional
//	public String updateUserDetails(UserProfile userProfile) {
//		String ex = null;
//		Session session = null;
//		try {
//			session = sessionFactory.getCurrentSession();
//			session.merge(userProfile);
//			for (UserProfile users : userList) {
//				System.out.println(users.getsNo());
//				System.out.println(userProfile.getsNo());
//				if (users.getsNo().equals(userProfile.getsNo())) {
//					userList.set(userList.indexOf(users), userProfile);
//					break;
//				}
//			}
//		} catch (Exception e) {
//			ex = e.getMessage();
//			e.printStackTrace();
//		}
//		return ex;
//	}

}
