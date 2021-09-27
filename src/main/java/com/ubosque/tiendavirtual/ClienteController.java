package com.ubosque.tiendavirtual;
import com.unbosque.DAO.ClienteDAO;
import com.unbosque.DTO.Cliente;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/Clientes")
public class ClienteController {
	ClienteDAO clienteDAO = new ClienteDAO();
	
	@RequestMapping("/Lista")
	public ArrayList<Cliente> listaCliente(){
		return clienteDAO.ListCustomers();
	}
	
	//HTTP = HyperText transfer Protocol. CRUD 
	//Create = Post
	@PostMapping
	public Cliente createCustomer() {
		Cliente cliente = new Cliente();
		cliente.setCedulaCliente(2);
		cliente.setDireccionCliente("calle2");
		cliente.setEmailCliente("cliente2@prueba.com");
		cliente.setNombreCliente("cliente2");
		cliente.setTelefonoCliente("234");
		clienteDAO.saveCustomer(cliente);
		return cliente;
	}
	
	
	//Read = Get
	@GetMapping(value="{cedula}")
	public Cliente customerByID(@PathVariable("cedula") int cedula) {
		return clienteDAO.readCustomerByID(cedula);
	}
	
	
	//Update = Put
	@PutMapping
	public Cliente updateCustomer() {
		Cliente cliente = new Cliente();
		cliente.setCedulaCliente(2);
		cliente.setDireccionCliente("calle2mod");
		cliente.setEmailCliente("cliente2mod@prueba.com");
		cliente.setNombreCliente("cliente2mod");
		cliente.setTelefonoCliente("234mod");
		clienteDAO.updateCustomer(cliente);
		return cliente;
	}
	
	//Delete = Delete
	@DeleteMapping(value="{cedula}")
	public void deleteCustomer(@PathVariable("cedula") int cedula) {
		clienteDAO.deleteCustomer(cedula);
	}

}
