package dominio.dom.serv;

import java.util.Calendar;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.DatastoreIdentity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;
import dominio.dom.Computadora;

@DomainObject
@DatastoreIdentity(strategy=IdGeneratorStrategy.INCREMENT,column="id")
@PersistenceCapable(identityType=IdentityType.DATASTORE)
public class OrdenServicioComputadora {
	
	String id;
	Computadora computadora;
	Calendar fechaIngreso;
	Calendar fechaSalida;
	Estado estado;
	String causa;
	String tecnico;
	
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "1",name="Orden")
	@Title
	public String getId() {
		return id;
	}	
	public void setId(String id) {
		this.id = id;
	}


	@Column(allowsNull="false")
	@MemberOrder(sequence= "2",name="Orden")
	public Computadora getComputadora() {
		return computadora;
	}
	public void setComputadora(Computadora computadora) {
		this.computadora = computadora;
	}
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "3",name="Orden")
	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	@Column(allowsNull="true")
	@MemberOrder(sequence= "4",name="Orden")
	public Calendar getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "5",name="Orden")
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "6",name="Orden")
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	
	@Column(allowsNull="true")
	@MemberOrder(sequence= "7",name="Orden")
	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	
	
	
}
