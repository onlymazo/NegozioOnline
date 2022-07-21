package com.trinita.businesscomponent;

import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;

import com.trinita.architecture.dao.OrdineDAO;
import com.trinita.architecture.dbaccess.DBAccess;
import com.trinita.businesscomponent.model.Ordine;

public class OrdineBC {
	private OrdineDAO oDAO;
	
	public OrdineBC() throws NamingException, SQLException {
		oDAO = OrdineDAO.getFactory();
	}
	
	public void create(Ordine ordine) throws NamingException, SQLException {
		try {
			ordine.setData(new Date());
			oDAO.create(DBAccess.getConnection(), ordine);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public void update(Ordine ordine) throws SQLException, NamingException {
		try {
			oDAO.update(DBAccess.getConnection(), ordine);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public void delete(long idOrdine) throws SQLException, NamingException {
		try {
			oDAO.delete(DBAccess.getConnection(), idOrdine);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public Ordine getById(long idOrdine) throws SQLException, NamingException {
		try {
			return oDAO.getById(DBAccess.getConnection(), idOrdine);
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public Ordine[] getOrdini() throws SQLException, NamingException {
		try {
			return oDAO.getAll(DBAccess.getConnection());
		} finally {
			DBAccess.closeConnection();
		}
	}
	
}
