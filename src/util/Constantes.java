package util;

public final class Constantes {
	
	// -------------------- CONSTANTES SESSION -------------------- //
	public static final String sessionUsuario = "user";
	
	// -------------------- RESPUESTAS SOBRE BBDD -------------------- //
	public static final String RESPUESTA_ACCION = "RESPUESTA_ACCION";
	public static final String RESPUESTA_ERROR_VALUE = "ERROR";
	public static final String RESPUESTA_OK_VALUE = "OK";
	
	public static final String MSG_OK_UPDATE_USER = "Operación realizada correctamente.";
	public static final String MSG_ERROR_UPDATE_USER = "Operación fallida, revise los campos.";

	// -------------------- PERMISO EDICION Y BORRADO DE SOCIOS (ROLES 1 y 2) -------------------- //
	public static final int[] AUTH_UPDATE_DELETE_SOCIOS = {1,2};
	
	
	
// -------------------- FICHEROS MAESTROS XML -------------------- //
	public static final String URLMaestroRolXML = "src/xml/RolesUsuario.xml";
}
