package es.deusto.ingenieria.sd.jdo.lab;

import javax.jdo.annotations.PersistenceCapable;



import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;

@PersistenceCapable

public class Registro {

	String username = null;
	String pasword = null;
	String email = null;
	@Join
	List<Reserva> reservas = new ArrayList<Reserva>();

	public Registro(String username, String pasword, String email) {

		this.username = username;
		this.pasword = pasword;
		this.email = email;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}
}
