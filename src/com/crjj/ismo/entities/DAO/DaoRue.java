package com.crjj.ismo.entities.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crjj.ismo.entities.Rue;

import ma.ismo.crjj.util.HibernateUtil;

public class DaoRue implements IDao<Rue>{
	
	@Override
	public List<Rue> getAll() {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<Rue> rues = session.createQuery("from Rue").getResultList();

		t.commit();
		session.close();

		return rues;
	}

	@Override
	public Rue getOne(int id) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Rue rue = session.get(Rue.class, id);

		t.commit();
		session.close();

		return rue;
	}

	@Override
	public boolean update(Rue obj) {
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
	public boolean delete(Rue obj) {
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
