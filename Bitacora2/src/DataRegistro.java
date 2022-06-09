import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DataRegistro {

	private static final String controlador = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/bitacora";
	private static final String usuario = "root";
	private static final String clave = "";
	Variables var = new Variables();

	static {
		try {
			Class.forName(controlador);
			System.out.println("Se encontro el controlador");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection Conector() {
		Connection Conector = null;
		try {
			Conector = DriverManager.getConnection(url, usuario, clave);
			System.out.println("Se encontro la base de datos");

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Conexion fallida");

		}
		return Conector;
	}

	public Variables insertarRegistro() {
		DataRegistro conexion = new DataRegistro();
		Connection cn = null;
		PreparedStatement pstm = null;

		try {
			cn = conexion.Conector();
			String query = "INSERT INTO registro VALUES(?,?,?,?,?)";
			pstm = cn.prepareStatement(query);
			pstm.setString(1, Variables.ncon);
			pstm.setString(2, Variables.nom);
			pstm.setString(3, Variables.hre);
			pstm.setString(4, Variables.hrs);
			pstm.setString(5, Variables.fecha);
			pstm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro guardado");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Registro no guardado");
			e.printStackTrace();
		}
		return var;

	}

	public Variables eliminarRegistro() {
		DataRegistro conexion = new DataRegistro();
		Connection cn = null;
		PreparedStatement pstm = null;

		try {
			cn = conexion.Conector();
			String buscar = JOptionPane.showInputDialog(null, "Buscar Registro");
			String query = "DELETE FROM registro WHERE No_Control=? ";
			pstm = cn.prepareStatement(query);
			pstm.setString(1, buscar);
			pstm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Se borro exitosamente");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se encontro");
			e.printStackTrace();
		}
		return var;

	}

	public Variables consultarRegistro() {
		DataRegistro conexion = new DataRegistro();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = conexion.Conector();

			String buscar = JOptionPane.showInputDialog(null, "Consultar Registro");
			String query = "SELECT * FROM registro WHERE No_Control=? ";
			pstm = cn.prepareStatement(query);
			pstm.setString(1, buscar);
			rs = pstm.executeQuery();
			while (rs.next()) {

				Variables.ncon = rs.getString(1);
				Variables.nom = rs.getString(2);
				Variables.hre = rs.getString(3);
				Variables.hrs = rs.getString(4);
				Variables.fecha = rs.getString(5);

				System.out.println(Variables.ncon + " " + Variables.nom + " " + Variables.hre + " " + Variables.hrs
						+ " " + Variables.fecha);
			}
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "No se encontro");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return var;

	}

	public Variables modificarRegistro() {
		DataRegistro conexion = new DataRegistro();
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = conexion.Conector();

			String query = "UPDATE `registro` SET `No_Control`= '" + Variables.ncon + "',`Nombre`= '" + Variables.nom
					+ "',`Hora_Entrada`='" + Variables.hre + "',`Hora_Salida`='" + Variables.hrs + "',`Fecha`='"
					+ Variables.fecha + "' WHERE No_ControL = '" + Variables.ncon + "'";
			pstm = cn.prepareStatement(query);
			pstm.executeUpdate();
			JOptionPane.showMessageDialog(null, " se pudo actualizar");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "no se pudo actualizar");
			e.printStackTrace();
		}
		return var;

	}

	public static void main(String[] args) {
		DataRegistro a = new DataRegistro();
		a.Conector();
	}

}
