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
}
