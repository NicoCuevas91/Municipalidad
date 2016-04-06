package dominio.dom;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.DomainObject;

@DomainObject(bounded=true, objectType = "DIRECTOR")
@PersistenceCapable(identityType=IdentityType.DATASTORE)
public class Director {
	String nombre;
	String numero;
	String email;
	
	
	@Column(allowsNull="false")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(allowsNull="false")
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Column(allowsNull="false")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
