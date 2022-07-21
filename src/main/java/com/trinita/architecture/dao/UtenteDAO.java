package com.trinita.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.trinita.businesscomponent.model.Utente;
import com.trinita.security.AlgoritmoMD5;

public class UtenteDAO extends UtenteAdapter implements DAOConstants {

	private CachedRowSet rowSet;
	
	private UtenteDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}
	
	public static UtenteDAO getFactory() throws SQLException {
		return new UtenteDAO();
	}
	
	@Override
	public void create(Connection conn, Utente entity) throws SQLException {
		rowSet.setCommand(SELECT_UTENTE);
		rowSet.execute(conn);
		rowSet.moveToInsertRow();
		rowSet.updateString(1, entity.getNome());
		rowSet.updateDate(2, new java.sql.Date(entity.getNascita().getTime()));
		rowSet.updateString(3, entity.getUsername());
		rowSet.updateString(4, AlgoritmoMD5.convertiMD5(entity.getPassword()));
		rowSet.insertRow();
		rowSet.moveToCurrentRow();
		rowSet.acceptChanges();
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
		conn.commit();
	}
	
	
	@Override
	public void delete(Connection conn, long id) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(DELETE_UTENTE);
		ps.setLong(1, id);
		ps.execute();
		conn.commit();
	}
	
	
}
