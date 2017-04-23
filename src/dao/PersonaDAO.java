package dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Logger;










import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import bean.Persona;
import util.HibernateUtil;

public class PersonaDAO {

	private boolean dev;
	private static final Logger logger = Logger.getLogger(PersonaDAO.class
			.getName());

	private static final long serialVersionUID = 1L;

	public boolean addPersona(Persona p) {
		dev = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(p);
			// Commit the transaction
			session.getTransaction().commit();
			logger.info("Person " + p.getEmail() + " saved successfully.");
			dev = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.close();
		return dev;
	}

	public boolean removePersona(Persona p) {
		dev = false;
		// TODO Auto-generated method stub4
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.delete(p);
			session.getTransaction().commit();
			logger.info("Person " + p.getEmail() + " removed successfully.");
			dev = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return dev;

	}

	public boolean updatePersona(Persona p) {
		boolean dev = false;
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.update(p);
			session.getTransaction().commit();
			logger.info("Person " + p.getEmail() + " updated successfully.");
			dev = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return dev;
	}
	//Actualiza datos Persona en Perfil
	public boolean updateProfilePerson(Persona p, Persona pOld){
		boolean dev = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		/*String hqlUpdate = "UPDATE persona as p set " +
				"p.nombre = :newNombre," +
				"p.apellidos = :newApellidos " +
				"p.email = :newEmail " +
				"p.fechaNacimiento = :newFechaNacimiento " +
				"p.telefono = :newTelefono " +
				"p.pass = :newPass " +
				"where p.email = :oldEmail";
		try {
			// or String hqlUpdate = "update Customer set name = :newName where name = :oldName";
			int updatedEntities = session.createQuery( hqlUpdate )
			        .setString( "newNombre", p.getNombre())
			        .setString( "newApellidos", p.getApellidos())
			        .setString( "newEmail", p.getEmail())
			        .setDate( "newFechaNacimiento", p.getFechaNacimiento())
			        .setInteger( "newTelefono", p.getTelefono())
			        .setString( "newPass", p.getPass())
			        .setString( "oldEMail", pOld.getEmail() )
			        .executeUpdate();
			session.getTransaction().commit();	
		}catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return dev;*/
		
		//Persona aux = (Persona)session.get(Persona.class,pOld.getEmail());
		if(!(pOld==null)){
		 //aux.setIdPersona(p.getIdPersona());
			pOld.setNombre(p.getNombre());
			pOld.setApellidos(p.getApellidos());
			pOld.setEmail(p.getEmail());
			pOld.setFechaNacimiento(p.getFechaNacimiento());
		 pOld.setTelefono(p.getTelefono());
		 pOld.setPass(p.getPass());
		 pOld.setFechaAlta(p.getFechaAlta());
		 //aux.setFechaBaja(p.getFechaBaja());
		// Above line is just an example, set whatever you want to, ideally this should be done in Service layer, but okay for now
		    session.merge(pOld);
		    session.flush();
		    session.close();
		    dev = true;
		}
		return dev;
	}
	
	//Actualiza datos Persona -> Pestaña Socios
	public boolean updatePersonaSocio(String email, Boolean fundador, Date f_alta, boolean activo){
		boolean dev = false;
		
		Persona p = this.getPersona(email);
		//Persona p = (Persona)session.get(Persona.class,email);
		if(!(p==null)){
		 p.setFundador(fundador);
		 p.setFechaAlta(f_alta);
		 p.setActivo(activo);
		 // Si se marca como baja, actualizamos fecha de baja
		 if(!activo){
			 p.setFechaBaja(new Date());
		 }
		 else{
			 Calendar calendar = Calendar.getInstance();
			 calendar.set(9999, 11, 31); //11 = Diciembre
			 p.setFechaBaja(calendar.getTime());
		 }
		 dev = this.updatePersona(p);
		}
		return dev;
		/*
		Session session = HibernateUtil.getSessionFactory().openSession();

		Persona p = this.getPersona(email);
		//Persona p = (Persona)session.get(Persona.class,email);
		if(!(p==null)){
		 p.setFundador(fundador);
		 p.setFechaAlta(f_alta);
		 p.setActivo(activo);
		 // Si se marca como baja, actualizamos fecha de baja
		 if(!activo){
			 p.setFechaBaja(new Date());
		 }
		 else{
			 p.setFechaBaja(new Date(9999,12,31));
		 }
		// Above line is just an example, set whatever you want to, ideally this should be done in Service layer, but okay for now
		    session.merge(p);
		    session.flush();
		    session.close();
		    dev = true;
		}
		return dev;*/
	}
	
//	//Actualiza datos Persona (activo) -> Pestaña Socios
//	public boolean updatePersonaActivo(String email, boolean activo){
//		boolean dev = false;
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Persona p = (Persona)session.get(Persona.class,email);
//		if(!(p==null)){
//		 p.setActivo(activo);
//		 // Si se marca como baja, actualizamos fecha de baja
//		 if(!activo){
//			 p.setFechaBaja(new Date());
//		 }
//		// Above line is just an example, set whatever you want to, ideally this should be done in Service layer, but okay for now
//		    session.merge(p);
//		    session.flush();
//		    session.close();
//		    dev = true;
//		}
//		return dev;
//	}
//	
	
	public List<Persona> listPersonas() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		//List<Persona> list = session.createCriteria(Persona.class).list();
		//List<Persona> personaList = session.createQuery("from Persona").list();
		Criteria criteria =  session.createCriteria(Persona.class);
				//.add(Restrictions.eq("activo", true));
		List<Persona> personaList = criteria.list();
		session.close();
		return personaList;
	}
	
	public Persona getPersona(String email, String pass){
		Persona p = new Persona();
		Session session = HibernateUtil.getSessionFactory().openSession();
		//List<Persona> list = session.createCriteria(Persona.class).list();
		//List<Persona> personaList = session.createQuery("from Persona where email="+p.getEmail() " and").list();
		Criteria criteria = session.createCriteria(Persona.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("pass", pass));
		p = (Persona)criteria.uniqueResult();
		session.close();
		//return (Persona)criteria.list().get(0);
		return p;
	}
	
	public Persona getPersona(String email){
		Persona p = new Persona();
		Session session = HibernateUtil.getSessionFactory().openSession();
		//List<Persona> list = session.createCriteria(Persona.class).list();
		//List<Persona> personaList = session.createQuery("from Persona where email="+p.getEmail() " and").list();
		Criteria criteria = session.createCriteria(Persona.class)
				.add(Restrictions.eq("email", email));
		p = (Persona)criteria.uniqueResult();
		session.close();
		//return (Persona)criteria.list().get(0);
		return p;
	}
	
	public Persona getPersona(int id_persona){
		Persona p = new Persona();
		Session session = HibernateUtil.getSessionFactory().openSession();
		//List<Persona> list = session.createCriteria(Persona.class).list();
		//List<Persona> personaList = session.createQuery("from Persona where email="+p.getEmail() " and").list();
		Criteria criteria = session.createCriteria(Persona.class)
				.add(Restrictions.eq("idPersona", id_persona));
		p = (Persona)criteria.uniqueResult();
		session.close();
		//return (Persona)criteria.list().get(0);
		return p;
	}
}