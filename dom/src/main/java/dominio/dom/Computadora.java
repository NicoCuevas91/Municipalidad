package dominio.dom;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.DomainObject;

@DomainObject(bounded=true,objectType = "COMPUTADORA")
@PersistenceCapable(identityType=IdentityType.DATASTORE)
public class Computadora extends Componente 
{
	String cpu;
	String ram;
	String disco;
	String ip;
	String teamViewer;
	
	@Column(allowsNull="false")
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	
	@Column(allowsNull="false")
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	
	@Column(allowsNull="false")
	public String getDisco() {
		return disco;
	}
	public void setDisco(String disco) {
		this.disco = disco;
	}
	
	@Column(allowsNull="false")
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Column(allowsNull="true")
	public String getTeamViewer() {
		return teamViewer;
	}
	public void setTeamViewer(String teamViewer) {
		this.teamViewer = teamViewer;
	}
	
	
	
}
