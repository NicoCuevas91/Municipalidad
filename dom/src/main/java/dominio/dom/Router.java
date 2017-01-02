package dominio.dom;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;

@DomainObject(objectType = "ROUTER")
@PersistenceCapable(identityType=IdentityType.DATASTORE)
public class Router {
	private Sector sector;
	private String ip;
	private String usuario;
	private String contraseña;
	private boolean wifi;
	private String contraseñaWifi;
	
	@Column(allowsNull="false")
	@MemberOrder(sequence= "1",name="Router")
	@Title
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	@Column(allowsNull="false")
	@MemberOrder(sequence= "2",name="Router")
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Column(allowsNull="false")
	@MemberOrder(sequence= "3",name="Router")
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Column(allowsNull="false")
	@MemberOrder(sequence= "4",name="Router")
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	@Column(allowsNull="false")
	@MemberOrder(sequence= "5",name="Router")
	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	@Column(allowsNull="true")
	@MemberOrder(sequence= "6",name="Router")
	public String getContraseñaWifi() {
		return contraseñaWifi;
	}
	public void setContraseñaWifi(String contraseñaWifi) {
		this.contraseñaWifi = contraseñaWifi;
	}
	
	
	
}
