package br.com.ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ConexaoMySQL {
	
	public static String status = "Sem conexão!";
	protected String server;
	protected String user;
	protected String password;
	protected String database;
	protected String data;
	protected String query;
	protected String totalDados;
	protected String driverName;
	protected String url;
	protected Connection connection;
	
	public ConexaoMySQL() {
		this.server = "localhost";
		this.user = "root";
		this.password = "q1w2e3r4";
		this.database = "javanet";
		this.driverName = "com.mysql.jdbc.Driver";
		this.url = "jdbc:mysql://" + this.server + "/" + this.database;
		
		conectar();
	}
	
	void conectar() {
		
		try {
			Class.forName(driverName);
			
			this.connection = DriverManager.getConnection(this.url, this.user, this.password);
			
			if(this.connection != null) {
				status = ("Conexão realizada com sucesso!");
			} else {
				status = ("Não foi possível realizar conexão!");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("O driver expecificado não foi encontrado.");
		} catch (SQLException e) {
			System.out.println("Não foi possível conectar ao banco de dados.");
		}
	}
	
	boolean executarSQL(List<String> sql) {
		
		try {
			Statement stmt = this.connection.createStatement();
			
			for(String command : sql) {
				stmt.addBatch(command);
			}
			
			stmt.executeBatch();
			stmt.close();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}