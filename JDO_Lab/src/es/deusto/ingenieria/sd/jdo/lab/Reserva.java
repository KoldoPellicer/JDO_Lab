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
		this.FSalida = FSalida;
		this.HSalida = HSalida;
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


	public String getfSalida() {
		return FSalida;
	}


	public void setfSalida(String FSalida) {
		this.FSalida = FSalida;
	}


	public String gethSalida() {
		return HSalida;
	}


	public void sethSalida(String HSalida) {
		this.HSalida = HSalida;
	}


	public Pago getPago() {
		return pago;
	}


	public void setPago(Pago pago) {
		this.pago = pago;
	}
}
