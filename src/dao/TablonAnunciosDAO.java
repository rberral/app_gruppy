package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import bean.Asociacion;
import bean.Persona;
import bean.TablonAnuncios;

public class TablonAnunciosDAO {
	private boolean dev;
	private static final Logger logger = Logger.getLogger(TablonAnunciosDAO.class.getName());

	public boolean addAnuncio(TablonAnuncios t) {
		dev = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(t);
			// Commit the transaction
			session.getTransaction().commit();
			logger.info("Anuncio " + t.getIdAnuncio() + " saved successfully.");
			dev = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.close();
		return dev;
	}

	public boolean removeAnuncio(TablonAnuncios t) {
		dev = false;
		// TODO Auto-generated method stub4
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.delete(t);
			session.getTransaction().commit();
			logger.info("Anuncio " + t.getIdAnuncio() + " removed successfully.");
			dev = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return dev;

	}

	public boolean updateAnuncio(TablonAnuncios t) {
		// TODO Auto-generated method stub
		boolean dev = false;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.update(t);
			session.getTransaction().commit();
			logger.info("Anuncio " + t.getIdAnuncio() + " updated successfully.");
			dev = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return dev;
	}

	public List<TablonAnuncios> listAnuncios() {
		// TODO Auto-generated method stub
		Session session = null;
		List<TablonAnuncios> anunciosList = new ArrayList<TablonAnuncios>();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(TablonAnuncios.class)
					.addOrder( Order.desc("idAnuncio"));	// ordenamos por mas recientes	
			anunciosList = criteria.list();
			
		} catch (HibernateException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally
	    {
	        session.close();
	    }
		return anunciosList;
	}
	
	public TablonAnuncios getAnuncio(int id){
			TablonAnuncios t = new TablonAnuncios();
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(TablonAnuncios.class)
					.add(Restrictions.eq("id_anuncio", id));
			t = (TablonAnuncios)criteria.uniqueResult();
			session.close();
			//return (Persona)criteria.list().get(0);
			return t;
		}
	
	public List<TablonAnuncios> listAnunciosPersona(String email) {
		// TODO Auto-generated method stub
		Session session = null;
		List<TablonAnuncios> anunciosList = new ArrayList<TablonAnuncios>();
		try{
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria =  session.createCriteria(TablonAnuncios.class)
				.add(Restrictions.eq("emailPersona",email ))
				.addOrder( Order.desc("idAnuncio"));	// ordenamos por mas recientes	
		anunciosList = criteria.list();
		} catch (HibernateException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally
	    {		
		session.close();
	    }
		return anunciosList;
	}
	
}
