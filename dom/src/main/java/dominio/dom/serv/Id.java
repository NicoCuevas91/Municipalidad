package dominio.dom.serv;

import javax.jdo.annotations.PersistenceCapable;



@PersistenceCapable
public class Id {

	private String id;
	private int codigo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
}
