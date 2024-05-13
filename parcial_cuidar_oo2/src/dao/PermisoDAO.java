package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Permiso;
import datos.PermisoDiario;
import datos.PermisoPeriodo;

public class PermisoDAO {
	protected static Session session;
	protected Transaction transaction;
	public static PermisoDAO instance;

	private PermisoDAO() {
	}

	public static PermisoDAO getInstance() {
		if (instance == null) {
			instance = new PermisoDAO();
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

	public int agregar(Permiso objeto) {
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

	public void actualizar(Permiso objeto) throws HibernateException {
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
	
	public Permiso traer(int idObjeto) throws HibernateException{
		Permiso objeto = null;
		try {
			iniciaOperacion();
			objeto = (Permiso) session.get(Permiso.class, idObjeto);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public PermisoDiario traerPermisoDiario(int idObjeto) throws HibernateException{
		PermisoDiario objeto = null;
		try {
			iniciaOperacion();
			objeto = (PermisoDiario) session.get(PermisoDiario.class, idObjeto);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public PermisoPeriodo traerPermisoPeriodo(int idObjeto) throws HibernateException{
		PermisoPeriodo objeto = null;
		try {
			iniciaOperacion();
			objeto = (PermisoPeriodo) session.get(PermisoPeriodo.class, idObjeto);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Permiso> traer() throws HibernateException{
		List<Permiso> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Permiso").list();
		} finally {
			session.close();
		}
		return lista;
	}

}