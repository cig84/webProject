package listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class ClaseServletRequestListener implements ServletRequestListener{
	
	private static final Logger log = LogManager.getRootLogger();

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		log.info("Estamos en requestDestroyed");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		log.info("Estamos en requestInitialized");
		
	}

}
