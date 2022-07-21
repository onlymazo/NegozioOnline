package com.trinita.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import com.trinita.businesscomponent.model.Articolo;

public class ArticoloDAO implements GenericDAO<Articolo>, DAOConstants {


	private ArticoloDAO() throws SQLException {

	}

	public static ArticoloDAO getFactory() throws SQLException {
		return new ArticoloDAO();
	}

	@Override
	public void create(Connection conn, Articolo entity) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(INSERT_ARTICOLO);
		ps.setString(1, entity.getMarca());
		ps.setString(2, entity.getModello());
		ps.setDouble(3, entity.getPrezzo());
		ps.execute();

	}

	@Override
	public void update(Connection conn, Articolo entity) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(UPDATE_ARTICOLO);
		ps.setString(1, entity.getMarca());
		ps.setString(2, entity.getModello());
		ps.setDouble(3, entity.getPrezzo());
		ps.setLong(4, entity.getIdArticolo());
		ps.execute();
	}

	@Override
	public void delete(Connection conn, long id) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(DELETE_ARTICOLO);
		ps.setLong(1, id);
		ps.execute();
	}

	@Override
	public Articolo getById(Connection conn, long id) throws SQLException {
		Articolo articolo = null;
		PreparedStatement ps;
		ps = conn.prepareStatement(SELECT_ARTICOLO_BYID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			articolo = new Articolo();
			articolo.setIdArticolo(rs.getLong(1));
			articolo.setMarca(rs.getString(2));
			articolo.setModello(rs.getString(3));
			articolo.setPrezzo(rs.getDouble(4));
		}
		return articolo;
	}

	@Override
	public Articolo[] getAll(Connection conn) throws SQLException {
		Articolo[] articoli = null;
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_ARTICOLO);
		rs.last();
		articoli = new Articolo[rs.getRow()];
		rs.beforeFirst();
		for (int i = 0; rs.next(); i++) {
			Articolo a = new Articolo();
			a.setIdArticolo(rs.getLong(1));
			a.setMarca(rs.getString(2));
			a.setModello(rs.getString(3));
			a.setPrezzo(rs.getDouble(4));
			articoli[i] = a;
		}
		rs.close();
		return articoli;
	}
}
