package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
// CLASE USADA PARA METODOS GENERALES
public class Utilidades {

	final static String WEB_FORMAT = "yyyy-MM-dd";
	final static String BBDD_FORMAT = "yyyy-MM-dd";
	
	public static String getFechaToJSP(Date f){
	DateFormat df = new java.text.SimpleDateFormat(WEB_FORMAT);
	return df.format(f);
	}
	
	public static Date getFechaToBBDD(String f){
		Date fecha = null;
		SimpleDateFormat df = new SimpleDateFormat(BBDD_FORMAT);
		try {
			fecha = df.parse(f);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fecha;
	}
	
	//usado para convertir eliminar caracter especial de email y poder usarlo como identificador
	public static String getEmailByTableBootstrap(String email){
		String conversor = email.replace("@","arroba");
		conversor = conversor.replace(".","punto");
		return conversor;
	}
	
}
