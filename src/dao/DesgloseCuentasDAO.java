package dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.Constantes;
import util.HibernateUtil;
import bean.DesgloseCuentas;
import bean.DesgloseCuentasAdicional;
import bean.Invitado;
import bean.Persona;
import bean.TablonAnuncios;

public class DesgloseCuentasDAO {
	private boolean dev;
	private static final Logger logger = Logger.getLogger(DesgloseCuentasDAO.class
			.getName());
	
	public List<DesgloseCuentasAdicional> listDesgloseAdicional(int year, int tipoCuota){
		// TODO Auto-generated method stub
		if(year == 0){
	    Calendar cal = Calendar.getInstance();
		year = cal.getInstance().get(Calendar.YEAR);
		}
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria =  session.createCriteria(DesgloseCuentasAdicional.class)
				.add(Restrictions.eq("annoCuenta", year))
				.add(Restrictions.eq("tipoCuota",tipoCuota ));
		List<DesgloseCuentasAdicional> desgloseList = criteria.list();
		session.close();
		return desgloseList;
	}
	
	public List<DesgloseCuentasAdicional> listDesgloseAdicional(int year){
		// TODO Auto-generated method stub
		Session session = null;
		if(year == 0){
		    Calendar cal = Calendar.getInstance();
			year = cal.getInstance().get(Calendar.YEAR);
			}
		List<DesgloseCuentasAdicional> desgloseList = new ArrayList<DesgloseCuentasAdicional>();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(DesgloseCuentasAdicional.class)
					.add(Restrictions.eq("annoCuenta", year));
			desgloseList = criteria.list();
		} catch (HibernateException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally
	    {
	        session.close();
	    }
		return desgloseList;		
	}
	
	public List<DesgloseCuentasAdicional> listDesgloseAdicional(int year, Persona p){
		// TODO Auto-generated method stub
		if(year == 0){
		    Calendar cal = Calendar.getInstance();
			year = cal.getInstance().get(Calendar.YEAR);
			}
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria =  session.createCriteria(DesgloseCuentasAdicional.class)
				.add(Restrictions.eq("idPersona", p.getIdPersona()))
						.add(Restrictions.eq("annoCuenta", year));
		List<DesgloseCuentasAdicional> desgloseList = criteria.list();
		session.close();
		return desgloseList;	
	}
	
	public List<DesgloseCuentas> listDesgloseCuotas(int year){
		// TODO Auto-generated method stub
		if(year == 0){
	    Calendar cal = Calendar.getInstance();
		year = cal.getInstance().get(Calendar.YEAR);
		}
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria =  session.createCriteria(DesgloseCuentas.class).add(Restrictions.eq("id.annoCuenta", year));
		List<DesgloseCuentas> desgloseList = criteria.list();
		session.close();
		return desgloseList;
	}
	
	public List<DesgloseCuentas> listDesgloseCuotas(int year, Persona p){
		// TODO Auto-generated method stub
		if(year == 0){
		    Calendar cal = Calendar.getInstance();
			year = cal.getInstance().get(Calendar.YEAR);
			}		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria =  session.createCriteria(DesgloseCuentas.class)
				.add(Restrictions.eq("id.idPersona", p.getIdPersona()))
				.add(Restrictions.eq("id.annoCuenta", year));
		List<DesgloseCuentas> desgloseList = criteria.list();
		session.close();
		return desgloseList;	
	}
}
