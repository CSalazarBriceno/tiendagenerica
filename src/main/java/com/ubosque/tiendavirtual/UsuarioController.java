package com.ubosque.tiendavirtual;
import com.unbosque.DAO.UsuarioDAO;
import com.unbosque.DTO.Usuario;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/Usuarios")
public class UsuarioController {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	
	@RequestMapping("/Lista") //Esta es la API
	public ArrayList<Usuario> listaUsuario(){
		return usuarioDAO.ListUsers();
	}
	
	//HTTP = HyperText transfer Protocol. CRUD 
	//Create = Post
	@PostMapping
	public Usuario createUser() {
		Usuario usuario = new Usuario();
		usuario.setCedulaUsuario(0);
		usuario.setEmailUsuario("usuario@prueba.com");
		usuario.setNombreUsuario("usuario");
		usuario.setPassword("admin123456");
		usuario.setUsuario("admininicial");
		usuarioDAO.saveUser(usuario);
		return usuario;
	}
	
	
	//Read = Get
	@GetMapping(value="{cedula}")
	public Usuario userByID(@PathVariable("cedula") int cedula) {
		return usuarioDAO.readUserByID(cedula);
	}
	
	
	//Update = Put
	@PutMapping
	public Usuario updateUser() {
		Usuario usuario = new Usuario();
		usuario.setCedulaUsuario(2);
		usuario.setEmailUsuario("usuario2mod@prueba.com");
		usuario.setNombreUsuario("usuario2mod");
		usuario.setPassword("234mod");
		usuario.setUsuario("usuario2mod");
		usuarioDAO.updateUser(usuario);
		return usuario;
	}
	
	//Delete = Delete
	@DeleteMapping(value="{cedula}")
	public void deleteUser(@PathVariable("cedula") int cedula) {
		usuarioDAO.deleteUser(cedula);
	}
}
