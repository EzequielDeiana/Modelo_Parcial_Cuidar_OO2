package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Rodado;

public class RodadoDAO {
	protected static Session session;
	protected Transaction transaction;
	public static RodadoDAO instance;

	private RodadoDAO() {
	}

	public static RodadoDAO getInstance() {
		if (instance == null) {
			instance = new RodadoDAO();
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

	public int agregar(Rodado objeto) {
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

	public void actualizar(Rodado objeto) throws HibernateException {
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
	
	public Rodado traer(int idObjeto) throws HibernateException{
		Rodado objeto = null;
		try {
			iniciaOperacion();
			objeto = (Rodado) session.get(Rodado.class, idObjeto);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rodado> traer() throws HibernateException{
		List<Rodado> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Rodado").list();
		} finally {
			session.close();
		}
		return lista;
	}

}