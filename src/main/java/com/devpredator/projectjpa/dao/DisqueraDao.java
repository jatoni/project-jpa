/**
 * 
 */
package com.devpredator.projectjpa.dao;

import java.util.List;

import com.devpredator.projectjpa.entity.Disquera;

/**
 * @author jat_a Interface que genera el dao para las transacciones del crud a
 *         la tabla de disquera
 */
public interface DisqueraDao {

	List<Disquera> consultar();

	void guardar(Disquera disquera);

	void actualizar(Disquera disquera);

	void eliminar(long id);

	Disquera consultarById(long id);

	/*
	 * Meotodo que permite consultar con JPQL la disquera a partir de una
	 * descripcion.
	 * 
	 * @param descripcion {@link String} descripcion de la disquera
	 * 
	 * @return {@link Disquera} la disquera consultada
	 */

	Disquera consultarByDescripcionJPQL(String descripcion);

	/*
	 * Metodo que permite consultar con SQL Nativo la disquera a partir de una
	 * descripcion.
	 * 
	 * @Param descripcion
	 * 
	 * @return {@link Disquera} la disquera consultada
	 */
	Disquera consultarByDescripcionNative(String descripcion);
}
