package negocio;

import java.util.List;

import dao.PersonaDAO;
import datos.Persona;

public class PersonaABM {
    public static PersonaABM instance;

    private PersonaABM() { 

    }

    public static PersonaABM getInstance() {
        if(instance == null) {
            instance = new PersonaABM();
        }
        return instance;
    }

    public int agregar(Persona Persona) {
        return PersonaDAO.getInstance().agregar(Persona);
    }

    public void modificar(Persona Persona) {
        PersonaDAO.getInstance().actualizar(Persona);
    }

    public Persona traer(int id) {
        return PersonaDAO.getInstance().traer(id);
    }

    public List<Persona> traer() {
        return PersonaDAO.getInstance().traer();
    }
}