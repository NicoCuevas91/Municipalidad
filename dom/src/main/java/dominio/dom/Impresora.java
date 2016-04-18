package dominio.dom;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;

@DomainObject(bounded=true,objectType = "IMPRESORA")
@PersistenceCapable(identityType=IdentityType.DATASTORE)
public class Impresora {
	String id;
	String nombre;
	String Detalle;
	Sector sector;
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "1",name="Impresora")
	@Title
	public String getId() {
		return id;
	}
	public void setId(String nSerie) {
		this.id = nSerie;
	}
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "2",name="Impresora")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(allowsNull="false")
	@MemberOrder(sequence= "3",name="Impresora")
	public String getDetalle() {
		return Detalle;
	}
	public void setDetalle(String detalle) {
		Detalle = detalle;
	}
	@Column(allowsNull="true")
	@MemberOrder(sequence= "4",name="Impresora")
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
}
