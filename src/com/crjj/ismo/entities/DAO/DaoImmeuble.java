package com.crjj.ismo.entities.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crjj.ismo.entities.Immeuble;
import com.crjj.ismo.entities.Rue;

import ma.ismo.crjj.util.HibernateUtil;

public class DaoImmeuble implements IDao<Immeuble>{
	
	@Override
	public List<Immeuble> getAll() {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<Immeuble> immeubles = session.createQuery("from Immeuble").getResultList();

		t.commit();
		session.close();

		return immeubles;
	}

	@Override
	public Immeuble getOne(int id) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Immeuble immeuble = session.get(Immeuble.class, id);

		t.commit();
		session.close();

		return immeuble;
	}

	@Override
	public boolean update(Immeuble obj) {
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
	public boolean delete(Immeuble obj) {
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
