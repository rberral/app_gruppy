package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Persona;
import bean.TablonAnuncios;
import service.PersonaService;
import service.TablonService;
import util.Constantes;
import util.Utilidades;

/**
 * Servlet implementation class ControllerTablon
 */
public class ControllerTablon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher = null;
	private TablonService servicioT = new TablonService();


       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerTablon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dispatcher = request.getRequestDispatcher(Constantes.URI_TABLON);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean tx = false;
		String asunto = request.getParameter("asunto");
		String descripcion = request.getParameter("descripcion");
		//recuperamos de la session el email anterior
		Persona personaSession = (Persona) request.getSession().getAttribute(Constantes.sessionUsuario) ;
		TablonAnuncios t = new TablonAnuncios(personaSession.getEmail(), asunto, descripcion, new Date(), Utilidades.getFechaFin());
		
		tx = servicioT.addAnuncio(t);
		
		if(tx){
			request.setAttribute(Constantes.RESPUESTA_ACCION, Constantes.RESPUESTA_OK_VALUE);
		}
		else{
			request.setAttribute(Constantes.RESPUESTA_ACCION, Constantes.RESPUESTA_ERROR_VALUE);

		}
		
		dispatcher = request.getRequestDispatcher(Constantes.URI_TABLON);  
		if (dispatcher != null){  
		  dispatcher.forward(request, response); 
		}	

	}

}
