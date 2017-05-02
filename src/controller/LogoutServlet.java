package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PersonaService;
import util.Constantes;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaService servicioP = new PersonaService();
	private RequestDispatcher dispatcher = null;


       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		servicioP.deleteSessionUser(request);
		dispatcher = request.getRequestDispatcher(Constantes.URI_INDEX);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		servicioP.deleteSessionUser(request);
		dispatcher = request.getRequestDispatcher(Constantes.URI_INDEX);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}		
	}

}
