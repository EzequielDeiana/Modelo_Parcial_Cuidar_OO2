package datos;

import java.time.LocalDate;

public class PermisoPeriodo extends Permiso{
	private int cantDias;
	private boolean vacaciones;
	private Rodado rodado;
	
	public PermisoPeriodo() {}

	public PermisoPeriodo(int cantDias, boolean vacaciones, Rodado rodado) {
		super();
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.rodado = rodado;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public boolean isVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(boolean vacaciones) {
		this.vacaciones = vacaciones;
	}

	public Rodado getRodado() {
		return rodado;
	}

	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}

	@Override
	public String toString() {
		return "PermisoPeriodo [" + super.toString() +  "cantDias=" + cantDias + ", vacaciones=" + vacaciones + "]";
	}
	
	@Override
	public boolean activo(LocalDate dia) {
		LocalDate fechaFinal = super.fecha.plusDays(cantDias);
		
		if((dia.isAfter(super.fecha) || dia.equals(super.fecha))
				 && (dia.equals(fechaFinal) || dia.isBefore(fechaFinal))) {
			return true;
		}
		
		return false;
	}
	
	
}
