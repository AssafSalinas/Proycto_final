import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultar {

	public static void main(String[] args) {

		Conexion con = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {

			cn = con.Conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("Select * from registro");

			while (rs.next()) {

				
				String No_control = rs.getString(1);
				String Nombre = rs.getString(2);
			
				String Hora_Entrada = rs.getString(3);
				String Hora_salida = rs.getString(4);
				String Fecha = rs.getString(5);
				System.out.println();
				System.out.println( " " + No_control + " " + Nombre + " " + Hora_Entrada + " "
						+ Hora_salida + " " + Fecha);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
