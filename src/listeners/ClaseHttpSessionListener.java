package listeners;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class ClaseHttpSessionListener implements HttpSessionListener{
	
	private static final Logger log = LogManager.getRootLogger();

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
		HttpSession sesion = arg0.getSession();
		String idSesión = arg0.getSession().getId();
		ServletContext sc = arg0.getSession().getServletContext();
		HashMap<String, HttpSession> mapSes = (HashMap<String, HttpSession>) sc.getAttribute("SessionsMap");
		mapSes.put(arg0.getSession().getId(), sesion);
//		sc.setAttribute("SessionsMap", mapSes); no hace falta porque al actualizar el mapa ya se guardan los valores añadidos
		log.info("Estamos en sessionCreated y la sesión tiene el id " + idSesión);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
		HttpSession sesion = arg0.getSession();
		String idSesión = arg0.getSession().getId();
		ServletContext sc = arg0.getSession().getServletContext();
		HashMap<String, HttpSession> mapSes = (HashMap<String, HttpSession>) sc.getAttribute("SessionsMap");
		mapSes.remove(idSesión);
		log.info("Estamos en sessionDestroyed y la sesión " + idSesión + " ha sido borrarda del mapa");
		
	}

}
