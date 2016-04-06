package dominio.dom;

import javax.jdo.annotations.Column;

public abstract class Componente {

	String nSerie;
	String nombre;
	String Detalle;
	Sector sector;
	
	
	@Column(allowsNull="false")
	public String getnSerie() {
		return nSerie;
	}
	public void setnSerie(String nSerie) {
		this.nSerie = nSerie;
	}
	@Column(allowsNull="false")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(allowsNull="false")
	public String getDetalle() {
		return Detalle;
	}
	public void setDetalle(String detalle) {
		Detalle = detalle;
	}
	@Column(allowsNull="true")
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	
	
	
}
