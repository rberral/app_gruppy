package bean;

// Generated 23-mar-2017 23:45:21 by Hibernate Tools 3.4.0.CR1

/**
 * LibroCuentas generated by hbm2java
 */
public class LibroCuentas implements java.io.Serializable {

	private Integer idLibro;
	private String nombre;
	private String descripcion;

	public LibroCuentas() {
	}

	public LibroCuentas(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Integer getIdLibro() {
		return this.idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
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

}