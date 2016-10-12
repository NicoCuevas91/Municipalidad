package dominio.servicio;


import java.util.Date;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import dominio.dom.Computadora;
import dominio.dom.serv.Estado;
import dominio.dom.serv.OrdenServicioComputadora;

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
			@ParameterLayout(named="Tecnico") final String tecnico
			)
	{
		OrdenServicioComputadora os = container.newTransientInstance(OrdenServicioComputadora.class);
		
		os.setCausa(causa);
		os.setId(id);
		os.setEstado(Estado.Ingreso);
		os.setTecnico(tecnico);
		os.setFechaIngreso(fechaIngreso);
		os.setComputadora(computadora);
		
		container.persistIfNotAlready(os);
		
		return os;
	}

	
	
	
	
	   @javax.inject.Inject 
	    DomainObjectContainer container;
}
