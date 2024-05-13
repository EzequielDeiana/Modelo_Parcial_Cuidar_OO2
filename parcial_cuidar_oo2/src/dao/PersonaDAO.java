package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Persona;

public class PersonaDAO {
	protected static Session session;
	protected Transaction transaction;
	public static PersonaDAO instance;

	private PersonaDAO() {
	}

	public static PersonaDAO getInstance() {
		if (instance == null) {
			instance = new PersonaDAO();
		}
		return instance;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		transaction.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(Persona objeto) {
		int id = 0;

		try {
			iniciaOperacion();
			id = (int) session.save(objeto);
			transaction.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		return id;

	}

	public void actualizar(Persona objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			transaction.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public Persona traer(int idObjeto) throws HibernateException{
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.get(Persona.class, idObjeto);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> traer() throws HibernateException{
		List<Persona> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Persona").list();
		} finally {
			session.close();
		}
		return lista;
	}

}