package com.trinita.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.trinita.businesscomponent.model.Ordine;

public class OrdineDAO implements GenericDAO<Ordine>, DAOConstants {


	private OrdineDAO() throws SQLException {
		
	}
	
	public static OrdineDAO getFactory() throws SQLException {
		return new OrdineDAO();
	}

	@Override
	public void create(Connection conn, Ordine entity) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(INSERT_ORDINE);
		ps.setLong(1, entity.getIdUser());
		ps.setDouble(2, entity.getTotale());
		ps.setDate(3, new java.sql.Date(entity.getData().getTime()));
		ps.execute();
	}

	@Override
	public void update(Connection conn, Ordine entity) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(UPDATE_ORDINE);
		ps.setLong(1, entity.getIdUser());
		ps.setDouble(2, entity.getTotale());
		ps.setDate(3, new java.sql.Date(entity.getData().getTime()));
		ps.setLong(4, entity.getIdOrdine());
		ps.execute();
	}

	@Override
	public void delete(Connection conn, long id) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(DELETE_ORDINE);
		ps.setLong(1, id);
		ps.execute();
		
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
			ordine.setIdUser(rs.getLong(2));
			ordine.setTotale(rs.getDouble(3));
			ordine.setData(new java.util.Date(rs.getDate(4).getTime()));
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
			o.setIdUser(rs.getLong(2));
			o.setTotale(rs.getDouble(3));
			o.setData(new java.util.Date(rs.getDate(4).getTime()));
			ordini[i] = o;
		}
		return ordini;
	}
	
	
	
}
