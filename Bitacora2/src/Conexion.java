import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String url = "jdbc:mysql://localhost:3306/bitacora";
	private static final String root = "root";
	private static final String controlador = "com.mysql.cj.jdbc.Driver";
	private static final String password = "";
	private static final String greet = "true";

	static {
		try {
			Class.forName(controlador);
			System.out.println("El controlador se cargo exitosamente");

		}

		catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}

	public Connection Conectar() {

		Connection Conectar = null;

		try {
			Conectar = DriverManager.getConnection(url, root, password);
			System.out.println();
			System.out.println(greet);

		} catch (SQLException e) {
			System.out.println("Consulta no exitosa");
			e.printStackTrace();

		}
		return Conectar;

	}

}
