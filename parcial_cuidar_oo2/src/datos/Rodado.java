package datos;

import java.util.Set;

public class Rodado {
	private int idrodado;
	private String dominio;
	private String vehiculo;
	private Set<PermisoPeriodo> permisosPeriodo;
	
	public Rodado() {}

	public Rodado(String dominio, String vehiculo) {
		super();
		this.dominio = dominio;
		this.vehiculo = vehiculo;
	}

	public int getIdrodado() {
		return idrodado;
	}

	protected void setIdrodado(int id) {
		this.idrodado = id;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Set<PermisoPeriodo> getPermisosPeriodo() {
		return permisosPeriodo;
	}

	public void setPermisosPeriodo(Set<PermisoPeriodo> permisosPeriodo) {
		this.permisosPeriodo = permisosPeriodo;
	}

	@Override
	public String toString() {
		return "Rodado [id=" + idrodado + ", dominio=" + dominio + ", vehiculo=" + vehiculo + "]";
	}
	
	
	
}
