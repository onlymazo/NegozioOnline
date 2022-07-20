package com.trinita.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface GenericDAO<T> {
	void create(Connection conn, T entity) throws SQLException;
	void update(Connection conn, T entity) throws SQLException;
	void delete(Connection conn, long id) throws SQLException;
	T getById(Connection conn, long id) throws SQLException;
	T [] getAll(Connection conn) throws SQLException;

}
