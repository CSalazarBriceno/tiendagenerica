package com.unbosque.DAO;
import com.unbosque.DTO.Proveedor;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProveedorDAO {
	//Creación de los métodos del CRUD
		public ArrayList<Proveedor> ListProviders(){
			ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
			Connection connection = new Connection();
			
			try {
				PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM proveedores");
				ResultSet result = statement.executeQuery();
				while(result.next()) {
					Proveedor proveedor = new Proveedor();
					proveedor.setNitProveedor(Integer.parseInt(result.getString("nitproveedor")));
					proveedor.setCiudadProveedor(result.getString("ciudad_proveedor"));
					proveedor.setDireccionProveedor(result.getString("direccion_proveedor"));
					proveedor.setNombreProveedor(result.getString("nombre_proveedor"));
					proveedor.setTelefonoProveedor(result.getString("telefono_proveedor"));
					
					proveedores.add(proveedor);
				}
				result.close();
				statement.close();
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "No es posible realizar la consulta\n" + e);
			}
			return proveedores;
		}

		public Proveedor saveProvider(Proveedor proveedor) {
			Connection connection = new Connection();
			try {
				String query= "INSERT INTO proveedores VALUES (?,?,?,?,?)";
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setInt(1, proveedor.getNitProveedor());
				statement.setString(2, proveedor.getCiudadProveedor());
				statement.setString(3, proveedor.getDireccionProveedor());
				statement.setString(4, proveedor.getNombreProveedor());
				statement.setString(5, proveedor.getTelefonoProveedor());
				statement.executeUpdate();
			}catch(SQLException e) {
				e.getMessage();
			}
			return proveedor;
		}

		//Busqueda en base de datos, tabla proveedores, para buscar un proveedor por Nit
		public Proveedor readProviderByNit(int nit) {
			Connection connection = new Connection();
			Proveedor proveedor = new Proveedor();
			try {
				String query= "SELECT * FROM proveedores WHERE nitproveedor=?";
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setInt(1, nit);
				ResultSet result= statement.executeQuery();
				while(result.next()) {
					proveedor.setNitProveedor(Integer.parseInt(result.getString("nitproveedor")));
					proveedor.setCiudadProveedor(result.getString("ciudad_proveedor"));
					proveedor.setDireccionProveedor(result.getString("direccion_proveedor"));
					proveedor.setNombreProveedor(result.getString("nombre_proveedor"));
					proveedor.setTelefonoProveedor(result.getString("telefono_proveedor"));
				}
				result.close();
				statement.close();
			}catch(SQLException e) {
				e.getMessage();
			}
			return proveedor;
		}

		public void updateProvider(Proveedor proveedor) {
			Connection connection = new Connection();
			try {
				String query= "UPDATE proveedores SET ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor=?, telefono_proveedor=? WHERE nitproveedor=?";
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setString(1, proveedor.getCiudadProveedor());
				statement.setString(2, proveedor.getDireccionProveedor());
				statement.setString(3, proveedor.getNombreProveedor());
				statement.setString(4, proveedor.getTelefonoProveedor());
				statement.setInt(5, proveedor.getNitProveedor());
				statement.executeUpdate();
			}catch(SQLException e) {
				e.getMessage();
			}
		}

		public void deleteProvider(int nit) {
			Connection connection = new Connection();
			try {
				String query= "DELETE FROM proveedores WHERE nitproveedor=?";
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setInt(1, nit);
				statement.executeUpdate();
			}catch(SQLException e) {
				e.getMessage();
			}		
		}

}
