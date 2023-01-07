package com.crjj.ismo.entities.DAO.DaoTAppartementest;
import com.crjj.ismo.entities.Appartement;
import com.crjj.ismo.entities.Etage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.crjj.ismo.entities.DAO.DaoFactory;
import com.crjj.ismo.entities.DAO.IDao;
import com.crjj.ismo.entities.DAO.TypeDao;

public class DaoAppartementTest {
	
	@Test
	void getAllAppartement() {
		IDao dao = DaoFactory.getDAO(TypeDao.Appartement);
		List<Appartement> app = dao.getAll();
		
		assertNotNull(app);
		assertEquals(app.size(), 16);
	}
	
	@Test
	void getOneAppartement() {
		IDao dao = DaoFactory.getDAO(TypeDao.Appartement);
		Appartement app = (Appartement) dao.getOne(1);

		assertNull(app);
	}
	
	@Test
	void updateAppartement() {
		IDao dao = DaoFactory.getDAO(TypeDao.Appartement);
		List<Appartement> app = dao.getAll();
		Appartement a = new Appartement("A",5,4);
		dao.update(a);
		List<Appartement> app2 = dao.getAll();
		assertEquals(app.size()+1, app2.size());
	}

}
