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

import bean.Asociacion;
import bean.Persona;
import service.AsociacionService;
import service.PersonaService;
import util.Constantes;
import util.Utilidades;

/**
 * Servlet implementation class ControllerProfile
 */
public class ControllerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaService servicioP = new PersonaService();
	private RequestDispatcher dispatcher = null;

       
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
		//response.sendRedirect(Constantes.URI_MI_PERFIL);
		AsociacionService servicioA = new AsociacionService();
		Asociacion a = servicioA.getAsociacion();
		request.setAttribute("asociacion", a);
		dispatcher = request.getRequestDispatcher(Constantes.URI_MI_PERFIL);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//recogemos valores form
		boolean tx = false;
		Date f_nac = null;	
		Persona p = null;
		String first_name = request.getParameter("first_name");
		String second_name = request.getParameter("second_name");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		String fecha_form = request.getParameter("fecha_nac");
		int phone = Integer.parseInt(request.getParameter("phone"));
		f_nac = Utilidades.getFechaToBBDD(fecha_form);
		
		//recuperamos de la session el email anterior
		Persona personaSession = (Persona) request.getSession().getAttribute(Constantes.sessionUsuario) ;
		p  = new Persona(email,pass,first_name,second_name,phone,f_nac, personaSession.getIdRol(), personaSession.isFundador(),personaSession.isActivo(), personaSession.getFechaAlta(), personaSession.getFechaBaja());
		//VALIDACIONES
		tx = Utilidades.validacionesPerfil(p);
		
		if(tx){
			//recuperamos de la session el email anterior
			tx = false;
			tx = servicioP.updatePersonaProfile(p, personaSession);	
		}

		if(tx){
			//actualizamos valores sesion
			servicioP.updateSessionUser(request, p);
			request.setAttribute(Constantes.RESPUESTA_ACCION, Constantes.RESPUESTA_OK_VALUE);
		}
		else{
			request.setAttribute(Constantes.RESPUESTA_ACCION, Constantes.RESPUESTA_ERROR_VALUE);

		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(Constantes.URI_MI_PERFIL);  
		if (dispatcher != null){  
		  dispatcher.forward(request, response); 
		}	
	}
}
