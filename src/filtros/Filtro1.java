package filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Filtro1 implements Filter{
	
	private static final Logger log = LogManager.getRootLogger();

	@Override
	public void destroy() {
		log.info("Estamos en destroy de la clase Filtro1");
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		log.info("Estamos en doFilter de la clase Filtro1");
		
		ServletContext sc = arg0.getServletContext();
//		int accesos = (int) sc.getAttribute("accesos") + 1;
//		String acc = Integer.toString(accesos);
//		sc.setAttribute("accesos", accesos);
//		System.out.println("El numero de accesos hasta ahora es " + accesos);
		long start = System.currentTimeMillis();
		arg2.doFilter(arg0, arg1);
		long finish = System.currentTimeMillis();
		long time = finish - start;
		System.out.println("El servlet Hibernate tarda " + time + " milisegundos");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("Estamos en init de la clase Filtro1");
		
	}

}
