package com.trinita.businesscomponent;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.trinita.architecture.dao.UtenteDAO;
import com.trinita.architecture.dbaccess.DBAccess;
import com.trinita.businesscomponent.model.Utente;

public class UtenteBC {
	private UtenteDAO uDAO;

	public UtenteBC() throws NamingException, SQLException {
		uDAO = UtenteDAO.getFactory();
	}

	public void create(Utente u) throws SQLException, NamingException {
		try {
			uDAO.create(DBAccess.getConnection(), u);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void delete(long id) throws SQLException, NamingException {
		try {
			uDAO.delete(DBAccess.getConnection(), id);
		} finally {
			DBAccess.closeConnection();
		}
	}
}
