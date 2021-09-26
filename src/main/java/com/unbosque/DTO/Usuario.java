package com.unbosque.DTO;

public class Usuario {
	// Atributos de la clase
	private int cedulaUsuario;
	private String emailUsuario;
	private String nombreUsuario;
	private String password;
	private String usuario;
	
	//Métodos Getter and Setter
	public int getCedulaUsuario() {
		return cedulaUsuario;
	}
	public void setCedulaUsuario(int cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
