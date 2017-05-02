package bean;

// Generated 24-abr-2017 21:27:08 by Hibernate Tools 3.4.0.CR1

/**
 * DesgloseCuentasId generated by hbm2java
 */
public class DesgloseCuentasId implements java.io.Serializable {

	private int idLibro;
	private int idPersona;
	private int annoCuenta;
	private int mensualidad;

	public DesgloseCuentasId() {
	}

	public DesgloseCuentasId(int idLibro, int idPersona, int annoCuenta,
			int mensualidad) {
		this.idLibro = idLibro;
		this.idPersona = idPersona;
		this.annoCuenta = annoCuenta;
		this.mensualidad = mensualidad;
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

	public int getMensualidad() {
		return this.mensualidad;
	}

	public void setMensualidad(int mensualidad) {
		this.mensualidad = mensualidad;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DesgloseCuentasId))
			return false;
		DesgloseCuentasId castOther = (DesgloseCuentasId) other;

		return (this.getIdLibro() == castOther.getIdLibro())
				&& (this.getIdPersona() == castOther.getIdPersona())
				&& (this.getAnnoCuenta() == castOther.getAnnoCuenta())
				&& (this.getMensualidad() == castOther.getMensualidad());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdLibro();
		result = 37 * result + this.getIdPersona();
		result = 37 * result + this.getAnnoCuenta();
		result = 37 * result + this.getMensualidad();
		return result;
	}

}
