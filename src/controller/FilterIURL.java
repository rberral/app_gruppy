package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.PersonaService;
import util.Constantes;

/**
 * Servlet Filter implementation class FilterIURL
 */
public class FilterIURL implements Filter {

	PersonaService servicioP = new PersonaService();
	RequestDispatcher dispatcher = null;

    /**
     * Default constructor. 
     */
    public FilterIURL() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		boolean check = false;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		
		check = servicioP.checkLogin(req);
		
		//if(!check && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))){
		if(check){
			chain.doFilter(request, response);
		}
		else {
			res.sendRedirect("index.jsp");
		}
			/*
			if(uri.endsWith("LoginServlet") || uri.endsWith("index.jsp")|| uri.endsWith("/app_gruppy/")){
		//this.context.log("Unauthorized access request");
				 //LoginServlet ob=new LoginServlet();
			      //  ob.doPost(req, res);
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
*/
				
		
		 // Con esto aseguramos que los parámetros de entrada tengan sus tipos correctos      
		/*HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		//String uri = req.getContextPath();
		String uri = req.getServletPath();
		 // Aquí se realizarían las acciones PRE filtro (opcionalmente invocamos a otros filtros encadenados)
		System.out.println("acciones pre filtro sobre url: "+uri);
		String oper = request.getParameter("oper");
		String url = request.getParameter("url");
		boolean check = false;
		/*Enumeration<String> params = req.getParameterNames();
		while(params.hasMoreElements()){
			String name = params.nextElement();
			String value = request.getParameter(name);
		}*/
		// CONTROL DE PERMISO PARA ACCEDER A ESTA URL //
		/*
		switch(uri){
		case Constantes.URI_MAIN:
			check = servicioP.checkLogin(req);
			break;
		case Constantes.URI_INFO_ASOC:
			check = servicioP.checkLogin(req);
		break;
		case Constantes.URI_MI_PERFIL:
			check = servicioP.checkLogin(req);
		break;
		case Constantes.URI_INDEX:
			//chequeamos si se trata de login, logout o redireccion
			if(oper == null){
				//redireccion
			}
			else if(oper.compareTo(Constantes.URI_OPER_LOGOUT)==0){
				servicioP.deleteSessionUser(req);
			}
			else if(oper.compareTo(Constantes.URI_OPER_LOGIN)==0){
				// Recogemos variables form jsp
				String email = request.getParameter("userName");
				String pass = request.getParameter("userPassword");				
				//comprobamos objeto sesion
				if (servicioP.checkLogin(req)) {
					servicioP.deleteSessionUser(req);
				}
				// hacemos login sobre bbdd
				if (servicioP.loginUser(req, email, pass)) {
					// login correcto
					//inicializamos variables globales
					//inicializaVariables(request);
					check = true;
				}
			}


			break;

		}

		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		// Y aquí se realizarían las acciones POST filtro
		System.out.println("acciones post filtro sobre uri: "+uri);
		
		// En caso de error, volvemos a index
		if (!check) {
			dispatcher = request.getRequestDispatcher("/index.jsp");
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			}
		}
		else {
			dispatcher = request.getRequestDispatcher("/"+ url + ".jsp");
		}
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
					*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
}
