package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerURL
 */
public class ControllerURL_OBSOLETO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerURL_OBSOLETO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//controlamos URL invocada de forma manual (seguridad)
		String url_invoked = request.getRequestURI();
		//StringBuffer ur2 = request.getRequestURL();
		//String oo = request.getContextPath();
		String[] splitURL = url_invoked.split("/pages/");
		//response.sendRedirect(url_invoked);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/pages/"+ splitURL[1]);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest requ5est, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url_invoked = request.getRequestURI();
		//StringBuffer ur2 = request.getRequestURL();
		//String oo = request.getContextPath();
		String[] splitURL = url_invoked.split("/pages/");
		//response.sendRedirect(url_invoked);
		/*RequestDispatcher dispatcher = request
				.getRequestDispatcher("/pages/"+ splitURL[1]);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}*/
		if(splitURL[1].compareTo("main.jsp")==0){
		ControllerMain_OBSOLETO ob = new ControllerMain_OBSOLETO();
        ob.doPost(request, response);
		}
	}

}
