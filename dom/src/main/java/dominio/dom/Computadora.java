package dominio.dom;


import java.util.List;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.CollectionLayout;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberGroupLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.RenderType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.query.QueryDefault;
import dominio.dom.serv.OrdenServicioComputadora;


@DomainObject(bounded=true,objectType = "COMPUTADORA")
@PersistenceCapable(identityType=IdentityType.DATASTORE)
@MemberGroupLayout( columnSpans= {4,0,0,8})
public class Computadora 
{

	private String id;
	private String nombre;
	private String Detalle;
	private Sector sector;
	private String cpu;
	private String ram;
	private String disco;
	private String ip;
	private String sistemaOperativo;
	private String teamViewer;
	
	
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
	
	@MemberOrder(sequence= "2",name="Computadora")
	@Column(allowsNull="false")
	public String getNombre() {
		return nombre;
	}
	
	@Column(allowsNull="true")
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
	
	@MemberOrder(sequence= "5",name="Computadora")
	@Column(allowsNull="false")
	public String getSistemaOperativo() {
		return sistemaOperativo;
	}
	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}
	
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
	
	
	@MemberOrder(sequence= "1",name="Historial")
	@CollectionLayout(render = RenderType.EAGERLY)
	public List<OrdenServicioComputadora> getHistorial (){
		return container.allMatches(new QueryDefault<>(OrdenServicioComputadora.class,"buscarPorComputadora","id", this));
	}
	
	
	   @javax.inject.Inject 
	    DomainObjectContainer container;
	
}
