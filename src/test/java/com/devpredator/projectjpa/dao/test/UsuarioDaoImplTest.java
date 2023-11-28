/**
 * 
 */
package com.devpredator.projectjpa.dao.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devpredator.projectjpa.dao.DisqueraDao;
import com.devpredator.projectjpa.dao.impl.UsuarioDaoImpl;
import com.devpredator.projectjpa.entity.Disquera;

/**
 * 
 */
class UsuarioDaoImplTest {

	private DisqueraDao disqueraDao = new UsuarioDaoImpl();

	/**
	 * Test method for
	 * {@link com.devpredator.projectjpa.dao.impl.UsuarioDaoImpl#consultar(com.devpredator.projectjpa.entity.Disquera)}.
	 */

	@Test
	void testConsultar() {
		List<Disquera> disquerasConsultadas = this.disqueraDao.consultar();
		assertTrue(disquerasConsultadas.size() > 0);

		disquerasConsultadas.forEach(disquera -> {
			System.out.println("Disquera: " + disquera.getDescripcion());
		});
	}

	/**
	 * Test method for
	 * {@link com.devpredator.projectjpa.dao.impl.UsuarioDaoImpl#guardar(com.devpredator.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testGuardar() {
		Disquera disquera = new Disquera();
		disquera.setDescripcion("MegaForce");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);

		this.disqueraDao.guardar(disquera);
	}

	/**
	 * Test method for
	 * {@link com.devpredator.projectjpa.dao.impl.UsuarioDaoImpl#actualizar(com.devpredator.projectjpa.entity.Disquera)}.
	 */

	@Test
	void testActualizar() {
		Disquera disqueraConsultada = this.disqueraDao.consultarById(9L);
		disqueraConsultada.setFechaModificacion(LocalDateTime.now());
		disqueraConsultada.setDescripcion("Dsiquera IronMaiden");
		this.disqueraDao.actualizar(disqueraConsultada);
	}

	/**
	 * Test method for
	 * {@link com.devpredator.projectjpa.dao.impl.UsuarioDaoImpl#eliminar(com.devpredator.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testEliminar() {
		this.disqueraDao.eliminar(16L);
	}

	/**
	 * Test method for
	 * {@link com.devpredator.projectjpa.dao.impl.UsuarioDaoImpl#consultarById(long)}.
	 */
	@Test
	void testConsultarById() {
		Disquera disquera = disqueraDao.consultarById(9L);
		System.out.print("Disquera: " + disquera.getDescripcion());
	}

	@Test
	void testConsultarByDescripcionJPQL() {
		Disquera disqueraConsultada = this.disqueraDao.consultarByDescripcionJPQL("Dsiquera IronMaiden");
		assertNotNull(disqueraConsultada);
		System.out.println("Disquera by Description: " + disqueraConsultada.toString());
	}

	@Test
	void testConsultarByDescripcionNative() {
		Disquera disqueraConsultada = this.disqueraDao.consultarByDescripcionNative("Dsiquera IronMaiden");
		assertNotNull(disqueraConsultada);
		System.out.println("Disquera by Description: " + disqueraConsultada.toString());
	}

}
