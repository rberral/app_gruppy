package bean;

// Generated 22-abr-2017 18:44:50 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Asociacion generated by hbm2java
 */
public class Asociacion implements java.io.Serializable {

	private Integer idAsociacion;
	private String nombre;
	private String descripcion;
	private String direccion;
	private String email;
	private int telefono;
	private Date fechaFundacion;

	public Asociacion() {
	}

	public Asociacion(String nombre, String descripcion, String direccion,
			String email, int telefono, Date fechaFundacion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.fechaFundacion = fechaFundacion;
	}

	public Integer getIdAsociacion() {
		return this.idAsociacion;
	}

	public void setIdAsociacion(Integer idAsociacion) {
		this.idAsociacion = idAsociacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Date getFechaFundacion() {
		return this.fechaFundacion;
	}

	public void setFechaFundacion(Date fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

}
