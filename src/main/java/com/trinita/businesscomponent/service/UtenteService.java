package com.trinita.businesscomponent.service;

import java.sql.SQLException;
import java.text.ParseException;

import javax.naming.NamingException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.trinita.businesscomponent.UtenteBC;
import com.trinita.businesscomponent.model.Utente;

@Path("/utenteservice")
public class UtenteService {

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Utente createUtente(Utente utente) 
			throws NamingException, SQLException, ParseException {
		UtenteBC uBC = new UtenteBC();
		uBC.create(utente);
		return utente;
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Utente updateUtente(Utente utente) 
			throws NamingException, SQLException, ParseException {
		UtenteBC uBC = new UtenteBC();
		uBC.update(utente);
		return utente;
	}
	
	@DELETE
	@Path("/delete/{id_user}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public void deleteUtente(@PathParam("id_user") long id) 
			throws NamingException, SQLException {
		UtenteBC uBC = new UtenteBC();
		uBC.delete(id);
	}	
}
