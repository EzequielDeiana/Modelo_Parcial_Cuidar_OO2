package datos;

import java.util.Set;

public class Lugar {
	private int idlugar;
	private String lugar;
	private String codigoPostal;
	private Set<Lugar> desdeHasta; 
	
	public Lugar() {}

	public Lugar(String lugar, String codigoPostal) {
		super();
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
	}

	public int getIdlugar() {
		return idlugar;
	}

	protected void setIdlugar(int id) {
		this.idlugar = id;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	

	public Set<Lugar> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<Lugar> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}

	@Override
	public String toString() {
		return "Lugar [id=" + idlugar + ", lugar=" + lugar + ", codigoPostal=" + codigoPostal + "]";
	}
	
	
	
	
}
