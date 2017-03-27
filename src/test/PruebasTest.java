package test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.sun.org.apache.xalan.internal.xsltc.dom.LoadDocument;

import bean.Persona;
import dao.PersonaDAO;
import service.PersonaService;
import util.Constantes;
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
		File f = new File(Constantes.URLMaestroRolXML);
		System.out.println(f.getPath());
		System.out.println(f.getAbsolutePath());
		Document documento = null;
		File f2 = new File(Constantes.URLMaestroRolXML);
	}
	

}
