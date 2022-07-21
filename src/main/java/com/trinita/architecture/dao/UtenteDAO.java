package com.trinita.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import com.trinita.businesscomponent.model.Utente;
import com.trinita.security.AlgoritmoMD5;

public class UtenteDAO extends UtenteAdapter implements DAOConstants {

	
	private UtenteDAO() throws SQLException {
	}
	
	public static UtenteDAO getFactory() throws SQLException {
		return new UtenteDAO();
	}
	
	@Override
	public void create(Connection conn, Utente entity) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(INSERT_UTENTE);
		ps.setString(1, entity.getNome());
		ps.setDate(2, new java.sql.Date(entity.getNascita().getTime()));
		ps.setString(3, entity.getUsername());
		ps.setString(4, AlgoritmoMD5.convertiMD5(entity.getPassword()));
		ps.execute();
	
	}
	
	@Override
	public void update(Connection conn, Utente entity) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(UPDATE_UTENTE);
		ps.setString(1, entity.getNome());
		ps.setDate(2, new java.sql.Date(entity.getNascita().getTime()));
		ps.setString(3, entity.getUsername());
		ps.setString(4, AlgoritmoMD5.convertiMD5(entity.getPassword()));
		ps.setLong(5, entity.getId());
		ps.execute();
	}
	
	
	@Override
	public void delete(Connection conn, long id) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(DELETE_UTENTE);
		ps.setLong(1, id);
		ps.execute();
	}
	
	
}
