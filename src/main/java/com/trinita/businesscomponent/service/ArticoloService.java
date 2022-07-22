package com.trinita.businesscomponent.service;

import java.sql.SQLException;
import java.text.ParseException;

import javax.naming.NamingException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.trinita.businesscomponent.ArticoloBC;
import com.trinita.businesscomponent.model.Articolo;

@Path("/articoloservice")
public class ArticoloService {

	@GET
	@Path("/articoli")
	@Produces(MediaType.APPLICATION_JSON)
	public Articolo[] getArticoli() throws NamingException, SQLException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.getArticoli();
	}
	
	@GET
	@Path("articoli/{id_articolo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Articolo getById(@PathParam("id_articolo") long id_articolo) throws SQLException, NamingException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.getById(id_articolo);
	}
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Articolo createArticolo(Articolo articolo) 
			throws NamingException, SQLException, ParseException {
		ArticoloBC aBC = new ArticoloBC();
		aBC.create(articolo);
		return articolo;
	}
	
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Articolo updateArticolo(Articolo articolo) 
			throws NamingException, SQLException, ParseException {
		ArticoloBC aBC = new ArticoloBC();
		aBC.update(articolo);
		return articolo;
	}
	
	@DELETE
	@Path("/delete/{id_articolo}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public void deleteCliente(@PathParam("id_articolo") long id) 
			throws NamingException, SQLException {
		ArticoloBC aBC = new ArticoloBC();
		aBC.delete(id);
	}
}
