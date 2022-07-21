package com.trinita.businesscomponent.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.trinita.businesscomponent.ArticoloBC;
import com.trinita.businesscomponent.model.Articolo;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.transaction.Transactional;

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
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Articolo createArticolo(
			@FormParam("marca") String marca,
			@FormParam("modello") String modello,
			@FormParam("prezzo") double prezzo ) throws SQLException, NamingException {
	Articolo a = new Articolo();
	a.setMarca(marca);
	a.setModello(modello);
	a.setPrezzo(prezzo);
	ArticoloBC aBC = new ArticoloBC();
	aBC.create(a);
	return a;
	}
	
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Transactional
	public Articolo updateArticolo(
			@FormParam("id_articolo") long idArticolo,
			@FormParam("marca") String marca,
			@FormParam("modello") String modello,
			@FormParam("prezzo") double prezzo ) throws SQLException, NamingException {
	Articolo a = new Articolo();
	a.setIdArticolo(idArticolo);
	a.setMarca(marca);
	a.setModello(modello);
	a.setPrezzo(prezzo);
	ArticoloBC aBC = new ArticoloBC();
	aBC.update(a);
	return a;
	}
	
	@DELETE
	@Path("/delete/{id_articolo}")
	@Produces(MediaType.TEXT_HTML)
	@Transactional
	public String deleteArticolo(@PathParam("id_articolo") long id_articolo) throws NamingException, SQLException {
		ArticoloBC aBC = new ArticoloBC();
		aBC.delete(id_articolo);
		return "<html><head><title>Risposta</title></head><body>Record eliminato correttamente</body></html>";
	}
}
