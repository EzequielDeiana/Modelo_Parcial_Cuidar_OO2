package datos;

import java.time.LocalDate;
import java.util.Set;

public class PermisoDiario extends Permiso{
	private String motivo;
	
	public PermisoDiario() {}

	public PermisoDiario(String motivo, Persona pedido, LocalDate fecha) {
		super(pedido, fecha);
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "PermisoDiario [" + super.toString() + "motivo=" + motivo + "]";
	}
	
	@Override
	public boolean activo(LocalDate dia) {
		return dia.equals(this.fecha);
	}
	
}
