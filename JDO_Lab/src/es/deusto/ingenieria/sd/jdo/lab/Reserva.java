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
	String FSalida=null;
	String HSalida=null;
	Pago pago;
	
	public Reserva(long codigoR, String dni, int asiento, String fSalida, String hSalida) {
		this.codigoR = codigoR;
		this.dni = dni;
		this.asiento = asiento;
		FSalida = fSalida;
		HSalida = hSalida;
	}

	public long getCodigoR() {
		return codigoR;
	}

	public void setCodigoR(long codigoR) {
		this.codigoR = codigoR;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getAsiento() {
		return asiento;
	}

	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}

	public String getFSalida() {
		return FSalida;
	}

	public void setFSalida(String fSalida) {
		FSalida = fSalida;
	}

	public String getHSalida() {
		return HSalida;
	}

	public void setHSalida(String hSalida) {
		HSalida = hSalida;
	}
}
