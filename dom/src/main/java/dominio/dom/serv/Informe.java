package dominio.dom.serv;

import org.apache.isis.applib.annotation.MemberOrder;

public class Informe {
	private String sector;
	private int cantidad;
	
	
	@MemberOrder(sequence = "1")
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	@MemberOrder(sequence = "2")
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
