package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import bean.Invitado;
import bean.Persona;

public class InvitadoDAO {
	private boolean dev;
	private static final Logger logger = Logger.getLogger(InvitadoDAO.class
			.getName());

	private static final long serialVersionUID = 1L;
	public boolean addInvitado(Invitado i){
		dev = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(i);
			// Commit the transaction
			session.getTransaction().commit();
			logger.info("Invitado " + i.getNombreInvitado() + " saved successfully.");
			dev = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.close();
		return dev;
	}
	public boolean removeInvitado(Invitado i){
		dev = false;
		// TODO Auto-generated method stub4
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.delete(i);
			session.getTransaction().commit();
			logger.info("Invitado " + i.getNombreInvitado() + " removed successfully.");
			dev = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return dev;
	
	}
	public boolean updateInvitado(Invitado i){
		boolean dev = false;
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.update(i);
			session.getTransaction().commit();
			logger.info("Invitado " + i.getNombreInvitado() + " updated successfully.");
			dev = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return dev;
	}
	public List<Invitado> listInvitados(){
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		//List<Persona> list = session.createCriteria(Persona.class).list();
		//List<Persona> personaList = session.createQuery("from Persona").list();
		Criteria criteria =  session.createCriteria(Invitado.class);
				//.add(Restrictions.eq("activo", true));
		List<Invitado> invitadoList = criteria.list();
		session.close();
		return invitadoList;
	}
	public List<Invitado> listInvitados(Persona p){
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		//List<Persona> list = session.createCriteria(Persona.class).list();
		//List<Persona> personaList = session.createQuery("from Persona").list();
		Criteria criteria =  session.createCriteria(Invitado.class)
				.add(Restrictions.eq("emailPersona", p.getEmail()));
		List<Invitado> invitadoList = criteria.list();
		session.close();
		return invitadoList;	
	}
	public Invitado getInvitado(int id){
		Invitado i = new Invitado();
		Session session = HibernateUtil.getSessionFactory().openSession();
		//List<Persona> list = session.createCriteria(Persona.class).list();
		//List<Persona> personaList = session.createQuery("from Persona where email="+p.getEmail() " and").list();
		Criteria criteria = session.createCriteria(Persona.class)
				.add(Restrictions.eq("idInvitado", id));
		i = (Invitado)criteria.uniqueResult();
		session.close();	
		return i;
	}
}
