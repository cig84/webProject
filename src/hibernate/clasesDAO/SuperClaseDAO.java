package hibernate.clasesDAO;

import org.hibernate.Session;

/**
 * 
 * @author Francesco
 *Esta clase es una superclase que implementa una sesi�n y los m�todos getSession() y setSession().
 *Las clases que implementen esta superclase pueden llamar a estos m�todos cuando necesiten de una
 *nueva sesi�n.
 *
 */

public class SuperClaseDAO {
	
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
