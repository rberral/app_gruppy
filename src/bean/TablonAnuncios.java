package bean;

// Generated 22-abr-2017 18:44:50 by Hibernate Tools 3.4.0.CR1

/**
 * TablonAnuncios generated by hbm2java
 */
public class TablonAnuncios implements java.io.Serializable {

	private Integer idAnuncio;
	private String emailPersona;
	private String asunto;
	private String descripcion;
	private boolean activo;

	public TablonAnuncios() {
	}

	public TablonAnuncios(String emailPersona, String asunto,
			String descripcion, boolean activo) {
		this.emailPersona = emailPersona;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public Integer getIdAnuncio() {
		return this.idAnuncio;
	}

	public void setIdAnuncio(Integer idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public String getEmailPersona() {
		return this.emailPersona;
	}

	public void setEmailPersona(String emailPersona) {
		this.emailPersona = emailPersona;
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

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
