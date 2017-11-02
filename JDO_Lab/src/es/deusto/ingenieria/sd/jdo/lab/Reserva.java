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
	Pago pago;
	
	
	public Reserva(long codigoR, String dni, int asiento, String fSalida, String hSalida) {
		this.codigoR = codigoR;
		this.dni = dni;
		this.asiento = asiento;
		this.fSalida = fSalida;
		this.hSalida = hSalida;
	}
}
