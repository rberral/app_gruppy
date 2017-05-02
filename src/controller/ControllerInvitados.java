package controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PersonaService;
import util.Constantes;
import util.Utilidades;

/**
 * Servlet implementation class ControllerInvitados
 */
public class ControllerInvitados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public RequestDispatcher dispatcher = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerInvitados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Ejecucion cuando se llama a servlet desde url
		//System.out.println("doGetControllerSocios");
		//response.sendRedirect(Constantes.URI_SOCIOS);
		dispatcher = request.getRequestDispatcher(Constantes.URI_INVITADOS);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Ejecucion de servlet desde formularios
		//sentencia para forzar ejecución de metodo get
		//doGet(request, response);
		PersonaService servicioP = new PersonaService();
		boolean tx = false;
		// vamos a extraer la operacion
		String oper = null;
		String email = null;
		boolean fundador = false;
		Date f_alta = null;
		boolean activo = false;
		String params = request.getParameter("params");

		
		Map<String, String> mapa = new HashMap<String, String>();
		mapa = Utilidades.getMapa(params);
		email = mapa.get(Constantes.FORM_JS_EMAIL);
		f_alta = Utilidades.getFechaToBBDD(mapa.get(Constantes.FORM_JS_FECHA_ALTA));
		oper = mapa.get(Constantes.FORM_JS_OPER);
		if(oper.compareTo(Constantes.FORM_JS_OPER_UPDATE)==0){
			fundador = Utilidades.getValueBooleanSelectToBBDD(mapa.get(Constantes.FORM_JS_FUNDADOR));			
			tx=servicioP.updatePersonaSocio(email,fundador,f_alta, activo);
		}
//		else if(oper.compareTo(Constantes.FORM_JS_OPER_DELETE)==0){
//			//No es necesario recoger valor de activo, ya que sabemos el tipo de operacion -> Delete
//			tx=servicioP.updatePersonaActivo(email, false);
//		}
		if(tx){
			request.setAttribute(Constantes.RESPUESTA_ACCION, Constantes.RESPUESTA_OK_VALUE);
		}
		else{
			request.setAttribute(Constantes.RESPUESTA_ACCION, Constantes.RESPUESTA_ERROR_VALUE);

		}
		
		dispatcher = request.getRequestDispatcher(Constantes.URI_SOCIOS);  
		if (dispatcher != null){  
		  dispatcher.forward(request, response); 
		}	
	}

}