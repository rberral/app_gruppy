package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DesgloseCuentasDAO;
import service.DesgloseService;
import util.Constantes;
import util.Utilidades;
import bean.Asociacion;
import bean.DesgloseCuentas;
import bean.DesgloseCuentasAdicional;
import bean.Persona;

/**
 * Servlet implementation class ControllerDesglose
 */
public class ControllerDesglose extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher = null;
	private DesgloseService desgloseS = new DesgloseService();
	private List<DesgloseCuentas> listaDesgloseCuotas;
	private List<DesgloseCuentasAdicional> listaDesgloseAdicional;
	private int loadList;
	private int size_cuotas_invitados;
	private int size_cuotas_otros;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDesglose() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		loadList = 0;
		size_cuotas_invitados = 0;
		size_cuotas_otros = 0;

		prepare_desglose(request);

		prepare_values_request(request);
		dispatcher = request.getRequestDispatcher(Constantes.URI_DESGLOSE);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		prepare_desglose(request);
		prepare_values_request(request);
		dispatcher = request.getRequestDispatcher(Constantes.URI_DESGLOSE);  
		if (dispatcher != null){  
		  dispatcher.forward(request, response); 
		}
	}
	
	protected void prepare_desglose(HttpServletRequest request) throws ServletException, IOException{
		//chequeamos rol de persona
		size_cuotas_invitados = 0;
		size_cuotas_otros = 0;
		Persona p = (Persona) request.getSession().getAttribute(Constantes.sessionUsuario);
		if(p.getIdRol()==Constantes.ROLE_TESORERO){
			prepare_desglose_admin();
		}
		else{
		prepare_desglose_user(p);
		}
		for(int i=0; i<listaDesgloseAdicional.size();i++){
			switch(listaDesgloseAdicional.get(i).getTipoCuota()){
			case Constantes.TIPO_CUOTA_INVITADOS: size_cuotas_invitados++;  break;
			case Constantes.TIPO_CUOTA_OTROS: size_cuotas_otros++; break;
			}
		}
	}
	protected void prepare_desglose_admin(){
		listaDesgloseCuotas = desgloseS.listDesgloseCuotas(0);
		listaDesgloseAdicional = desgloseS.listDesgloseAdicional(0);		
	}
	
	protected void prepare_desglose_user(Persona p){
		listaDesgloseCuotas = desgloseS.listDesgloseCuotas(0,p);
		listaDesgloseAdicional = desgloseS.listDesgloseAdicional(0,p);	
	}
	
	protected void prepare_values_request(HttpServletRequest request) throws ServletException, IOException{
		String option = request.getParameter("option");
		if(option == null || option.isEmpty()){
			loadList = Constantes.TIPO_CUOTA_MENSUAL;
		}else{
			loadList = Integer.parseInt(option);
		}
		request.setAttribute("listadesgloseCuentas",listaDesgloseCuotas);
		request.setAttribute("listaDesgloseAdicional",listaDesgloseAdicional);
		request.setAttribute("sizeInvitados",size_cuotas_invitados);
		request.setAttribute("sizeOtros",size_cuotas_otros);
		request.setAttribute("loadList", loadList);
	}

}
