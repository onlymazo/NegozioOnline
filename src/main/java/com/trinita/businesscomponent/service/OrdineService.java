package com.trinita.businesscomponent.service;

import java.sql.SQLException;
import java.text.ParseException;

import javax.naming.NamingException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	@Path("/pianeta/{idOrdine}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ordine getById(@PathParam("idOrdine") long idOrdine) throws SQLException, NamingException {
		OrdineBC pBC = new OrdineBC();
		return pBC.getById(idOrdine);
	}
	
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Ordine createOrdine(Ordine ordine) throws NamingException, SQLException, ParseException {
		OrdineBC oBC = new OrdineBC();
		oBC.create(ordine);
		return ordine;
	}
}
