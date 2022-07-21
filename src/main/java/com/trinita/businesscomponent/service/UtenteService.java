package com.trinita.businesscomponent.service;

import java.sql.Date;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.trinita.businesscomponent.UtenteBC;
import com.trinita.businesscomponent.model.Utente;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;

@Path("/utenteservice")
public class UtenteService {

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Transactional
	public Utente createUtente(
		@FormParam("nome") String nome,
		@FormParam("nascita") Date nascita,
		@FormParam("username") String username,
		@FormParam("password") String password) throws SQLException, NamingException {
		Utente u = new Utente();
		u.setNome(nome);
		u.setNascita(nascita);
		u.setUsername(username);
		u.setPassword(password);
		UtenteBC uBC = new UtenteBC();
		uBC.create(u);
		return u;
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Transactional
	public Utente updateUtente(
		@FormParam("id_user") long id_user,
		@FormParam("nome") String nome,
		@FormParam("nascita") Date nascita,
		@FormParam("username") String username,
		@FormParam("password") String password) throws SQLException, NamingException {
		Utente u = new Utente();
		u.setId(id_user);
		u.setNome(nome);
		u.setNascita(nascita);
		u.setUsername(username);
		u.setPassword(password);
		UtenteBC uBC = new UtenteBC();
		uBC.update(u);
		return u;
	}
	
	@DELETE
	@Path("/delete/{id_utente}")
	@Produces(MediaType.TEXT_HTML)
	@Transactional
	public String deleteUtente(@PathParam("id_utente") long id_utente) throws NamingException, SQLException {
		UtenteBC uBC = new UtenteBC();
		uBC.delete(id_utente);
		return "<html><head><title>Risposta</title></head><body>Record eliminato correttamente</body></html>";
	}
	
}
