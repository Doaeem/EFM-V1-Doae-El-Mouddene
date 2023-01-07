package com.crjj.ismo.entities.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crjj.ismo.entities.Appartement;

import ma.ismo.crjj.util.HibernateUtil;

public class DaoAppartement implements IDao<Appartement>{
	
	@Override
	public List<Appartement> getAll() {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<Appartement> appartements = session.createQuery("from Appartement").getResultList();

		t.commit();
		session.close();

		return appartements;
	}

	@Override
	public Appartement getOne(int id) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Appartement appartement = session.get(Appartement.class, id);

		t.commit();
		session.close();

		return appartement;
	}

	@Override
	public boolean update(Appartement obj) {
		try {
			Session session = HibernateUtil.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.update(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Appartement obj) {
		try {
			Session session = HibernateUtil.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.delete(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
