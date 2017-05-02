package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AsociacionService;
import util.Constantes;
import util.Utilidades;
import bean.Asociacion;

/**
 * Servlet implementation class ControllerAsociacion
 */
public class ControllerAsociacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AsociacionService asociacionS = new AsociacionService();
	private RequestDispatcher dispatcher = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAsociacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Asociacion a = asociacionS.getAsociacion();
		request.setAttribute("asociacion", a);
		dispatcher = request.getRequestDispatcher(Constantes.URI_INFO_ASOC);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Date f_fundacion = null;
		String name_asoc = request.getParameter("name_asoc");
		String desc_asoc = request.getParameter("descripcion_asoc");
		String direccion_asoc = request.getParameter("direccion_asoc");
		String email_asoc = request.getParameter("email_asoc");
		int telefono_asoc = Integer.parseInt(request.getParameter("telefono_asoc"));
		String fecha_asoc = request.getParameter("fecha_fundacion_asoc");
		f_fundacion = Utilidades.getFechaToBBDD(fecha_asoc);
		//Recuperamos Asociacion Actual
		Asociacion asoc_old = asociacionS.getAsociacion();
		Asociacion a = new Asociacion(name_asoc, desc_asoc, direccion_asoc, email_asoc, telefono_asoc, f_fundacion);
		a.setIdAsociacion(asoc_old.getIdAsociacion());
		
		boolean tx = false;
		tx = asociacionS.updateAsociacion(a);

		if(tx){
			request.setAttribute("asociacion", a);
			request.setAttribute(Constantes.RESPUESTA_ACCION, Constantes.RESPUESTA_OK_VALUE);
		}
		else{
			request.setAttribute("asociacion", asoc_old);
			request.setAttribute(Constantes.RESPUESTA_ACCION, Constantes.RESPUESTA_ERROR_VALUE);

		}
		
		request.setAttribute("asociacion", a);
		dispatcher = request.getRequestDispatcher(Constantes.URI_INFO_ASOC);  
		if (dispatcher != null){  
		  dispatcher.forward(request, response); 
		}
	}

}
