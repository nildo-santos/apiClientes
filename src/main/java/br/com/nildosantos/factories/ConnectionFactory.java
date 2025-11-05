package br.com.nildosantos.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	/*
	 * Método para retornar uma conexão com 
	 * um banco de dados do PostgreSQL
	 */
	public Connection getConnection() throws Exception {
		
		var host = "jdbc:postgresql://localhost:5432/bd_apiClientes";
		var user = "postgres";
		var pass = "coti";
		
		return DriverManager.getConnection(host, user, pass);
	}
}