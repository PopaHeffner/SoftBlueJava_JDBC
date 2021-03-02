package br.com.softblue.java.jdbc.aula12_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		String itens[] = { "Arroz", "Feijão", "Carne", "Batata", "Farinha" };

		try {
			if (conn == null) {
				conn = DriverManager.getConnection("jdbc:mysql://localhost/produtos", "root", "718nigga");
				System.out.println("Conectou");
				stmt = conn.prepareStatement("INSERT INTO produto (nome) VALUES (?)");

				for (String item : itens) {
					stmt.setString(1, item);
				}

				int linhas = stmt.executeUpdate();

				System.out.println("Linhas afetadas: " + linhas);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			conn.close();
			stmt.close();
			System.out.println("Fechou carai");
		}
	}

}
