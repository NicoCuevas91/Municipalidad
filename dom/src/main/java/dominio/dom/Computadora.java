package dominio.dom;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Unique;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;

@DomainObject(bounded=true,objectType = "COMPUTADORA")
@PersistenceCapable(identityType=IdentityType.DATASTORE)
@Unique(name="Computadora_key", members = {"nSerie"})
public class Computadora 
{
	
	
	String id;
	String nombre;
	String Detalle;
	Sector sector;
	String cpu;
	String ram;
	String disco;
	String ip;
	String teamViewer;
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "5",name="Computadora")
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "6",name="Computadora")
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "7",name="Computadora")
	public String getDisco() {
		return disco;
	}
	public void setDisco(String disco) {
		this.disco = disco;
	}
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "8",name="Computadora")
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Column(allowsNull="true")
	@MemberOrder(sequence= "9",name="Computadora")
	public String getTeamViewer() {
		return teamViewer;
	}
	public void setTeamViewer(String teamViewer) {
		this.teamViewer = teamViewer;
	}	
	
	
	@MemberOrder(sequence= "2",name="Computadora")
	@Column(allowsNull="false")
	public String getNombre() {
		return nombre;
	}
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "1",name="Computadora")
	@Title
	public String getId() {
		return id;
	}
	public void setId(String nSerie) {
		this.id = nSerie;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(allowsNull="false")
	@MemberOrder(sequence= "3",name="Computadora")
	public String getDetalle() {
		return Detalle;
	}
	public void setDetalle(String detalle) {
		Detalle = detalle;
	}
	
	@MemberOrder(sequence= "4",name="Computadora")
	@Column(allowsNull="true")
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	
}
