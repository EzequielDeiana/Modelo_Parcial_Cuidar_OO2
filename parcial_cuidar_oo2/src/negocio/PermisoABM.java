package negocio;

import java.util.List;

import dao.PermisoDAO;
import datos.Permiso;
import datos.PermisoDiario;
import datos.PermisoPeriodo;

public class PermisoABM {
    public static PermisoABM instance;

    private PermisoABM() { 

    }

    public static PermisoABM getInstance() {
        if(instance == null) {
            instance = new PermisoABM();
        }
        return instance;
    }

    public int agregar(Permiso Permiso) {
        return PermisoDAO.getInstance().agregar(Permiso);
    }

    public void modificar(Permiso Permiso) {
        PermisoDAO.getInstance().actualizar(Permiso);
    }

    public Permiso traer(int id) {
        return PermisoDAO.getInstance().traer(id);
    }
    
    public PermisoDiario traerPermisoDiario(int id) {
    	return PermisoDAO.getInstance().traerPermisoDiario(id);
    }
    
    public PermisoPeriodo traerPermisoPeriodo(int id) {
    	return PermisoDAO.getInstance().traerPermisoPeriodo(id);
    }

    public List<Permiso> traer() {
        return PermisoDAO.getInstance().traer();
    }
}