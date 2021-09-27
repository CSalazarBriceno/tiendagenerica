package com.unbosque.DAO;

import com.unbosque.DTO.Cliente;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDAO {
	
	//Creación de los métodos del CRUD
		public ArrayList<Cliente> ListCustomers(){
			ArrayList<Cliente> clientes = new ArrayList<Cliente>();
			Connection connection = new Connection();
			
			try {
				PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM clientes");
				ResultSet result = statement.executeQuery();
				while(result.next()) {
					Cliente cliente = new Cliente();
					cliente.setCedulaCliente(Integer.parseInt(result.getString("cedula_cliente")));
					cliente.setDireccionCliente(result.getString("direccion_cliente"));
					cliente.setEmailCliente(result.getString("email_cliente"));
					cliente.setNombreCliente(result.getString("nombre_cliente"));
					cliente.setTelefonoCliente(result.getString("telefono_cliente"));
					
					clientes.add(cliente);
				}
				result.close();
				statement.close();
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "No es posible realizar la consulta\n" + e);
			}
			return clientes;
		}

		public Cliente saveCustomer(Cliente cliente) {
			Connection connection = new Connection();
			try {
				String query= "INSERT INTO clientes VALUES (?,?,?,?,?)";
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setInt(1, cliente.getCedulaCliente());
				statement.setString(2, cliente.getDireccionCliente());
				statement.setString(3, cliente.getEmailCliente());
				statement.setString(4, cliente.getNombreCliente());
				statement.setString(5, cliente.getTelefonoCliente());
				statement.executeUpdate();
			}catch(SQLException e) {
				e.getMessage();
			}
			return cliente;
		}

		//Busqueda en base de datos, tabla clientes, para buscar un cliente por cedula
		public Cliente readCustomerByID(int cedula) {
			Connection connection = new Connection();
			Cliente cliente = new Cliente();
			try {
				String query= "SELECT * FROM clientes WHERE cedula_cliente=?";
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setInt(1, cedula);
				ResultSet result= statement.executeQuery();
				while(result.next()) {
					cliente.setCedulaCliente(Integer.parseInt(result.getString("cedula_cliente")));
					cliente.setDireccionCliente(result.getString("direccion_cliente"));
					cliente.setEmailCliente(result.getString("email_cliente"));
					cliente.setNombreCliente(result.getString("nombre_cliente"));
					cliente.setTelefonoCliente(result.getString("telefono_cliente"));
				}
				result.close();
				statement.close();
			}catch(SQLException e) {
				e.getMessage();
			}
			return cliente;
		}

		public void updateCustomer(Cliente cliente) {
			Connection connection = new Connection();
			try {
				String query= "UPDATE clientes SET direccion_cliente=?, email_cliente=?, nombre_cliente=?, telefono_cliente=? WHERE cedula_cliente=?";
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setString(1, cliente.getDireccionCliente());
				statement.setString(2, cliente.getEmailCliente());
				statement.setString(3, cliente.getNombreCliente());
				statement.setString(4, cliente.getTelefonoCliente());
				statement.setInt(5, cliente.getCedulaCliente());
				statement.executeUpdate();
			}catch(SQLException e) {
				e.getMessage();
			}
		}

		public void deleteCustomer(int cedula) {
			Connection connection = new Connection();
			try {
				String query= "DELETE FROM clientes WHERE cedula_cliente=?";
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setInt(1, cedula);
				statement.executeUpdate();
			}catch(SQLException e) {
				e.getMessage();
			}		
		}

}
