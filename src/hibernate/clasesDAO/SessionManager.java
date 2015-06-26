package hibernate.clasesDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Francesco
 * Esta clase permite crear un pool de conesiones con la base de datos. Cada vez que un servicio necesita
 * de una conecci�n la pide a esta clase llamando al metodo obtener sesi�n. Al final se puede cerrar la 
 * sesi�n con el m�todo cerrar. 
 * El pool de conecciones se pon een un bloque static como si fuera un Patron Singleton, 
 * as� que se puede pedir s�lo una SessionFactory a la vez con el m�todo getSessionFactory().
 *
 */
public class SessionManager {
	
	static {
		try {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static SessionFactory factory;
	
	private SessionManager() {
		
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static Session obtenerSession() {
		return factory.openSession();
	}
	
	public static void cerrar(Session session) {
		session.close();
	}

}
