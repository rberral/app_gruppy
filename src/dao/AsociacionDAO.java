package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import bean.Asociacion;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class AsociacionDAO {
	private boolean dev;
	private static final Logger logger = Logger.getLogger(AsociacionDAO.class.getName());

	private static final long serialVersionUID = 1L;

	/*public AsociacionDAO(){
		
	}*/
	public boolean addAsociacion(Asociacion a) {
		dev = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(a);
			// Commit the transaction
			session.getTransaction().commit();
			logger.info("Asociacion " + a.getNombre() + " saved successfully.");
			dev = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.close();
		return dev;
	}

	public boolean removeAsociacion(Asociacion a) {
		dev = false;
		// TODO Auto-generated method stub4
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.delete(a);
			session.getTransaction().commit();
			logger.info("Asociacion " + a.getNombre() + " removed successfully.");
			dev = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return dev;

	}

	public boolean updateAsociacion(Asociacion a) {
		// TODO Auto-generated method stub
		boolean dev = false;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.update(a);
			session.getTransaction().commit();
			logger.info("Asociacion " + a.getNombre() + " updated successfully.");
			dev = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return dev;
	}

	public static List<Asociacion> listAsociaciones() {
		// TODO Auto-generated method stub
		Session session = null;
		List<Asociacion> asociacionList = new ArrayList<Asociacion>();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			asociacionList = session.createQuery("from Asociacion").list();
		} catch (HibernateException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally
	    {
	        session.close();
	    }
		return asociacionList;
	}
}
