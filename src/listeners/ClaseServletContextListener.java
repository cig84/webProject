package listeners;

import java.util.HashMap;
import java.util.Map;

import hibernate.clasesDAO.SessionManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

public class ClaseServletContextListener implements ServletContextListener{
	
	private static final Logger log = LogManager.getRootLogger();

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		ServletContext sc = sce.getServletContext();
		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
		log.info("Estamos en contextDestroyed");
		try{
			sf.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		log.info("La Session Factory está cerrada");		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext sc = sce.getServletContext();
		SessionFactory sf = SessionManager.getSessionFactory();
		Map<String, HttpSession> sesMap = new HashMap<String, HttpSession>();
		sc.setAttribute("SessionsMap", sesMap);
		sc.setAttribute("sf", sf);
		log.info("Estamos en contextInitialized y hemos guardado el mapa vacio en el contexto");
		
	}

}
