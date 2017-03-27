package bean;

// Generated 23-mar-2017 23:45:21 by Hibernate Tools 3.4.0.CR1

/**
 * Rol generated by hbm2java
 */
public class Rol implements java.io.Serializable {

	private Integer idRol;
	private String nombre;
	private String autorizacionUrl;
	private boolean activo;

	public Rol() {
	}

	public Rol(String nombre, String autorizacionUrl, boolean activo) {
		this.nombre = nombre;
		this.autorizacionUrl = autorizacionUrl;
		this.activo = activo;
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutorizacionUrl() {
		return this.autorizacionUrl;
	}

	public void setAutorizacionUrl(String autorizacionUrl) {
		this.autorizacionUrl = autorizacionUrl;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
