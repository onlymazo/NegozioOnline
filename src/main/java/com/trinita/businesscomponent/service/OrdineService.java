package com.trinita.businesscomponent.service;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

import javax.naming.NamingException;
import javax.transaction.Transactional;
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

import com.trinita.businesscomponent.OrdineBC;
import com.trinita.businesscomponent.model.Ordine;

@Path("/ordineservice")
public class OrdineService {

	@GET
	@Path("/ordini")
	@Produces(MediaType.APPLICATION_JSON)
	public Ordine[] getOrdini() throws NamingException, SQLException {
		OrdineBC oBC = new OrdineBC();
		return oBC.getOrdini();
	}
	
	@GET
	@Path("/ordini/{idOrdine}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ordine getById(@PathParam("idOrdine") long idOrdine) throws SQLException, NamingException {
		OrdineBC pBC = new OrdineBC();
		return pBC.getById(idOrdine);
	}
	
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Transactional
	public Ordine createOrdine(
			@FormParam("id_user") long id_user,
			@FormParam("totale") double totale
			) throws NamingException, SQLException, ParseException {
	Ordine o = new Ordine();
	o.setIdUser(id_user);
	o.setTotale(totale);
	OrdineBC oBC = new OrdineBC();
	oBC.create(o);
	return o;
	}
	
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Transactional
	public Ordine updateOrdine(
			@FormParam("id_ordine") long idOrdine,
			@FormParam("id_user") long id_user,
			@FormParam("totale") double totale,
			@FormParam("data") Date data) throws NamingException, SQLException, ParseException {
	Ordine o = new Ordine();
	o.setIdOrdine(idOrdine);
	o.setIdUser(id_user);
	o.setTotale(totale);
	o.setData(data);
	OrdineBC oBC = new OrdineBC();
	oBC.update(o);
	return o;
	}
	
	@DELETE
	@Path("/delete/{id_ordine}")
	@Produces(MediaType.TEXT_HTML)
	@Transactional
	public String deleteOrdine(@PathParam("id_ordine") long id_ordine) throws NamingException, SQLException {
		OrdineBC oBC = new OrdineBC();
		oBC.delete(id_ordine);
		return "<html><head><title>Risposta</title></head><body>Record eliminato correttamente</body></html>";

	}
	
}
