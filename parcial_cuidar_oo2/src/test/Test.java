package test;

import java.time.LocalDate;

import datos.PermisoDiario;
import datos.Persona;
import datos.Rodado;
import negocio.PermisoABM;
import negocio.PersonaABM;
import negocio.RodadoABM;

public class Test {

	public static void main(String[] args) {
		
		System.out.println(PersonaABM.getInstance().traer(2));
		
		System.out.println(PermisoABM.getInstance().traerPermisoDiario(3));
		
		System.out.println(PermisoABM.getInstance().traer(3).activo(LocalDate.of(2021, 04, 18)));
		
		System.out.println(PermisoABM.getInstance().traer(3).activo(LocalDate.of(2021, 04, 19)));
		
		System.out.println(PermisoABM.getInstance().traerPermisoPeriodo(4));
		
		System.out.println(PermisoABM.getInstance().traer(4).activo(LocalDate.of(2021, 04, 25)));
		
		System.out.println(PermisoABM.getInstance().traer(4).activo(LocalDate.of(2021, 05, 2)));
		
		System.out.println(PermisoABM.getInstance().traer(4).activo(LocalDate.of(2021, 05, 16)));
		
	}

}
