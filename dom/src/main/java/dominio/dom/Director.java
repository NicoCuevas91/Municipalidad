package dominio.dom;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Unique;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;

@DomainObject(bounded=true, objectType = "DIRECTOR")
@PersistenceCapable
@Unique(name="Director_key", members = {"nombre"})
public class Director {
	String nombre;
	String numero;
	String email;
	
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "1",name="Director")
	@Title
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "2",name="Director")
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "3",name="Director")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
