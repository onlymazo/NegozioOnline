package com.trinita.businesscomponent.model;

public class Amministratore {
	private long id_admin;
	private String username;
	private String password;
	
	public long getId_admin() {
		return id_admin;
	}
	public void setId_admin(long id_admin) {
		this.id_admin = id_admin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Amministratore [username=" + username + ", password=" + password + "]";
	}
	
	

}
