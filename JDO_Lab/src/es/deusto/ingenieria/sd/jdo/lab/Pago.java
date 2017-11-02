package es.deusto.ingenieria.sd.jdo.lab;

import javax.jdo.annotations.PersistenceCapable;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)

class Pago {
	
	String numTarjeta=null;
	double precio=0.0;
	Reserva reserva;

	public Pago(String numTarjeta, double precio) {
		this.numTarjeta = numTarjeta;
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
