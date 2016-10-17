package dominio.dom.serv;


import java.util.Date;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;
import dominio.dom.Computadora;

@DomainObject
@PersistenceCapable
public class OrdenServicioComputadora {
	
	String id;
	Computadora computadora;
	Date fechaIngreso;
	Date fechaSalida;
	Estado estado;
	String causa;
	boolean cables;
	Tecnicos tecnico;
	
	
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
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	@Column(allowsNull="true")
	@MemberOrder(sequence= "4",name="Orden")
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
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
	public Tecnicos getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnicos tecnico) {
		this.tecnico = tecnico;
		
	}
	@MemberOrder(sequence= "8",name="Orden")
	public boolean isCables() {
		return cables;
	}
	public void setCables(boolean cables) {
		this.cables = cables;
	}
	
	
	
}
