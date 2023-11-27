/**
 * 
 */
package com.devpredator.projectjpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.devpredator.projectjpa.dao.DisqueraDao;
import com.devpredator.projectjpa.entity.Disquera;

/**
 * @author jat_a Clase que implementa las transacciones para la tabla disquera
 */
public class UsuarioDaoImpl implements DisqueraDao {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceDevPredator");;

	@Override
	public void guardar(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();

		try {
			em.persist(disquera);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void actualizar(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();

		try {
			em.merge(disquera);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void eliminar(long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		Disquera disqueraConsultada = em.find(Disquera.class, id);

		EntityTransaction et = em.getTransaction();
		et.begin();

		try {
			em.remove(disqueraConsultada);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public Disquera consultarById(long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		Disquera disqueraConsultado = em.find(Disquera.class, id);
		if (disqueraConsultado == null) {
			throw new EntityNotFoundException("La disquera con id: " + id + " no se encontro.");
		}
		return disqueraConsultado;
	}

	@Override
	public List<Disquera> consultar() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		TypedQuery<Disquera> disqueras = (TypedQuery<Disquera>) em.createQuery("FROM Disquera ORDER BY descripcion");

		return disqueras.getResultList();
	}

}
