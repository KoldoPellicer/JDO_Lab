package es.deusto.ingenieria.sd.jdo.lab;

import javax.jdo.annotations.PersistenceCapable;

import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)

public class Reserva {
	
	long codigoR;
	String dni=null;
	int asiento=0;
	String fSalida=null;
	String hSalida=null;
	//TODO Las Joins no están bien, no se cómo se une Reserva con pago y vuelo
	@Join
	Pago pago;
	@Join
	Vuelo vuelo;

	public Reserva(long codigoR, String dni, int asiento, String fSalida, String hSalida) {
		this.codigoR = codigoR;
		this.dni = dni;
		this.asiento = asiento;
		this.fSalida = fSalida;
		this.hSalida = hSalida;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}
	
	public Pago getPago() {
		return pago;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
}
