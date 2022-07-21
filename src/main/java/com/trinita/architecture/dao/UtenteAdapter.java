package com.trinita.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.trinita.businesscomponent.model.Utente;

public abstract class UtenteAdapter implements GenericDAO<Utente> {

	@Override
	public void create(Connection conn, Utente entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection conn, Utente entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utente getById(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente[] getAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
