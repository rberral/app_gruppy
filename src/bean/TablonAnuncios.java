package bean;

// Generated 13-feb-2018 19:37:19 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TablonAnuncios generated by hbm2java
 */
public class TablonAnuncios implements java.io.Serializable {

	private Integer idAnuncio;
	private String email;
	private String asunto;
	private String descripcion;
	private Date fechaCreate;
	private Date fechaDelete;

	public TablonAnuncios() {
	}

	public TablonAnuncios(String email, String asunto,
			String descripcion, Date fechaCreate, Date fechaDelete) {
		this.email = email;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.fechaCreate = fechaCreate;
		this.fechaDelete = fechaDelete;
	}

	public Integer getIdAnuncio() {
		return this.idAnuncio;
	}

	public void setIdAnuncio(Integer idAnuncio) {
		this.idAnuncio = idAnuncio;
	}
	
	public String getEmailPersona() {
		return this.email;
	}

	public void setEmailPersona(String emailPersona) {
		this.email = emailPersona;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreate() {
		return this.fechaCreate;
	}

	public void setFechaCreate(Date fechaCreate) {
		this.fechaCreate = fechaCreate;
	}

	public Date getFechaDelete() {
		return this.fechaDelete;
	}

	public void setFechaDelete(Date fechaDelete) {
		this.fechaDelete = fechaDelete;
	}

}
