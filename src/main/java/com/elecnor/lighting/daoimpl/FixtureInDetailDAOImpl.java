package com.elecnor.lighting.daoimpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elecnor.lighting.bean.ADesign;
import com.elecnor.lighting.bean.AtticStock;
import com.elecnor.lighting.bean.BadFixtureLamp;
import com.elecnor.lighting.bean.ChangeOrder;
import com.elecnor.lighting.bean.EDesign;
import com.elecnor.lighting.bean.FixtureIssue;
import com.elecnor.lighting.bean.FixtureTracking;
import com.elecnor.lighting.dao.FixtureInDetailDAO;

@Repository
public class FixtureInDetailDAOImpl implements FixtureInDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addESheetDetails(EDesign eDesign) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.merge(eDesign);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<EDesign> getESheetDetails(Long fixId) {
		Session session = null;
		session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from EDesign where FIXTURE_ID=:fixId");
		query.setParameter("fixId", fixId);
		List<EDesign> eDesignList = query.list();
		return eDesignList;
	}

	@Override
	@Transactional
	public void addASheetDetails(ADesign aDesign) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.merge(aDesign);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ADesign> getASheetDetails(Long fixtureId) {
		Session session = null;
		session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from ADesign where FIXTURE_ID=:fixtureId");
		query.setParameter("fixtureId", fixtureId);
		List<ADesign> aDesignList = query.list();
		return aDesignList;
	}

	@Override
	@Transactional
	public void addAttickDetails(AtticStock atticStock) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.merge(atticStock);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<AtticStock> getAtticStockDetails(Long fixtureId) {
		Session session = null;
		session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from AtticStock where FIXTURE_ID=:fixtureId");
		query.setParameter("fixtureId", fixtureId);
		List<AtticStock> atticStockList = query.list();
		return atticStockList;
	}

	@Override
	@Transactional
	public String updateESheet(EDesign eDesign) {
		Session session = null;
		session = sessionFactory.getCurrentSession();
		session.merge(eDesign);
		return null;
	}

	@Override
	@Transactional
	public String deleteESheet(long eDesignId) {
		Session session = sessionFactory.getCurrentSession();
		EDesign eDesign = (EDesign) session.get(EDesign.class, eDesignId);
		session.delete(eDesign);

		return null;
	}

	@Override
	@Transactional
	public String updateASheet(ADesign aDesign) {
		Session session = null;
		session = sessionFactory.getCurrentSession();
		session.merge(aDesign);
		return null;
	}

	@Override
	@Transactional
	public String deleteASheet(long aDesignId) {
		Session session = sessionFactory.getCurrentSession();
		ADesign aDesign = (ADesign) session.get(ADesign.class, aDesignId);
		session.delete(aDesign);
		return null;
	}

	@Override
	@Transactional
	public String updateAtticStock(AtticStock atticStock) {
		Session session = null;
		session = sessionFactory.getCurrentSession();
		session.merge(atticStock);
		return null;
	}

	@Override
	@Transactional
	public String deleteAtticStock(long atticStockId) {
		Session session = sessionFactory.getCurrentSession();
		AtticStock atticStock = (AtticStock) session.get(AtticStock.class,
				atticStockId);
		session.delete(atticStock);
		return null;
	}

	@Override
	@Transactional
	public void addIssueDetail(FixtureIssue issue) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.merge(issue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void deleteIssueDetails(long issueId) {
		Session session = sessionFactory.getCurrentSession();
		FixtureIssue fixtureIssue = (FixtureIssue) session.get(
				FixtureIssue.class, issueId);
		session.delete(fixtureIssue);
	}

	@Override
	@Transactional
	public void updateIssues(FixtureIssue issue) {
		Session session = null;
		session = sessionFactory.getCurrentSession();
		session.merge(issue);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<FixtureIssue> getIssueDetails(Long fixtureId) {
		Session session = null;
		session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from FixtureIssue where FIXTURE_ID=:fixtureId");
		query.setParameter("fixtureId", fixtureId);
		List<FixtureIssue> issueList = query.list();
		return issueList;
	}

	@Override
	@Transactional
	public void deleteChangeOrder(Long changeOrderId) {
		Session session = sessionFactory.getCurrentSession();
		ChangeOrder changeOrder = (ChangeOrder) session.get(ChangeOrder.class,
				changeOrderId);
		session.delete(changeOrder);
	}

	@Override
	@Transactional
	public void addChangeOrderDetail(ChangeOrder changeOrder) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.merge(changeOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void updateChangeOrder(ChangeOrder changeOrder) {
		Session session = null;
		session = sessionFactory.getCurrentSession();
		session.merge(changeOrder);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ChangeOrder> getChangeOrderDetails(Long fixtureId) {
		Session session = null;
		session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from ChangeOrder where FIXTURE_ID=:fixtureId");
		query.setParameter("fixtureId", fixtureId);
		List<ChangeOrder> changeOrderList = query.list();
		return changeOrderList;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public String addUpdateTrackingDetails(FixtureTracking fixtureTracking,
			BadFixtureLamp badFixtureObj, BadFixtureLamp badLampObj) {
		String ex = null;
		Session ses = null;
		try {
			// Saving/Updating Fixture Tracking Details
			ses = (Session) sessionFactory.getCurrentSession();
			fixtureTracking = (FixtureTracking) ses.merge(fixtureTracking);
			// For a particular tracking_id there has to be 2 rows in DB , one
			// for badFixture and other for badLamp
			String hql = "FROM com.elecnor.lighting.bean.BadFixtureLamp WHERE TRACKING_ID = :tracking_id";
			Query query = ses.createQuery(hql);
			query.setParameter("tracking_id", fixtureTracking.getTrackingId());
			List<BadFixtureLamp> badFixtureLamplist = query.list();
			// Checking If Already exists, if yes then setting with respective
			// primary key
			for (BadFixtureLamp badFixtureLamp : badFixtureLamplist) {
				if (badFixtureLamp.getType().equalsIgnoreCase("FIXTURE")) {
					badFixtureObj.setBadFixtureId(badFixtureLamp
							.getBadFixtureId());
				} else if (badFixtureLamp.getType().equalsIgnoreCase("LAMP")) {
					badLampObj
							.setBadFixtureId(badFixtureLamp.getBadFixtureId());
				}
			}
			// Setting Type And Tracking Id for Fixture Row
			badFixtureObj.setType("FIXTURE");
			badFixtureObj.setBadFixtureForfixtureTracking(fixtureTracking);

			// Setting Type And Tracking Id for Lamp Row
			badLampObj.setType("LAMP");
			badLampObj.setBadFixtureForfixtureTracking(fixtureTracking);
			// Saving 1st row
			ses.merge(badFixtureObj);
			// Saving 2nd row
			ses.merge(badLampObj);

		} catch (Exception e) {
			ex = e.getStackTrace().toString();
			e.printStackTrace();
		}
		return ex;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<FixtureTracking> getFixtureTrackingDetails(Long fixtureId) {
		Session ses = null;
		List<FixtureTracking> fixTrackList = null;
		try {
			ses = (Session) sessionFactory.getCurrentSession();
			Query query = ses.createQuery(
					"from FixtureTracking where FIXTURE_ID=:fixtureId")
					.setLong("fixtureId", fixtureId);
			fixTrackList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fixTrackList;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<BadFixtureLamp> getBadFixtureLampDetails(long trackingId) {
		Session ses = null;
		List<BadFixtureLamp> badFixtureLampList = null;
		try {
			ses = (Session) sessionFactory.getCurrentSession();
			Query query = ses.createQuery(
					"from BadFixtureLamp where TRACKING_ID=:trackingId")
					.setLong("trackingId", trackingId);
			badFixtureLampList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return badFixtureLampList;
	}

	@Override
	@Transactional
	public int deleteTracking(long trackingId) {
		int result = 0;
		Session ses = null;
		try {
			ses = sessionFactory.getCurrentSession();
			Query query = ses.createQuery(
					"delete from BadFixtureLamp where TRACKING_ID=:trackId")
					.setLong("trackId", trackingId);
			result = query.executeUpdate();
			if (result != 0) {
				query = ses
						.createQuery(
								"delete from FixtureTracking where TRACKING_ID=:trackingId")
						.setLong("trackingId", trackingId);
				result = query.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public HashMap<String, Object> getFixtureInDetailSummaryData(Long fixtureId) {
		Session ses = null;
		HashMap<String, Object> summaryData = null;
		try {
			summaryData = new HashMap<String, Object>();
			ses = (Session) sessionFactory.getCurrentSession();
			Query query = ses
					.createQuery(
							"SELECT SUM(aDesignCount) FROM ADesign where FIXTURE_ID=:fixtureId")
					.setLong("fixtureId", fixtureId);
			summaryData.put("ADesignCount", query.list().get(0) == null ? 0L
					: query.list().get(0));
			query = ses
					.createQuery(
							"SELECT SUM(eDesignCount) FROM EDesign where FIXTURE_ID=:fixtureId")
					.setLong("fixtureId", fixtureId);
			summaryData.put("EDesignCount", query.list().get(0) == null ? 0L
					: query.list().get(0));
			query = ses
					.createQuery(
							"SELECT SUM(atticStockCount),SUM(spareCount) FROM AtticStock where FIXTURE_ID=:fixtureId")
					.setLong("fixtureId", fixtureId);
			Iterator<Object[]> list = query.list().iterator();
			Object[] tuple = list.next();

			summaryData.put("atticCount", tuple[0] == null ? 0L : tuple[0]);
			summaryData.put("spareCount", tuple[1] == null ? 0L : tuple[1]);
			query = ses
					.createQuery(
							"SELECT SUM(fixtureQty),SUM(lampQty),SUM(fixtureGood),SUM(lampGood) FROM FixtureTracking where FIXTURE_ID=:fixtureId")
					.setLong("fixtureId", fixtureId);
			list = query.list().iterator();
			tuple = list.next();

			summaryData.put("fixtureQty", tuple[0] == null ? 0L : tuple[0]);
			summaryData.put("lampQty", tuple[1] == null ? 0L : tuple[1]);
			summaryData.put("fixtureGood", tuple[2] == null ? 0L : tuple[2]);
			summaryData.put("lampGood", tuple[3] == null ? 0L : tuple[3]);
			query = ses
					.createQuery(
							"SELECT COUNT(issueProb) FROM FixtureIssue where FIXTURE_ID=:fixtureId")
					.setLong("fixtureId", fixtureId);
			summaryData.put("issueCount", query.list().get(0) == null ? 0L
					: query.list().get(0));
			query = ses
					.createQuery(
							"SELECT SUM(quantity) FROM ChangeOrder where FIXTURE_ID=:fixtureId")
					.setLong("fixtureId", fixtureId);
			summaryData.put("changeOrder", query.list().get(0) == null ? 0L
					: query.list().get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return summaryData;
	}

}
