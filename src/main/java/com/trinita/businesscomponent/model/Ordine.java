package com.trinita.businesscomponent.model;

import java.util.Date;

public class Ordine {
	private long idOrdine;
	private double totale;
	private Date data;
	private String username;

	public long getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(long idOrdine) {
		this.idOrdine = idOrdine;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Ordine [idOrdine=" + idOrdine + ", totale=" + totale + ", data=" + data + ", username=" + username
				+ "]";
	}
}
