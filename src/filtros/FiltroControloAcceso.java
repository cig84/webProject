package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet Filter implementation class FiltroControlAcceso
 */

public class FiltroControloAcceso implements Filter {
	private static final Logger log = LogManager.getRootLogger();

	
    /**
     * Default constructor. 
     */
    public FiltroControloAcceso() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest servReq = (HttpServletRequest) request;
		HttpServletResponse servResp = (HttpServletResponse) response;
		String uri = servReq.getRequestURI();
		HttpSession ses = servReq.getSession(false);
//		if(ses != null && uri.contentEquals(url)){
//			servResp.sendRedirect(url);
//		}
//		else 
			if (ses != null){
			chain.doFilter(request, response);
		}
		else if(uri.contentEquals("/WebProject/ServletAutenticacion") || uri.contentEquals("/WebProject/")){
			chain.doFilter(request, response);
			ServletContext sc = servReq.getServletContext();
			sc.setAttribute("uri", uri);
			log.info(sc.getAttribute("uri"));
		}
		else {
			ServletContext sc = servReq.getServletContext();
			sc.setAttribute("uri", uri);
			log.info(sc.getAttribute("uri"));
			servResp.sendRedirect("/WebProject/");
			
		}
		
		}
		

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
