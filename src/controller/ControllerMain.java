package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Asociacion;
import bean.Persona;
import service.AsociacionService;
import service.PersonaService;
import util.Constantes;
import util.MaestroDatos;

/**
 * Servlet implementation class ControllerMain
 */
public class ControllerMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonaService servicioP = new PersonaService();


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerMain() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String oper = request.getParameter("oper");
		String url = request.getParameter("url");
		RequestDispatcher dispatcher = null;
		boolean check = false;
		switch (oper) {
		case "logout": // elimnamos session y volvemos a index.
			/*
			HttpSession session = request.getSession(false);
			request.removeAttribute("user");
			session.invalidate();
			*/
			servicioP.deleteSessionUser(request);
			check = false;
			break;

		case "redirect": // comprobamos login y redireccionamos en caso de OK
			check = servicioP.checkLogin(request);
			if (check){
			dispatcher = request.getRequestDispatcher("/"+ url + ".jsp");
			}
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			}
		}
		// En caso de error, volvemos a index
		if (!check) {
			dispatcher = request.getRequestDispatcher("/index.jsp");
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
			
			// en caso erroneo, redireccionamos a index
			/* dispatcher = request.getRequestDispatcher("/pages/index.jsp");
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			}*/
		} else {
			// login correcto
			//inicializamos variables globales
			//inicializaVariables(request);
			dispatcher = request.getRequestDispatcher("/main.jsp");
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			}
		}

	}
	
	public void inicializaVariables(HttpServletRequest request){
		/*ServletContext ss = request.getSession().getServletContext();
		String ruta = request.getRequestDispatcher("main.jsp").toString();
		String file = ss.getRealPath(Constantes.URLMaestroRolXML);
		System.out.println("uni:"+file);
		Map<Integer,String> mapaRoles = MaestroDatos.getRolesUsuario(Constantes.URLMaestroRolXML);
		request.setAttribute("mapaRol", mapaRoles);*/
	}
}
