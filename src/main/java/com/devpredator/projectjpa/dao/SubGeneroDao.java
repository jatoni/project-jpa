/**
 * 
 */
package com.devpredator.projectjpa.dao;

import java.util.List;

import com.devpredator.projectjpa.entity.SubGenero;

/**
 * @author jat_a Interface DAO que realiza el CRUD con JPA para la tabla de
 *         disquera
 */
public interface SubGeneroDao {

	void guardar(SubGenero subGenero);

	void actualizar(SubGenero subGenero);

	void eliminar(Long id);

	List<SubGenero> consultar();

	SubGenero consultarById(Long id);
}
