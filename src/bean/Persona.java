package bean;

// Generated 22-may-2017 22:53:39 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Persona generated by hbm2java
 */
public class Persona implements java.io.Serializable {

	private Integer idPersona;
	private String email;
	private String pass;
	private String nombre;
	private String apellidos;
	private int telefono;
	private Date fechaNacimiento;
	private int idRol;
	private boolean fundador;
	private boolean activo;
	private Date fechaAlta;
	private Date fechaBaja;

	public Persona() {
	}

	public Persona(String email, String pass, String nombre, String apellidos,
			int telefono, Date fechaNacimiento, int idRol, boolean fundador,
			boolean activo, Date fechaAlta, Date fechaBaja) {
		this.email = email;
		this.pass = pass;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.idRol = idRol;
		this.fundador = fundador;
		this.activo = activo;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public boolean isFundador() {
		return this.fundador;
	}

	public void setFundador(boolean fundador) {
		this.fundador = fundador;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

}
