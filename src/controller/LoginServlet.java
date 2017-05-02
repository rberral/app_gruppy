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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonaService servicioP = new PersonaService();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("dogetServletLogin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = null;

		// Recogemos variables form jsp
		String email = request.getParameter("userName");
		String pass = request.getParameter("userPassword");

		//PersonaService servicioP = new PersonaService();

		//comprobamos objeto sesion
		if (servicioP.checkLogin(request)) {
			servicioP.deleteSessionUser(request);
		}
		// hacemos login sobre bbdd
		if (!servicioP.loginUser(request, email, pass)) {
			//	ERROR AL LOGUEARSE
			//response.sendRedirect(Constantes.URI_INDEX);
			// CARGAR MENSAJE DE ERROR
		} else {
			// login correcto
			//inicializamos variables globales
			//inicializaVariables(request);
			dispatcher = request.getRequestDispatcher(Constantes.URI_MAIN);
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			}
		}
	}

}
