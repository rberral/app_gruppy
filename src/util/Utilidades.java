package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
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

	public static Map<String, String> getMapa(String params){
		Map<String, String> mapa = new HashMap<String, String>();
		
		
		int i;
		String line,word,subword;
		StringTokenizer elementos,subelementos;
		//line ="[[a,b],[c,d],[e,f]]";
		elementos = new StringTokenizer(params,"&");
		while(elementos.hasMoreTokens()){
		  word = elementos.nextToken();
		  //i=1;
		  
		  subelementos = new StringTokenizer(word,"=");
		  
		  String key = subelementos.nextToken();
		  String value = subelementos.nextToken();
		  mapa.put(key, value);
		  key = null;
		  value = null;
		  /*while(subelementos.hasMoreTokens()){
		    subword = subelementos.nextToken();
		    System.out.println(i+". "+subword);
		    i++;
		  }*/
		}
		
		
		return mapa;
	}
	
	public static String getValueRol(int idRol){
		Map<Integer, String> listado = null;
		listado = MaestroDatos.getRolesUsuario();
		return listado.get(idRol);
	}
	
	public static String getValueBooleanSelectToJSP(boolean valor){
		String val = Constantes.BOOLEAN_FALSE;
		if(valor){
			val = Constantes.BOOLEAN_TRUE;
		}
		return val;
		}
	
	public static boolean getValueBooleanSelectToBBDD(String valor){
		boolean value = false;
		if(valor.compareTo(Constantes.BOOLEAN_TRUE)==0){
			value = true;
		}
		return value;
	}
}
