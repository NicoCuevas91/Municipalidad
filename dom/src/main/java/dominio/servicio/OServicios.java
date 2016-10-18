package dominio.servicio;


import java.util.Date;
import java.util.List;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.query.QueryDefault;
import dominio.dom.Computadora;
import dominio.dom.serv.Estado;
import dominio.dom.serv.OrdenServicioComputadora;
import dominio.dom.serv.Tecnicos;

@DomainService
@DomainServiceLayout(menuOrder = "1", named= "Orden de servicio")
public class OServicios
{
	
	@MemberOrder(sequence = "1")
	public OrdenServicioComputadora ingresarOrden(
			@ParameterLayout(named="ID") final String id,
			@ParameterLayout(named="Computadora")final Computadora computadora,
			@ParameterLayout(named="Causa",multiLine = 2 ) final String causa,
			@ParameterLayout(named="Tecnico") final Tecnicos tecnico,
			@ParameterLayout(named="Ingresa con cables") final boolean cables
			)
	{
		OrdenServicioComputadora os = container.newTransientInstance(OrdenServicioComputadora.class);
		os.setCausa(causa);
		os.setId(id);
		os.setEstado(Estado.Ingreso);
		os.setTecnico(tecnico);
		os.setFechaIngreso( new Date());
		os.setComputadora(computadora);		
		os.setCables(cables);
		container.persistIfNotAlready(os);
		
		return os;
	}
	
	@MemberOrder(sequence = "2")
	public OrdenServicioComputadora ordenSalida(@ParameterLayout(named="Orden") final OrdenServicioComputadora id,
												@ParameterLayout(named="Nuevo Estado") final Estado estado,
												@ParameterLayout(named="Informe",multiLine= 2) final String informe){
		id.setEstado(estado);
		id.setInforme(informe);
		id.setFechaSalida(new Date());
		
		return id;
	}
	
	@MemberOrder(sequence = "3")
	public OrdenServicioComputadora buscar(
			@ParameterLayout(named="Orden de servicio") final OrdenServicioComputadora orden
			){
		return orden;
	}
	
	@MemberOrder(sequence = "4")
	public List<OrdenServicioComputadora> listarOrdenesDeServicios(){
		List<OrdenServicioComputadora> salida = container.allInstances(OrdenServicioComputadora.class);
		return salida;
	}
	
	@MemberOrder(sequence = "5")
	public List<OrdenServicioComputadora> listarOrdenesDeServiciosPorEstado(
			@ParameterLayout(named="Estado") final Estado estado
			){
		return container.allMatches(new QueryDefault<>(OrdenServicioComputadora.class,"buscarPorEstado","estado", estado));
	}
		
	
	@MemberOrder(sequence = "10")
	public List<OrdenServicioComputadora> historial (
			@ParameterLayout(named="Numero de serie")final Computadora comp
			)
	{
		
		return container.allMatches(new QueryDefault<>(OrdenServicioComputadora.class,"buscarPorComputadora","id", comp));
	}
	
	
	   @javax.inject.Inject 
	    DomainObjectContainer container;
}
