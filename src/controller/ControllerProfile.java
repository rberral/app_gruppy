package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ParseConversionEvent;

import bean.Persona;
import service.PersonaService;
import util.Constantes;
import util.Utilidades;

/**
 * Servlet implementation class ControllerProfile
 */
public class ControllerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaService servicioP = new PersonaService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//recogemos valores form
		boolean tx = false;
		Date f_nac = null;	
		String first_name = request.getParameter("first_name");
		String second_name = request.getParameter("second_name");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		String fecha_form = request.getParameter("fecha_nac");
		f_nac = Utilidades.getFechaToBBDD(fecha_form);
		int phone = Integer.parseInt(request.getParameter("phone"));
		//realizamos de nuevo validaciones
		//recuperamos de la session el email anterior
		Persona personaSession = (Persona) request.getSession().getAttribute(Constantes.sessionUsuario) ;
		Persona p  = new Persona(email,pass,first_name,second_name,phone,f_nac, phone);
		tx = servicioP.updatePersonaProfile(p, personaSession);
		
		if(tx){
			//actualizamos valores sesion
			servicioP.updateSessionUser(request, p);
			request.setAttribute(Constantes.RESPUESTA_ACCION, Constantes.RESPUESTA_OK_VALUE);
		}
		else{
			request.setAttribute(Constantes.RESPUESTA_ACCION, Constantes.RESPUESTA_ERROR_VALUE);

		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mi_perfil.jsp");  
		if (dispatcher != null){  
		  dispatcher.forward(request, response); 
		}	
	}
}
