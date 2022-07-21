package com.trinita.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.trinita.businesscomponent.model.Ordine;

public class OrdineDAO implements GenericDAO<Ordine>, DAOConstants {

	private CachedRowSet rowSet;

	private OrdineDAO() throws SQLException {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		
	}
	
	public static OrdineDAO getFactory() throws SQLException {
		return new OrdineDAO();
	}

	@Override
	public void create(Connection conn, Ordine entity) throws SQLException {
		rowSet.setCommand(SELECT_ORDINE);
		rowSet.execute(conn);
		rowSet.moveToInsertRow();
		rowSet.updateLong(1, entity.getIdUser());
		rowSet.updateDouble(2, entity.getTotale());
		rowSet.updateDate(3, new java.sql.Date(entity.getData().getTime()));
		rowSet.insertRow();
		rowSet.moveToCurrentRow();
		rowSet.acceptChanges();
	}

	@Override
	public void update(Connection conn, Ordine entity) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(UPDATE_ORDINE);
		ps.setDouble(1, entity.getTotale());
		ps.setDate(2, new java.sql.Date(entity.getData().getTime()));
		ps.setLong(3, entity.getIdUser());
		ps.setLong(4, entity.getIdOrdine());
		ps.execute();
		conn.commit();
	}

	@Override
	public void delete(Connection conn, long id) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(DELETE_ORDINE);
		ps.setLong(1, id);
		ps.execute();
		conn.commit();
		
	}

	@Override
	public Ordine getById(Connection conn, long id) throws SQLException {
		Ordine ordine = null;
		PreparedStatement ps;
		
		ps = conn.prepareStatement(SELECT_ORDINE_BYID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			ordine = new Ordine();
			ordine.setIdOrdine(rs.getLong(1));
			ordine.setTotale(rs.getDouble(2));
			ordine.setData(new java.util.Date(rs.getDate(3).getTime()));
			ordine.setIdUser(rs.getLong(4));
		}
	return ordine;
	}

	@Override
	public Ordine[] getAll(Connection conn) throws SQLException {
		Ordine[] ordini = null;
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_ORDINE);
		rs.last();
		ordini = new Ordine[rs.getRow()];
		rs.beforeFirst();
		for(int i= 0; rs.next(); i++) {
			Ordine o = new Ordine();
			o.setIdOrdine(rs.getLong(1));
			o.setTotale(rs.getDouble(2));
			o.setData(new java.util.Date(rs.getDate(3).getTime()));
			o.setIdUser(rs.getLong(4));
			ordini[i] = o;
		}
		return ordini;
	}
	
	
	
}
