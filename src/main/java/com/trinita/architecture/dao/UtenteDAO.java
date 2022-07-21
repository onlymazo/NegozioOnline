package com.trinita.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import com.trinita.businesscomponent.model.Utente;
import com.trinita.security.AlgoritmoMD5;

public class UtenteDAO extends UtenteAdapter implements DAOConstants {
	private Statement stmt;
	private ResultSet rs;
	
	private UtenteDAO() throws SQLException {
	}
	
	public static UtenteDAO getFactory() throws SQLException {
		return new UtenteDAO();
	}
	
	@Override
	public void create(Connection conn, Utente entity) throws SQLException {
		stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(SELECT_UTENTE);
		
		if(entity != null) {
			rs.moveToInsertRow();
			rs.updateLong(1, entity.getId());
			rs.updateString(2, entity.getNome());
			rs.updateDate(3, new java.sql.Date(entity.getNascita().getTime()));
			rs.updateString(4, entity.getUsername());
			rs.updateString(5, AlgoritmoMD5.convertiMD5(entity.getPassword()));
			rs.insertRow();
		}
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
