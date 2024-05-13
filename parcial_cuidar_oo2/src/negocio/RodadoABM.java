package negocio;

import java.util.List;

import dao.RodadoDAO;
import datos.Rodado;

public class RodadoABM {
    public static RodadoABM instance;

    private RodadoABM() { 

    }

    public static RodadoABM getInstance() {
        if(instance == null) {
            instance = new RodadoABM();
        }
        return instance;
    }

    public int agregar(Rodado Rodado) {
        return RodadoDAO.getInstance().agregar(Rodado);
    }

    public void modificar(Rodado Rodado) {
        RodadoDAO.getInstance().actualizar(Rodado);
    }

    public Rodado traer(int id) {
        return RodadoDAO.getInstance().traer(id);
    }

    public List<Rodado> traer() {
        return RodadoDAO.getInstance().traer();
    }
}