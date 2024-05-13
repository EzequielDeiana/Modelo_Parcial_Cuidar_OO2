package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Lugar;

public class LugarDAO {
	protected static Session session;
	protected Transaction transaction;
	public static LugarDAO instance;

	private LugarDAO() {
	}

	public static LugarDAO getInstance() {
		if (instance == null) {
			instance = new LugarDAO();
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

	public int agregar(Lugar objeto) {
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

	public void actualizar(Lugar objeto) throws HibernateException {
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
	
	public Lugar traer(int idObjeto) throws HibernateException{
		Lugar objeto = null;
		try {
			iniciaOperacion();
			objeto = (Lugar) session.get(Lugar.class, idObjeto);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lugar> traer() throws HibernateException{
		List<Lugar> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Lugar").list();
		} finally {
			session.close();
		}
		return lista;
	}

}
