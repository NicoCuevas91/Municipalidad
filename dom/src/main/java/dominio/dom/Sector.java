package dominio.dom;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;

@DomainObject(bounded=true, objectType = "SECTOR")
@PersistenceCapable
public class Sector {

	String nombre;
	Director director;
	String numero;
	String email;
	
	@Column(allowsNull="false")
	@Title
	@MemberOrder(sequence= "1",name="Sector")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "2",name="Sector")
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "3",name="Sector")
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Column(allowsNull= "true")
	@MemberOrder(sequence= "4",name="Sector")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
