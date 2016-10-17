package dominio.servicio;


import java.util.Date;
import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
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
			@ParameterLayout(named="Fecha ingreso") final Date fechaIngreso,
			@ParameterLayout(named="Causa") final String causa,
			@ParameterLayout(named="Tecnico") final Tecnicos tecnico,
			@ParameterLayout(named="Ingresa con cables") final boolean cables
			)
	{
		OrdenServicioComputadora os = container.newTransientInstance(OrdenServicioComputadora.class);
		
		os.setCausa(causa);
		os.setId(id);
		os.setEstado(Estado.Ingreso);
		os.setTecnico(tecnico);
		os.setFechaIngreso(fechaIngreso);
		os.setComputadora(computadora);
		os.setCables(cables);
		
		container.persistIfNotAlready(os);
		
		return os;
	}
	
	@MemberOrder(sequence = "2")
	public List<OrdenServicioComputadora> listarOrdenesDeServicios(){
		List<OrdenServicioComputadora> salida = container.allInstances(OrdenServicioComputadora.class);
		return salida;
	}
	
	@MemberOrder(sequence = "2")
	public List<OrdenServicioComputadora> listarOrdenesDeServiciosPorEstado(
			@ParameterLayout(named="Estado") final Estado estado
			){
		List<OrdenServicioComputadora> salida = container.allInstances(OrdenServicioComputadora.class);
		for(OrdenServicioComputadora a:salida){
			if(!a.getEstado().equals(estado)){
				salida.remove(a);
			}
		}		
		return salida;
	}
	
	
	   @javax.inject.Inject 
	    DomainObjectContainer container;
}
