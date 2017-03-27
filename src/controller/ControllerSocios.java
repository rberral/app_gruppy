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
 * Servlet implementation class ControllerSocios
 */
public class ControllerSocios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerSocios() {
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
		//sentencia para forzar ejecución de metodo get
		//doGet(request, response);
		PersonaService servicioP = new PersonaService();
		boolean tx = false;
		// vamos a extraer la operacion
		String oper = null;
		String email = null;
		boolean fundador = false;
		String params = request.getParameter("params");
		String[] paramsSplit = params.split("&");
		String operParam = paramsSplit[0];
		String[] operSplit = operParam.split("=");
		oper = operSplit[1];
		String emailParam = paramsSplit[1];
		String[] emailSplit = emailParam.split("=");
		email = emailSplit[1];

		
		if(oper.compareTo("update")==0){
			String fundadorParam = paramsSplit[2];
			String[] fundadorSplit = fundadorParam.split("="); 
			fundador = Boolean.parseBoolean(fundadorSplit[1]);				
			tx=servicioP.updatePersonaFundador(email,fundador);
		}
		else if(oper.compareTo("delete")==0){
			tx=servicioP.updatePersonaActivo(email, false);
			}
		if(tx){
			request.setAttribute(Constantes.RESPUESTA_ACCION, Constantes.RESPUESTA_OK_VALUE);
		}
		else{
			request.setAttribute(Constantes.RESPUESTA_ACCION, Constantes.RESPUESTA_ERROR_VALUE);

		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/socios.jsp");  
		if (dispatcher != null){  
		  dispatcher.forward(request, response); 
		}	
	}

}
