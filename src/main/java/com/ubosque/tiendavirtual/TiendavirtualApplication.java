package com.ubosque.tiendavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unbosque.DAO.Connection;

@SpringBootApplication
public class TiendavirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendavirtualApplication.class, args);
		Connection connection = new Connection();
		connection.getConnection();
	}

}
