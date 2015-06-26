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
		String idSesi�n = arg0.getSession().getId();
		ServletContext sc = arg0.getSession().getServletContext();
		HashMap<String, HttpSession> mapSes = (HashMap<String, HttpSession>) sc.getAttribute("SessionsMap");
		mapSes.put(arg0.getSession().getId(), sesion);
//		sc.setAttribute("SessionsMap", mapSes); no hace falta porque al actualizar el mapa ya se guardan los valores a�adidos
		log.info("Estamos en sessionCreated y la sesi�n tiene el id " + idSesi�n);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
		HttpSession sesion = arg0.getSession();
		String idSesi�n = arg0.getSession().getId();
		ServletContext sc = arg0.getSession().getServletContext();
		HashMap<String, HttpSession> mapSes = (HashMap<String, HttpSession>) sc.getAttribute("SessionsMap");
		mapSes.remove(idSesi�n);
		log.info("Estamos en sessionDestroyed y la sesi�n " + idSesi�n + " ha sido borrarda del mapa");
		
	}

}
