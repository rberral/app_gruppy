package test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.sun.org.apache.xalan.internal.xsltc.dom.LoadDocument;

import bean.Invitado;
import bean.Persona;
import dao.PersonaDAO;
import service.PersonaService;
import util.Constantes;
import util.HibernateUtil;
import util.MaestroDatos;

public class PruebasTest {

	public static void main(String[] args) {
		//String p[] = null;
		// TODO Auto-generated method stub
		//HashMap<Integer, String> lista = MaestroDatos.getRolesUsuario();
		//util.ReadXMLFile.main(p);
		
		/*Date fecha = null;
		String dateString = "1982-12-20";
		//new Date("1984/12/25")
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy"); 
		try {
			fecha = formatter.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("fecha " +fecha.toString());
		
		
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(fecha);
	    cal.set( Calendar.HOUR_OF_DAY, 0);
	    cal.set( Calendar.MINUTE, 0);
	    cal.set( Calendar.SECOND, 0);
	    cal.set( Calendar.MILLISECOND, 0);
	    Date ff = cal.getTime();*/
		/*
		File f = new File(Constantes.URLMaestroRolXML);
		System.out.println(f.getPath());
		System.out.println(f.getAbsolutePath());
		Document documento = null;
		File f2 = new File(Constantes.URLMaestroRolXML);
		*/

//		 Calendar calendar = Calendar.getInstance();
//		 calendar.set(9999, 11, 31);
//		// calendar.set(Calendar.HOUR_OF_DAY, 0);
//		 //calendar.clear(Calendar.MILLISECOND);
//		 Date fecha = calendar.getTime();
//		 //p.setFechaBaja(new Date(9999,12,31));
//		 System.out.println(fecha.toString());
//		 
//		 Calendar calendar2 = new GregorianCalendar(9999,11,31);
//		 Date d = calendar2.getTime();
//		 System.out.println(d.toString());
//
//		
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.set( Calendar.HOUR_OF_DAY, 0);
	    cal.set( Calendar.MINUTE, 0);
	    cal.set( Calendar.SECOND, 0);
	    cal.set( Calendar.MILLISECOND, 0);
	    cal.set (Calendar.YEAR, 2018);
	    cal.set(Calendar.MONTH, 04);
	    cal.set(Calendar.DAY_OF_MONTH,05);
	    Date fechaActual = cal.getTime();
	    cal.set(Calendar.YEAR,2019);
	    Date fechaNueva = cal.getTime();
		Session session = HibernateUtil.getSessionFactory().openSession();
		//List<Persona> list = session.createCriteria(Persona.class).list();
		//List<Persona> personaList = session.createQuery("from Persona").list();
		Criteria criteria =  session.createCriteria(Invitado.class)
				.add(Restrictions.eq("emailPersona", "email@hotmail.com"))
				.add(Restrictions.between("fechaInvitacion", fechaActual, fechaNueva));
		List<Invitado> invitadoList = criteria.list();
		session.close();
	}
	

}
