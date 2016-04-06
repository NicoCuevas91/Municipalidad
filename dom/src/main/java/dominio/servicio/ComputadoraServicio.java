package dominio.servicio;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;

import dominio.dom.Computadora;
import dominio.dom.Sector;

@DomainService(repositoryFor= Computadora.class)
@DomainServiceLayout(menuOrder = "1", named= "Computadora")
public class ComputadoraServicio 
{

    @MemberOrder(sequence = "1")
	public Computadora cargar
	(
			 @ParameterLayout(named="Numero de serie")final String nSerie,
			 @ParameterLayout(named="Nombre")final String nombre,
			 @ParameterLayout(named="Detalle")final String detalle,
			 @ParameterLayout(named="Sector")final Sector sector,
			 @ParameterLayout(named="CPU")final String cpu,
			 @ParameterLayout(named="Ram")final String ram,
			 @ParameterLayout(named="Disco")final String disco,
			 @ParameterLayout(named="IP")final String ip,
			 @ParameterLayout(named="Team viewer")final String teamViewer
	)
	{
		final Computadora c= container.newTransientInstance(Computadora.class);
		c.setCpu(cpu);
		c.setDetalle(detalle);
		c.setDisco(disco);
		c.setIp(ip);
		c.setnSerie(nSerie);
		c.setNombre(nombre);
		c.setRam(ram);
		c.setTeamViewer(teamViewer);
		c.setSector(sector);
		container.persistIfNotAlready(c);
		return c;
	}
	
	
	   @javax.inject.Inject 
	    DomainObjectContainer container;
}
