package com.trinita.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.trinita.businesscomponent.model.OrdineArticolo;

public class OrdineArticoloDAO extends OrdineArticoloAdapter implements DAOConstants {

	private CachedRowSet rowSet;

	private OrdineArticoloDAO() throws SQLException {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	public static OrdineArticoloDAO getFactory() throws SQLException {
		return new OrdineArticoloDAO();
	}

	@Override
	public void create(Connection conn, OrdineArticolo entity) throws SQLException {
			rowSet.setCommand(SELECT_ORDINEARTICOLO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getIdOrdine());
			rowSet.updateLong(2, entity.getIdArticolo());
			rowSet.updateInt(3, entity.getQuantita());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
	}
}
