package com.unbosque.DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	String database="tienda";
	String user="root";
	String password="admin";
	String url= "jdbc:mysql://localhost/"+ database;
	java.sql.Connection connection = null;

	
	public java.sql.Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection(url, user, password);
			if(connection!=null) {
				System.out.println("Conexión exitosa a la base de datos");
			}
		}catch(SQLException e){
			e.getMessage();
		}catch(ClassNotFoundException e) {
			e.getMessage();
		}
		return connection;
	}
	
}
