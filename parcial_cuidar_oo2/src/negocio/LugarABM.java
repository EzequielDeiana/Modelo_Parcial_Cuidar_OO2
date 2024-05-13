package negocio;

import java.util.List;

import dao.LugarDAO;
import datos.Lugar;

public class LugarABM {
    public static LugarABM instance;

    private LugarABM() { 

    }

    public static LugarABM getInstance() {
        if(instance == null) {
            instance = new LugarABM();
        }
        return instance;
    }

    public int agregar(Lugar Lugar) {
        return LugarDAO.getInstance().agregar(Lugar);
    }

    public void modificar(Lugar Lugar) {
        LugarDAO.getInstance().actualizar(Lugar);
    }

    public Lugar traer(int id) {
        return LugarDAO.getInstance().traer(id);
    }

    public List<Lugar> traer() {
        return LugarDAO.getInstance().traer();
    }
}