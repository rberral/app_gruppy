package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.Invitado;
import bean.Persona;
import service.PersonaService;
import sun.security.util.Length;
// CLASE USADA PARA METODOS GENERALES
public class Utilidades {

	final static String WEB_FORMAT_2 = "yyyy-MM-dd";
	final static String WEB_FORMAT = "dd-MM-yyyy";
	final static String BBDD_FORMAT_2 = "yyyy-MM-dd";
	final static String BBDD_FORMAT = "dd-MM-yyyy";
	final static String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	final static String PATTERN_TEL = "^\\+?\\d{1,3}?[- .]?\\(?(?:\\d{2,3})\\)?[- .]?\\d\\d\\d[- .]?\\d\\d\\d\\d$";
	
	public static String getFechaToJSP(Date f){
		DateFormat df = new java.text.SimpleDateFormat(WEB_FORMAT);
		return df.format(f);
	}
	
	public static String getFechaActualToJSP(){
		Date f = new Date();
		DateFormat df = new java.text.SimpleDateFormat(WEB_FORMAT);
		return df.format(f);
	}
	
	public static String getFechaToEditJSP(Date f){
		DateFormat df = new java.text.SimpleDateFormat(WEB_FORMAT_2);
		return df.format(f);
	}
	
	
	public static Date getFechaToBBDD(String f){
		Date fecha = null;
		if(isDateValid(f)){
		SimpleDateFormat df = new SimpleDateFormat(BBDD_FORMAT);
		try {
			fecha = df.parse(f);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return fecha;
	}
	
	public static boolean isDateValid(String date) 
	{
	        try {
	            DateFormat df = new SimpleDateFormat(BBDD_FORMAT);
	            df.setLenient(false);
	            df.parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
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
	
	public static boolean checkDateInvitado(Date d){
		Date fsistema = new Date();
		if(d.compareTo(fsistema)< 0 || d.compareTo(fsistema)==0 ){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static String getMes(int month){
		String mes = "";
		switch (month) {
		case 1:
			mes = "Enero";
			break;
		case 2:
			mes = "Febrero";
			break;
		case 3:
			mes = "Marzo";
			break;
		case 4:
			mes = "Abril";
			break;
		case 5:
			mes = "Mayo";
			break;
		case 6:
			mes = "Junio";
			break;
		case 7:
			mes = "Julio";
			break;
		case 8:
			mes = "Agosto";
			break;
		case 9:
			mes = "Septiembre";
			break;
		case 10:
			mes = "Octubre";
			break;
		case 11:
			mes = "Noviembre";
			break;
		case 12:
			mes = "Diciembre";
			break;			
		default:
			break;
		}
		return mes;
	}
	
	public static String getTipoCuota(int tipoCuota){
		String cuota = "";
		switch (tipoCuota) {
		case Constantes.TIPO_CUOTA_MENSUAL: cuota = "Mensual";
			break;
		case Constantes.TIPO_CUOTA_INVITADOS: cuota = "Invitado"; 
			break;
		case Constantes.TIPO_CUOTA_OTROS: cuota = "Otros";
			break;
		default:
			break;
		}
		return cuota;
	}
	
	public static String getNameSurname(int idPersona){
		PersonaService p = new PersonaService();
		return p.getNameSurnamePersona(idPersona);
	}
	
	public static boolean validacionesPerfil(Persona p){
		boolean dev = false;
		if((p.getFechaAlta() != null)|| (p.getNombre() != "")
				|| (p.getApellidos() != "") || (p.getPass() != "")
				|| (Utilidades.isEmailValid(p.getEmail())) || (Utilidades.isTelefonoValid(p.getTelefono()))) {
			dev = true;
		}
		return dev;
	}
	
	public static boolean isEmailValid(String email ){
		Pattern pattern	= Pattern.compile(PATTERN_EMAIL);
		
		Matcher matcher = pattern.matcher(email);
        return matcher.matches();
	}
	
	public static boolean isTelefonoValid(int telefono){
		String tel = String.valueOf(telefono);
		Pattern pattern	= Pattern.compile(PATTERN_TEL);
		
		Matcher matcher = pattern.matcher(tel);
        return matcher.matches();
	}
	
	public static boolean validaSocio(Persona p){
		boolean dev = false;
		if(p.getFechaAlta()!=null){
			dev = true;
		}
		return dev;
	}
	
	public static boolean validaInvitado(Invitado i){
		boolean dev = false;
		//identificador???
		if((i.getNombreInvitado() != "") && (Utilidades.checkDateInvitado(i.getFechaInvitacion())) 
			&& (i.getObservaciones()!="")){
			dev = true;
		}
		return dev;
	}
	
}
