package dominio.servicio;

import java.util.ArrayList;
import java.util.List;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.query.QueryDefault;
import dominio.dom.Computadora;
import dominio.dom.Director;
import dominio.dom.Impresora;
import dominio.dom.Sector;
import dominio.dom.serv.Informe;

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
	
	public List<Computadora> computadorasPorSector (final Sector a){
		return container.allMatches(new QueryDefault<>(Computadora.class,"buscarPorSector","sector", a));
	}
	public List<Informe> cantidadDeMaquinas(){
		List<Informe> informe = new ArrayList<>();
		List<Computadora> compus = container.allInstances(Computadora.class);
//		int aux= 0;
		
		Informe total= new Informe();
		total.setSector("Total");
		total.setCantidad(compus.size());
		
		Informe auxI = null;
		List<Sector> sectores = container.allInstances(Sector.class);
		for (Sector s: sectores){
			auxI= new Informe();
			auxI.setSector(s.getNombre());
			compus = container.allMatches(new QueryDefault<>(Computadora.class,"buscarPorSector","sector", s));
			auxI.setCantidad(compus.size());
			informe.add(auxI);
		}		
		
		informe.add(total);
		return informe;
	}
	
	
	   @javax.inject.Inject 
	    DomainObjectContainer container;
}
