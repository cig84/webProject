package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ClasificaSerieA
 */
public class ClasificaSerieA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClasificaSerieA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out = response.getWriter();
		URL url = new URL("http://www.romanews.eu");
		String codigoHTML = "";
		String codigoHTMLentero = "";
		try{
			InputStreamReader in = new InputStreamReader(url.openStream());
			BufferedReader br = new BufferedReader(in);
			
			
			String inicio = ("widget widget_league_table widget_sp_league_table");
			String finale = ("</td></tr></tbody></table></div></div></div>");
			String contenido = "";
 
			while((codigoHTML = br.readLine())!=null){
				codigoHTMLentero = codigoHTMLentero+codigoHTML+"\n";
//				System.out.println(codigoHTML);
//				out.println(codigoHTML);
			}
			
			int ini = codigoHTMLentero.indexOf(inicio);
			int fin = codigoHTMLentero.indexOf(finale);
			
			contenido = codigoHTMLentero.substring(ini-46, fin+44);
//			inicio = ("<a href=\"#1\">");
//			finale = ("</a>");
//			ini = contenido.indexOf(inicio);
//			fin = contenido.indexOf(finale);
//			
//			String img = contenido.substring(ini, fin+4);
////			System.out.println(img);
//			contenido = contenido.replace(img, "");
			out.println(contenido);
 
			br.close();
			}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
