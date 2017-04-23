package service;

import java.util.Date;
import java.util.List;
//import java.util.logging.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import bean.Persona;
import service.PersonaService;
import util.Constantes;
import dao.PersonaDAO;

public class PersonaService implements IPersonaService {

	private static final Logger logger = Logger.getLogger(PersonaService.class);

	private static final long serialVersionUID = 1L;
	private PersonaDAO dao = new PersonaDAO();

	@Override
	public boolean addPersona(Persona p) {
		/*
		 * Session session = HibernateUtil.getSessionFactory().openSession();
		 * session.beginTransaction(); session.save(p); //Commit the transaction
		 * session.getTransaction().commit(); session.close();
		 * logger.info("Person saved successfully, Person Details=" +
		 * p.getEmail()); return true;
		 */
		return dao.addPersona(p);
	}

	@Override
	public boolean removePersona(Persona p) {
		// TODO Auto-generated method stub4
		/*
		 * Session session = HibernateUtil.getSessionFactory().openSession();
		 * 
		 * try { session.beginTransaction(); session.delete(p);
		 * session.getTransaction().commit(); } catch (HibernateException e) {
		 * e.printStackTrace(); session.getTransaction().rollback(); }
		 * session.close(); return true;
		 */
		return dao.removePersona(p);

	}

	@Override
	public boolean updatePersona(Persona p) {
		// TODO Auto-generated method stub
		/*
		 * Session session = HibernateUtil.getSessionFactory().openSession();
		 * 
		 * try { session.beginTransaction(); session.update(p);
		 * session.getTransaction().commit(); } catch (HibernateException e) {
		 * e.printStackTrace(); session.getTransaction().rollback(); }
		 * session.close();
		 */
		return dao.updatePersona(p);
	}

	public boolean updatePersonaProfile(Persona p, Persona pOld){
		return dao.updateProfilePerson(p,pOld);
	}
	
	//Actualiza datos Persona -> Pestaña Socios
	public boolean updatePersonaSocio(String email, boolean fundador, Date f_alta, boolean activo){
		return dao.updatePersonaSocio(email,fundador, f_alta, activo);
	}
	
	//Se controla en update
//	public boolean updatePersonaActivo(String email, boolean activo){
//		return dao.updatePersonaActivo(email,activo);
//	}
	
	@Override
	public List<Persona> listPersonas() {
		// TODO Auto-generated method stub
		/*
		 * Session session = HibernateUtil.getSessionFactory().openSession();
		 * //List<Products> list =
		 * session.createCriteria(Products.class).list(); List<Persona>
		 * personaList = session.createQuery("from Persona").list();
		 * session.close(); return personaList;
		 */
		logger.info("Invocacion Servicio listado de personas...");
		return dao.listPersonas();
	}

	public boolean loginUser(HttpServletRequest request, String email,
			String pass) {
		boolean enc = false;
		Persona p = dao.getPersona(email, pass);
		if (p != null) {
			enc = true;
			HttpSession session = request.getSession(true);
			session.setAttribute(Constantes.sessionUsuario, p);
		}
		return enc;
	}

	public void updateSessionUser(HttpServletRequest request, Persona p) {
		HttpSession session = request.getSession(true);
		session.setAttribute(Constantes.sessionUsuario, p);
	}

	public void deleteSessionUser(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		request.removeAttribute(Constantes.sessionUsuario);
		session.invalidate();
	}

	public boolean checkLogin(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean checkAuthUpdateDeleteSocios(int rol){
		boolean dev = false;
		for(int i=0;i<Constantes.AUTH_UPDATE_DELETE_SOCIOS.length;i++){
			if(rol == Constantes.AUTH_UPDATE_DELETE_SOCIOS[i]){
				dev = true;
				break;
			}
		}
		return dev;
	}
}
