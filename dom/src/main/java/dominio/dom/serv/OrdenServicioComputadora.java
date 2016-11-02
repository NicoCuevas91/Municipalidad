package dominio.dom.serv;


import java.util.Date;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberGroupLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;
import dominio.dom.Computadora;



@javax.jdo.annotations.Queries
({
    @javax.jdo.annotations.Query(name = "buscarPorComputadora", language = "JDOQL",value = "SELECT "+ "FROM dominio.dom.serv.ordenserviciocomputadora "+ "WHERE computadora == :id"),
    @javax.jdo.annotations.Query(name = "buscarPorEstado", language = "JDOQL",value = "SELECT "+ "FROM dominio.dom.serv.ordenserviciocomputadora "+ "WHERE estado == :estado")
})


@PersistenceCapable
@DomainObject(bounded=true,objectType = "ORDEN")
@MemberGroupLayout(columnSpans={4,4,4,8},middle="Orden")
public class OrdenServicioComputadora {
	
	
	private String id;
	private Computadora computadora;
	private Date fechaIngreso;
	private Date fechaSalida;
	private Estado estado;
	private String causa;
	private boolean cables;
	private Tecnicos tecnico;
	private String informe;
	

	@Column(allowsNull="true")
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
	
	@Column(allowsNull="true")
	@MemberOrder(sequence= "9",name="Orden")
	public String getInforme() {
		return informe;
	}
	public void setInforme(String informe) {
		this.informe = informe;
	}
	
	
	
}
