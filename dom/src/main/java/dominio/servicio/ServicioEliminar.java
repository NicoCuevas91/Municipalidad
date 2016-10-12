package dominio.servicio;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.ParameterLayout;
import dominio.dom.Computadora;
import dominio.dom.Director;
import dominio.dom.Impresora;
import dominio.dom.Sector;

@DomainService
public class ServicioEliminar {

	public String eliminar (@ParameterLayout(named="Computadora") final Computadora c){
		container.remove(c);
		return "Se elimino correctamente la computadora";
	}
	
	public boolean hideEliminar(@ParameterLayout(named="Computadora") final Computadora c){
		boolean bandera= true;
		if(c != null){
			bandera= false;
		}
		return bandera;
	}
		
	public String eliminar (@ParameterLayout(named="Impresora") final Impresora c){
		container.remove(c);
		return "Se elimino correctamente la computadora";
	}
	
	public boolean hideEliminar(@ParameterLayout(named="Impresora") final Impresora c){
		boolean bandera= true;
		if(c != null){
			bandera= false;
		}
		return bandera;
	}
	
	public String eliminar (@ParameterLayout(named="Director") final Director c){
		container.remove(c);
		return "Se elimino correctamente la computadora";
	}
	
	public boolean hideEliminar(@ParameterLayout(named="Director") final Director c){
		boolean bandera= true;
		if(c != null){
			bandera= false;
		}
		return bandera;
	}
	
	public String eliminar (@ParameterLayout(named="Sector") final Sector c){
		container.remove(c);
		return "Se elimino correctamente la computadora";
	}
	
	public boolean hideEliminar(@ParameterLayout(named="Sector") final Sector c){
		boolean bandera= true;
		if(c != null){
			bandera= false;
		}
		return bandera;
	}
	
	
		
	   @javax.inject.Inject 
	    DomainObjectContainer container;
}
