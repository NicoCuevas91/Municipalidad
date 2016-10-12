package dominio.servicio;

import java.util.List;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import dominio.dom.Computadora;
import dominio.dom.Director;
import dominio.dom.Impresora;
import dominio.dom.Sector;

@DomainService
@DomainServiceLayout(menuOrder = "3", named= "Consulas")
public class ConsultaServicio {


	public List<Director> listarDirectores()
	{
		return container.allInstances(Director.class);
	}
	
	public List<Sector> listarSector(){
		return container.allInstances(Sector.class);
	}
	
	public List<Computadora> listarComputadoras(){
		return container.allInstances(Computadora.class);
	}
	
	public List<Impresora> listarImpresoras(){
		return container.allInstances(Impresora.class);
	}
	
	public Computadora buscarComputadora(final Computadora a){
	return a;
	}
	
	
	   @javax.inject.Inject 
	    DomainObjectContainer container;
}
