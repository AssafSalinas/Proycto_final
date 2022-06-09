import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataRegistroTest {

	@Test
	void testConector() {
		//fail("Not yet implemented");
}

	@Test
	void testInsertarRegistro() {
		//fail("Not yet implemented");
		DataRegistro conexion =new DataRegistro();
		Variables var = conexion.insertarRegistro();
		assertNotNull(var);
	}

	@Test
	void testEliminarRegistro() {
		//fail("Not yet implemented");
		DataRegistro conexion =new DataRegistro();
		Variables var = conexion.eliminarRegistro();
		assertNotNull(var);
	}

	@Test
	void testConsultarRegistro() {
		
	//fail("Not yet implemented");
		DataRegistro conexion =new DataRegistro();
		Variables var = conexion.consultarRegistro();
		assertNotNull(var);
	}

	@Test
	void testModificarRegistro() {
	DataRegistro conexion =new DataRegistro();
		Variables var = conexion.modificarRegistro();
		assertNotNull(var);
	//fail("Not yet implemented");
	}

}
