package datos;

import java.util.Set;

public class Persona {
	private int idpersona;
	private String nombre;
	private String apellido;
	private double dni;
	private Set<Permiso> permisos;
	
	public Persona() {}

	public Persona(String nombre, String apellido, double dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public int getIdpersona() {
		return idpersona;
	}

	protected void setIdpersona(int id) {
		this.idpersona = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getDni() {
		return dni;
	}

	public void setDni(double dni) {
		this.dni = dni;
	}

	public Set<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}

	@Override
	public String toString() {
		return "Persona [id=" + idpersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}
	
	
	
}
