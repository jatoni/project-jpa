/**
 * 
 */
package com.devpredator.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devpredator.projectjpa.dao.SubGeneroDao;
import com.devpredator.projectjpa.dao.impl.SubGeneroDaoImpl;
import com.devpredator.projectjpa.entity.Genero;
import com.devpredator.projectjpa.entity.SubGenero;

/**
 * @author jat_a Clase TEST para comprobar el funcionamiento de los metodos de
 *         CRUD de subgenero
 */
class SubGeneroDaoImplTest {

	private SubGeneroDao subGeneroDao = new SubGeneroDaoImpl();

	/**
	 * Test method for
	 * {@link com.devpredator.projectjpa.dao.impl.SubGeneroDaoImpl#guardar(com.devpredator.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testGuardar() {
		SubGenero subGenero = new SubGenero();
		subGenero.setDescripcion("Rock Nuevo");
		subGenero.setFechaCreacion(LocalDateTime.now());
		subGenero.setEstatus(true);

		Genero genero = new Genero();
		genero.setDescripcion("Metal");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);

		subGenero.setGenero(genero);

		this.subGeneroDao.guardar(subGenero);
	}

	/**
	 * Test method for
	 * {@link com.devpredator.projectjpa.dao.impl.SubGeneroDaoImpl#actualizar(com.devpredator.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testActualizar() {
		SubGenero subGeneroConsultado = this.subGeneroDao.consultarById(7L);
		subGeneroConsultado.setDescripcion("Trash Metal update");
		subGeneroConsultado.getGenero().setDescripcion("Metal Trash update");
		this.subGeneroDao.actualizar(subGeneroConsultado);
	}

	/**
	 * Test method for
	 * {@link com.devpredator.projectjpa.dao.impl.SubGeneroDaoImpl#eliminar(java.lang.Long)}.
	 */
	@Test
	void testEliminar() {
		this.subGeneroDao.eliminar(8L);
	}

	/**
	 * Test method for
	 * {@link com.devpredator.projectjpa.dao.impl.SubGeneroDaoImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<SubGenero> subGeneroConsultados = this.subGeneroDao.consultar();
		assertTrue(subGeneroConsultados.size() > 0);
		subGeneroConsultados.forEach(subGenero -> {
			System.out.println("Subgenero: " + subGenero.getDescripcion());
			System.out.println("Genero: " + subGenero.getGenero().getDescripcion());
		});
	}

	/**
	 * Test method for
	 * {@link com.devpredator.projectjpa.dao.impl.SubGeneroDaoImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		fail("Not yet implemented");
	}

}
