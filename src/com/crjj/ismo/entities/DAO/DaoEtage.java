package com.crjj.ismo.entities.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crjj.ismo.entities.Etage;
import com.crjj.ismo.entities.Rue;

import ma.ismo.crjj.util.HibernateUtil;

public class DaoEtage implements IDao<Etage>{
	
	@Override
	public List<Etage> getAll() {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<Etage> etages = session.createQuery("from Etage").getResultList();

		t.commit();
		session.close();

		return etages;
	}

	@Override
	public Etage getOne(int id) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Etage etage = session.get(Etage.class, id);

		t.commit();
		session.close();

		return etage;
	}

	@Override
	public boolean update(Etage obj) {
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
	public boolean delete(Etage obj) {
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
