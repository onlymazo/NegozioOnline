package com.trinita.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.trinita.businesscomponent.model.OrdineArticolo;

public abstract class OrdineArticoloAdapter implements GenericDAO<OrdineArticolo>{

	@Override
	public void create(Connection conn, OrdineArticolo entity) throws SQLException {
	}

	@Override
	public void update(Connection conn, OrdineArticolo entity) throws SQLException {
	}

	@Override
	public void delete(Connection conn, long id) throws SQLException {	
	}

	@Override
	public OrdineArticolo getById(Connection conn, long id) throws SQLException {
		return null;
	}

	@Override
	public OrdineArticolo[] getAll(Connection conn) throws SQLException {
		return null;
	}
}
