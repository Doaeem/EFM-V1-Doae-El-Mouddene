package ma.ismo.crjj.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.crjj.ismo.entities.Appartement;
import com.crjj.ismo.entities.Etage;
import com.crjj.ismo.entities.Immeuble;
import com.crjj.ismo.entities.Rue;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	
	static {
		Configuration config = new Configuration();
		config.configure();
		
		config.addAnnotatedClass(Rue.class);
		config.addAnnotatedClass(Immeuble.class);
		config.addAnnotatedClass(Etage.class);
		config.addAnnotatedClass(Appartement.class);
		
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
}
