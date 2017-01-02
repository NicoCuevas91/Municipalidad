package dominio.servicio;

import java.util.ArrayList;
import java.util.List;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.CollectionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.query.QueryDefault;
import dominio.dom.Computadora;
import dominio.dom.Director;
import dominio.dom.Impresora;
import dominio.dom.Router;
import dominio.dom.Sector;
import dominio.dom.serv.Informe;

@DomainService
@DomainServiceLayout(menuOrder = "3", named= "Consultas")
public class ConsultaServicio {



	public List<Director> listarDirectores()
	{
		return container.allInstances(Director.class);
	}
	
	public List<Sector> listarSector(){
		return container.allInstances(Sector.class);
	}
	@CollectionLayout
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
	
	public List<Impresora> impresorasPorSector (final Sector a){
		return container.allMatches(new QueryDefault<>(Impresora.class,"buscarPorSector","sector", a));
	}
	
	public List<Informe> cantidadDeMaquinas(){
		List<Informe> informe = new ArrayList<>();
		List<Computadora> compus = container.allInstances(Computadora.class);
		
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
	
	public List<Informe> cantidadDeImpresoras(){
		List<Informe> informe = new ArrayList<>();
		List<Impresora> impresora = container.allInstances(Impresora.class);
		
		Informe total= new Informe();
		total.setSector("Total");
		total.setCantidad(impresora.size());
		
		Informe auxI = null;
		List<Sector> sectores = container.allInstances(Sector.class);
		for (Sector s: sectores){
			auxI= new Informe();
			auxI.setSector(s.getNombre());
			impresora = container.allMatches(new QueryDefault<>(Impresora.class,"buscarPorSector","sector", s));
			auxI.setCantidad(impresora.size());
			informe.add(auxI);
		}		
		
		informe.add(total);
		return informe;
	}

	public List<Router> listarRouters(){
		return container.allInstances(Router.class);
	}
	
	   @javax.inject.Inject 
	   DomainObjectContainer container;
}
