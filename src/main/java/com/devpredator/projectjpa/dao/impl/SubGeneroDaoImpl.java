/**
 * 
 */
package com.devpredator.projectjpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.devpredator.projectjpa.dao.SubGeneroDao;
import com.devpredator.projectjpa.entity.SubGenero;

/**
 * @author jat_a Clase que implementa el CRUD para las transacciones a la tabla
 *         de subGenero
 */
public class SubGeneroDaoImpl implements SubGeneroDao {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceDevPredator");

	/*
	 * Metodo que permite guardar un subgenero
	 * 
	 * @param subGenero{@link SubGenero} objeto a guardar
	 */
	@Override
	public void guardar(SubGenero subGenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			em.persist(subGenero);
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

	/*
	 * Metodo que permite actualizar un subgenero
	 * 
	 * @param subGenero{@link SubGenero} objeto a actualizar
	 */
	@Override
	public void actualizar(SubGenero subGenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			em.merge(subGenero);
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

	/*
	 * Metodo que permite eliminar un subgenero por su identificador
	 * 
	 * @param subGenero{@link Long} objeto a eliminar
	 */
	@Override
	public void eliminar(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();

		SubGenero subGeneroConsultado = em.find(SubGenero.class, id);

		try {
			et.begin();
			em.remove(subGeneroConsultado);
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

	/*
	 * Metodo que perimite consultar la lista de subgenero
	 * 
	 * @return (@link List} lista de subgeneros consultados
	 */
	@Override
	public List<SubGenero> consultar() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		TypedQuery<SubGenero> queryTyped = (TypedQuery<SubGenero>) em
				.createQuery("FROM SubGenero ORDER BY descripcion");

		return queryTyped.getResultList();
	}

	/*
	 * Metodo que permite consultar un SubGenero a partir de su identificador
	 * 
	 * @param id {@link Long} identificador del subgenero a consultar
	 * 
	 * @return {@link SubGenero} un objeto subgenero consultado
	 */
	@Override
	public SubGenero consultarById(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		return em.find(SubGenero.class, id);
	}

}
