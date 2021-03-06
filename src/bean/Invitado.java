package bean;

// Generated 22-may-2017 22:53:39 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Invitado generated by hbm2java
 */
public class Invitado implements java.io.Serializable {

	private Integer idInvitado;
	private String emailPersona;
	private Date fechaInvitacion;
	private String nombreInvitado;
	private String observaciones;

	public Invitado() {
	}

	public Invitado(String emailPersona, Date fechaInvitacion) {
		this.emailPersona = emailPersona;
		this.fechaInvitacion = fechaInvitacion;
	}

	public Invitado(String emailPersona, Date fechaInvitacion,
			String nombreInvitado, String observaciones) {
		this.emailPersona = emailPersona;
		this.fechaInvitacion = fechaInvitacion;
		this.nombreInvitado = nombreInvitado;
		this.observaciones = observaciones;
	}

	public Integer getIdInvitado() {
		return this.idInvitado;
	}

	public void setIdInvitado(Integer idInvitado) {
		this.idInvitado = idInvitado;
	}

	public String getEmailPersona() {
		return this.emailPersona;
	}

	public void setEmailPersona(String emailPersona) {
		this.emailPersona = emailPersona;
	}

	public Date getFechaInvitacion() {
		return this.fechaInvitacion;
	}

	public void setFechaInvitacion(Date fechaInvitacion) {
		this.fechaInvitacion = fechaInvitacion;
	}

	public String getNombreInvitado() {
		return this.nombreInvitado;
	}

	public void setNombreInvitado(String nombreInvitado) {
		this.nombreInvitado = nombreInvitado;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
