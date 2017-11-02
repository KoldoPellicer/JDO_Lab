package es.deusto.ingenieria.sd.jdo.lab;

import javax.jdo.annotations.PersistenceCapable;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)

public class Vuelo {
	
	String numVuelo=null;;
	int aLibres=0;
	int aTotales=0;
	String origen=null;
	String destino=null;
	String ccompañia=null;

	public Vuelo(String numVuelo, int aLibres, int aTotales, String origen, String destino, String ccompañia) {
		this.numVuelo = numVuelo;
		this.aLibres = aLibres;
		this.aTotales = aTotales;
		this.origen = origen;
		this.destino = destino;
		this.ccompañia = ccompañia;
	}
	
	public int getaLibres() {
		return aLibres;
	}

	public void setaLibres(int aLibres) {
		this.aLibres = aLibres;
	}	
}
