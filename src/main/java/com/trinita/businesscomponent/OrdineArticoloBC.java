package com.trinita.businesscomponent;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.trinita.architecture.dao.OrdineArticoloDAO;
import com.trinita.architecture.dbaccess.DBAccess;
import com.trinita.businesscomponent.model.OrdineArticolo;

public class OrdineArticoloBC {
	private OrdineArticoloDAO oaDAO;

	public OrdineArticoloBC() throws NamingException, SQLException {
		oaDAO = OrdineArticoloDAO.getFactory();
	}

	public void create(OrdineArticolo oa) throws SQLException, NamingException {
		try {
			oaDAO.create(DBAccess.getConnection(), oa);
		} finally {
			DBAccess.closeConnection();
		}
	}
}
