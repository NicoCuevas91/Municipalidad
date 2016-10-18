package dominio.servicio;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import dominio.dom.Computadora;
import dominio.dom.Director;
import dominio.dom.Impresora;
import dominio.dom.Sector;

@DomainService
@DomainServiceLayout(menuOrder = "2", named= "Carga de datos")
public class CargaServicio
{
	
	    @MemberOrder(sequence = "1")
		public Computadora cargarComputadora
		(
				 @ParameterLayout(named="Numero de serie")final String nSerie,
				 @ParameterLayout(named="Nombre")final String nombre,
				 @ParameterLayout(named="Detalle")final String detalle,
				 @ParameterLayout(named="Sector")final Sector sector,
				 @ParameterLayout(named="CPU")final String cpu,
				 @ParameterLayout(named="Ram")final String ram,
				 @ParameterLayout(named="Disco")final String disco,
				 @ParameterLayout(named="Sistema Operativo")final String so,
				 @ParameterLayout(named="IP")final String ip,
				 @ParameterLayout(named="Team viewer")final String teamViewer
		)
		{
			final Computadora c= container.newTransientInstance(Computadora.class);
			c.setCpu(cpu);
			c.setDetalle(detalle);
			c.setDisco(disco);
			c.setIp(ip);
			c.setId(nSerie);
			c.setNombre(nombre);
			c.setSistemaOperativo(so);
			c.setRam(ram);
			c.setTeamViewer(teamViewer);
			c.setSector(sector);

			container.persistIfNotAlready(c);
			return c;
		}
	 
	    @MemberOrder(sequence = "2")
	 	public Director cargarDirector
	 	(
	 			@ParameterLayout(named="Nombre") final String nombre,
	 			@ParameterLayout(named="Numero") final String numero,
	 			@ParameterLayout(named="Email") final String email
	 	)
	    {
	    	final Director d = container.newTransientInstance(Director.class);
	    	d.setEmail(email);
	    	d.setNombre(nombre);
	    	d.setNumero(numero);
	    	container.persistIfNotAlready(d);
	 		return d;
	 	}
	    
	    
	    @MemberOrder(sequence = "4")
	    public Sector cargarSector
	    
	    
	    (
	    		@ParameterLayout(named="Nombre") final String nombre,
	    		@ParameterLayout(named="Director") final Director director,
	    		@ParameterLayout(named="Numero") final String numero,
	    		@ParameterLayout(named="Email") final String email
	    		)
	    {
	    	final Sector s= container.newTransientInstance(Sector.class);
	    	s.setDirector(director);
	    	s.setEmail(email);
	    	s.setNombre(nombre);
	    	s.setNumero(numero);
	    	container.persistIfNotAlready(s);
	    	return s;
	    	
	    	
	    }
 
	    
	    @MemberOrder(sequence = "3")
		public Impresora cargarImpresora
		(
				 @ParameterLayout(named="Numero de serie")final String nSerie,
				 @ParameterLayout(named="Nombre")final String nombre,
				 @ParameterLayout(named="Detalle")final String detalle,
				 @ParameterLayout(named="Sector")final Sector sector
		)
		{
			final Impresora c= container.newTransientInstance(Impresora.class);
			c.setDetalle(detalle);
//			c.setnSerie(nSerie);
			c.setNombre(nombre);
			c.setSector(sector);
			container.persistIfNotAlready(c);
			return c;
		}
	 
	 
	   @javax.inject.Inject 
	    DomainObjectContainer container;
	    
	    
}
