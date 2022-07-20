package com.trinita.conf;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class TemaUI {
	public String getTema() {
		return "arya";
	}
}
