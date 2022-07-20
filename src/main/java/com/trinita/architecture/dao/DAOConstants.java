package com.trinita.architecture.dao;

public interface DAOConstants {
	String SELECT_UTENTE = "select * from utente";
	String INSERT_UTENTE = "insert into utente(nome,nascita,username,password) values(?,?,?,?)";
	String UPDATE_UTENTE = "update utente set nome=?, nascita=?, username=?, password=? where id_user=?";
	String DELETE_UTENTE = "delete from utente where id_user=?";
	String SELECT_UTENTE_BYID = "select * from utente where id_user=?";
	
	String SELECT_ARTICOLO = "select * from articolo";
	String INSERT_ARTICOLO = "insert into articolo(marca,modello,prezzo) values(?,?,?)";
	String UPDATE_ARTICOLO = "update articolo set marca=?, modello=?, prezzo=? where id_articolo=?";
	String DELETE_ARTICOLO = "delete from articolo where id_articolo=?";
	String SELECT_ARTICOLO_BYID = "select * from articolo where id_articolo=?";
	
	String SELECT_ORDINE = "select * from ordine";
	String INSERT_ORDINE = "insert into ordine(id_user,totale,data) values(?,?,?)";
	String UPDATE_ORDINE = "update ordine set id_user=?, totale=?, data=? where id_ordine=?";
	String DELETE_ORDINE = "delete from ordine where id_ordine=?";
	String SELECT_ORDINE_BYID = "select * from ordine where id_ordine=?";
	
	String SELECT_ORDINEARTICOLO = "select * from ordine_articolo";
	
}
