package com.elecnor.lighting.daoimpl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elecnor.lighting.bean.FixtureDescription;
import com.elecnor.lighting.bean.FixtureManufacturer;
import com.elecnor.lighting.bean.FixtureVariant;
import com.elecnor.lighting.bean.LampCatalogNum;
import com.elecnor.lighting.bean.LampManufacturer;
import com.elecnor.lighting.dao.MastreFixtureDAO;

@Repository
public class MastreFixtureDAOImpl implements MastreFixtureDAO {
	private static List<FixtureVariant> fixVariantList = null;
	private static List<FixtureDescription> fixDescList = null;
	private static List<FixtureManufacturer> fixManufacturerList = null;
	private static List<LampManufacturer> lampManufacturerList = null;
	private static List<LampCatalogNum> lampCatalogList = null;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addFixtureVariant(FixtureVariant fixVariantType) {
		Session session = null;
		try {
			session = (Session) sessionFactory.getCurrentSession();
			FixtureVariant fixVariant = (FixtureVariant) session
					.merge(fixVariantType);
			fixVariantList.add(fixVariant);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<FixtureVariant> getFixtureVariant() {
		try {
			if (fixVariantList == null) {
				fixVariantList = new LinkedList<FixtureVariant>();
				Session session = sessionFactory.getCurrentSession();
				Query query = session.createQuery("from FixtureVariant");
				fixVariantList = query.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fixVariantList;
	}

	@Override
	@Transactional
	public void addFixtureDescription(FixtureDescription fixDesc) {
		Session session = null;
		try {
			session = (Session) sessionFactory.getCurrentSession();
			FixtureDescription fixDescription = (FixtureDescription) session
					.merge(fixDesc);
			fixDescList.add(fixDescription);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<FixtureDescription> getFixtureDescription() {
		try {
			if (fixDescList == null) {
				fixDescList = new LinkedList<FixtureDescription>();
				Session session = sessionFactory.getCurrentSession();
				Query query = session.createQuery("from FixtureDescription");
				fixDescList = query.list();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fixDescList;
	}

	@Override
	@Transactional
	public void addFixtureManufacturer(FixtureManufacturer fixManufacturer) {
		Session session = null;
		try {
			session = (Session) sessionFactory.getCurrentSession();
			FixtureManufacturer fixManufact = (FixtureManufacturer) session
					.merge(fixManufacturer);
			fixManufacturerList.add(fixManufact);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<FixtureManufacturer> getFixtureManufacturer() {
		try {
			if (fixManufacturerList == null) {
				fixManufacturerList = new LinkedList<FixtureManufacturer>();
				Session session = sessionFactory.getCurrentSession();
				Query query = session.createQuery("from FixtureManufacturer");
				fixManufacturerList = query.list();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fixManufacturerList;
	}

	@Override
	@Transactional
	public void addLampManufacturer(LampManufacturer lampManufacturer) {
		Session session = null;
		try {
			session = (Session) sessionFactory.getCurrentSession();
			LampManufacturer lampManufact = (LampManufacturer) session
					.merge(lampManufacturer);
			lampManufacturerList.add(lampManufact);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<LampManufacturer> getLampManufacturerDetails() {
		try {
			if (lampManufacturerList == null) {
				Session session = sessionFactory.getCurrentSession();
				Query query = session.createQuery("from LampManufacturer");
				lampManufacturerList = query.list();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lampManufacturerList;
	}

	@Override
	@Transactional
	public void addLampCatalogNo(LampCatalogNum lampCatalogNum) {
		Session session = null;
		try {
			session = (Session) sessionFactory.getCurrentSession();
			LampCatalogNum lampNum = (LampCatalogNum) session
					.merge(lampCatalogNum);
			lampCatalogList.add(lampNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<LampCatalogNum> getLampCatalogNoDetails() {
		try {
			if (lampCatalogList == null) {
				Session session = sessionFactory.getCurrentSession();
				Query query = session.createQuery("from LampCatalogNum");
				lampCatalogList = query.list();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lampCatalogList;
	}
}
