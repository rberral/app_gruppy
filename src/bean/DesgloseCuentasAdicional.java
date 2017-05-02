package bean;

// Generated 24-abr-2017 21:27:08 by Hibernate Tools 3.4.0.CR1

/**
 * DesgloseCuentasAdicional generated by hbm2java
 */
public class DesgloseCuentasAdicional implements java.io.Serializable {

	private Integer idAdicional;
	private int idLibro;
	private int idPersona;
	private int annoCuenta;
	private int cuotaAdicional;
	private int coste;
	private boolean pagado;

	public DesgloseCuentasAdicional() {
	}

	public DesgloseCuentasAdicional(int idLibro, int idPersona, int annoCuenta,
			int cuotaAdicional, int coste, boolean pagado) {
		this.idLibro = idLibro;
		this.idPersona = idPersona;
		this.annoCuenta = annoCuenta;
		this.cuotaAdicional = cuotaAdicional;
		this.coste = coste;
		this.pagado = pagado;
	}

	public Integer getIdAdicional() {
		return this.idAdicional;
	}

	public void setIdAdicional(Integer idAdicional) {
		this.idAdicional = idAdicional;
	}

	public int getIdLibro() {
		return this.idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getAnnoCuenta() {
		return this.annoCuenta;
	}

	public void setAnnoCuenta(int annoCuenta) {
		this.annoCuenta = annoCuenta;
	}

	public int getCuotaAdicional() {
		return this.cuotaAdicional;
	}

	public void setCuotaAdicional(int cuotaAdicional) {
		this.cuotaAdicional = cuotaAdicional;
	}

	public int getCoste() {
		return this.coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	public boolean isPagado() {
		return this.pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

}
