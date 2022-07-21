package com.trinita.businesscomponent;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.trinita.architecture.dao.ArticoloDAO;
import com.trinita.architecture.dbaccess.DBAccess;
import com.trinita.businesscomponent.model.Articolo;

public class ArticoloBC {
	private ArticoloDAO aDAO;

	public ArticoloBC() throws NamingException, SQLException {
		aDAO = ArticoloDAO.getFactory();
	}

	public Articolo[] getArticoli() throws SQLException, NamingException {
		try {
			return aDAO.getAll(DBAccess.getConnection());
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void create(Articolo a) throws SQLException, NamingException {
		try {
			aDAO.create(DBAccess.getConnection(), a);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void update(Articolo a) throws SQLException, NamingException {
		try {
			aDAO.update(DBAccess.getConnection(), a);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void delete(long id) throws SQLException, NamingException {
		try {
			aDAO.delete(DBAccess.getConnection(), id);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public Articolo getById(long id) throws SQLException, NamingException {
		try {
			return aDAO.getById(DBAccess.getConnection(), id);
		} finally {
			DBAccess.closeConnection();
		}
	}
}