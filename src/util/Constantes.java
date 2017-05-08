package util;

public final class Constantes {
	
	// -------------------- CONSTANTES SESSION -------------------- //
	public static final String sessionUsuario = "user";
	//public static final String sessionAsociacion = "asociacion";
	
	// -------------------- RESPUESTAS SOBRE BBDD -------------------- //
	public static final String RESPUESTA_ACCION = "RESPUESTA_ACCION";
	public static final String RESPUESTA_ERROR_VALUE = "ERROR";
	public static final String RESPUESTA_OK_VALUE = "OK";
	
	public static final String MSG_OK_UPDATE = "Operación realizada correctamente.";
	public static final String MSG_ERROR_UPDATE = "Operación fallida, revise los campos.";

	// -------------------- PERMISO EDICION Y BORRADO DE SOCIOS (ROLES 1 y 2) -------------------- //
	public static final int[] AUTH_UPDATE_DELETE_SOCIOS = {1,2};
	
	// -------------------- URI's  -------------------- //	
	public static final String URI_MAIN = "/main.jsp";
	public static final String URI_INDEX = "/index.jsp";
	public static final String URI_INFO_ASOC = "/info_asoc.jsp";
	public static final String URI_MI_PERFIL = "/mi_perfil.jsp";
	public static final String URI_SOCIOS = "/socios.jsp";
	public static final String URI_TABLON = "/tablon.jsp";
	public static final String URI_INVITADOS = "/invitados.jsp";
	

	public static final String URI_OPER_LOGOUT = "logout";
	public static final String URI_OPER_LOGIN = "login";
	//public static final String URI_OPER_REDIRECT = "redirect";
	
	
	
// -------------------- FICHEROS MAESTROS XML -------------------- //
	public static final String URLMaestroRolXML = "src/xml/RolesUsuario.xml";
	
	
	
// -------------------- PARAMETROS FORMULARIOS -------------------- //	
// Tienen que estar sincronizados con los definidos en los javascript de formularios	
	public static final String FORM_JS_OPER_UPDATE = "update";
	public static final String FORM_JS_OPER_DELETE = "delete";
	public static final String FORM_JS_OPER_INSERT = "insert";
	
	
	public static final String FORM_JS_OPER = "?oper";
	public static final String FORM_JS_EMAIL = "email";
	public static final String FORM_JS_IDENTIFICADOR = "identificador";
	public static final String FORM_JS_EDIT_EMAIL = "editEmail";
	public static final String FORM_JS_NOMBRE = "nombre"; 
	public static final String FORM_JS_FUNDADOR = "fundador";
	//public static final String FORM_JS_EDIT_FUNDADOR = "editFundador";
	public static final String FORM_JS_FECHA = "fecha";
	public static final String FORM_JS_FECHA_ALTA = "fechaAlta";
	public static final String FORM_JS_ACTIVO = "activo";
	public static final String FORM_JS_OBSERVACIONES = "observaciones";
	//public static final String FORM_JS_EDIT_FECHA_ALTA = "editFechaAlta";
	
	
	// -------------------- MAPPING VALORES BOOLEANOS -------------------- //
	public static final String BOOLEAN_TRUE = "Si";
	public static final String BOOLEAN_FALSE = "No";
	
}
