package br.com.softblue.java.jdbc.aula12_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			if (conn == null) {
				conn = DriverManager.getConnection("jdbc:mysql://localhost/produtos", "root", "718nigga");
				System.out.println("Conectou");
				stmt = conn.prepareStatement("SELECT * FROM produto");
				rset = stmt.executeQuery();

				while (rset.next()) {
					System.out.println("Id = " + rset.getInt("id") + ", Item = " + rset.getString("nome"));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			conn.close();
			stmt.close();
			rset.close();
			System.out.println("Fechou, carai");
		}
	}

}
