package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Material;

public class MaterialDAO {

	/**
	 * recupera todos los materiales de la bbdd ordenados por id descendente
	 * 
	 * @return si no existen registros se devuelve un new ArrayList<Material>()
	 */
	public ArrayList<Material> getAll() {

		ArrayList<Material> lista = new ArrayList<Material>();

		final String URL = "jdbc:mysql://192.168.0.42:3306/spoty";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {

			conn = DriverManager.getConnection(URL, "alumno", "alumno");
			String sql = "SELECT id, nombre, precio FROM material;";

			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			Material m = null;
			while (rs.next()) {
				m = new Material();

				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setPrecio(rs.getFloat("precio"));

				lista.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null) {
					rs.close();
				}

				if (pst != null) {
					pst.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lista;
	}

}
