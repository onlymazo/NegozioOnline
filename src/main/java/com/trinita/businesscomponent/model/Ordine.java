package com.trinita.businesscomponent.model;

import java.util.Date;

public class Ordine {
	private long idOrdine;
	private double totale;
	private Date data;
	private long id_user;

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

	public long getIdUser() {
		return id_user;
	}

	public void setIdUser(long id_user) {
		this.id_user = id_user;
	}

	@Override
	public String toString() {
		return "Ordine [idOrdine=" + idOrdine + ", totale=" + totale + ", data=" + data + ", id_user=" + id_user
				+ "]";
	}
}
