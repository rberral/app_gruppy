package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FilterIURL
 */
public class FilterIURL implements Filter {

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
		 // Con esto aseguramos que los parámetros de entrada tengan sus tipos correctos      
		 HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		//String uri = req.getContextPath();
		String uri = req.getServletPath();
		//StringBuffer uri3 = req.getRequestURL();
		//String uri4 =req.getRequestURI();
		 // Aquí se realizarían las acciones PRE filtro (opcionalmente invocamos a otros filtros encadenados)
		System.out.println("acciones pre filtro sobre url: "+uri);
		// pass the request along the filter chain
		chain.doFilter(request, response);
		// Y aquí se realizarían las acciones POST filtro
		System.out.println("acciones post filtro sobre uri: "+uri);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
