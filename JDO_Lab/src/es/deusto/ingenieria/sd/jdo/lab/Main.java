package es.deusto.ingenieria.sd.jdo.lab;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class Main {

	public static void main(String[] args) {
		
		try {
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
	
			Transaction tx = pm.currentTransaction();
			
			try {	
				Registro reg = new Registro("Ariane","1234","ariane.fernandez@opendeusto.es");		
				Reserva res = new Reserva(0123,"01234567X",1,"1-01-2018","11:00");
				Reserva res2 = new Reserva(2345,"12345678Y",1,"2-02-2018","12:00");
				Reserva res3 = new Reserva(2345,"23456789Z",1,"3-03-2018","14:00");
				Vuelo vue = new Vuelo("AB1234",150,500,"Bilbao","Londres","CD01234");
				Vuelo vue2 = new Vuelo("CD2345",200,400,"Londres","Bilbao","EF23456");
				Pago pag = new Pago("0123-4567-8901-2345",250);
				Pago pag2 = new Pago("0123-4567-8901-2345",300);
				reg.getReservas().add(res);	
				reg.getReservas().add(res2);	
				vue.getReservas().add(res);
				vue.getReservas().add(res2);
				vue.getReservas().add(res3);
				
				
				tx.begin();
				System.out.println("Inserting contents into the database ....");
				
				//Hace las inserts correspondientes
				pm.makePersistent(reg);
				pm.makePersistent(vue);
				pm.makePersistent(vue2);
				pm.makePersistent(pag2);
				pm.makePersistent(reg);
				
				System.out.println("Inserting contents into the database: SUCCESFUL");
				tx.commit();
			} catch (Exception ex) {
				System.out.println("# Error storing objects: " + ex.getMessage());				
			} finally {
				if (tx.isActive()) {
					tx.rollback();
				}
				
				pm.close();
			}			
			
			pm = pmf.getPersistenceManager();			
			tx = pm.currentTransaction();
			
			try {
				
				System.out.println("Showing Flyes...");
				
			    tx.begin();
			    //Me permite almacenar todos los objetos de una sola clase, recupera todo  el contenido de una db
			    Extent<Vuelo> extentV = pm.getExtent(Vuelo.class);
				int cont = 0;
				
				//Saca por pantalla los valores
			    for (Vuelo v : extentV) {
			    	System.out.println((cont++) + " - " + v.aLibres  + " - " + v.aTotales  + " - " + v.ccompanya  + " - " + v.destino  + " - " + v.numVuelo  + " - " + v.origen);
			    }

			    tx.commit();
			} catch (Exception ex) {
				System.out.println("# Error getting Extent: " + ex.getMessage());
			} finally {
			    if (tx.isActive()) {
			        tx.rollback();
			    }
	
			    pm.close();
			}
			
			pm = pmf.getPersistenceManager();			
			tx = pm.currentTransaction();
			
			// Borra todo el contenido de la DB
			try {
				
				System.out.println("Deleting DB content...");
				
				Extent<Pago> extentP = pm.getExtent(Pago.class);
				
				for (Pago pago : extentP) {
				    pm.deletePersistent(pago);	
				}
				
				Extent<Registro> extentR = pm.getExtent(Registro.class);
				
				for (Registro registro : extentR) {
				    pm.deletePersistent(registro);	
				}		
				
				Query<Registro> query1 = pm.newQuery(Registro.class);
				System.out.println(" * '" + query1.deletePersistentAll() + "' Register deleted from the DB.");
				//Delete addresses from DB
				Query<Vuelo> query2 = pm.newQuery(Vuelo.class);
				System.out.println(" * '" + query2.deletePersistentAll() + "' Flyes deleted from the DB.");
				
				System.out.println("Delete DB content: SUCCESFUL");

			} catch (Exception ex) {
				System.out.println("# Error cleaning DB: " + ex.getMessage());
			} finally {
			    if (tx.isActive()) {
			        tx.rollback();
			    }
	
			    pm.close();
			}
			
			pm = pmf.getPersistenceManager();			
			tx = pm.currentTransaction();
			
			//TODO Falta rellenar para seleccionar algo de una fila de tabla concreta en base a una condici�n
			try {


			} catch (Exception ex) {
				System.out.println("# Error deleting: " + ex.getMessage());
			} finally {
			    if (tx.isActive()) {
			        tx.rollback();
			    }
	
			    pm.close();
			}
			
			pm = pmf.getPersistenceManager();			
			tx = pm.currentTransaction();
			
			// TODO Falta rellenar para actualizar una fila de tabla concreta en base a una condici�n
			try {


			} catch (Exception ex) {
				System.out.println("# Error updating: " + ex.getMessage());
			} finally {
			    if (tx.isActive()) {
			        tx.rollback();
			    }
	
			    pm.close();
			}
			
			// TODO Falta rellenar para borrar una fila de tabla concreta en base a una condici�n
			try {


			} catch (Exception ex) {
				System.out.println("# Error updating: " + ex.getMessage());
			} finally {
			    if (tx.isActive()) {
			        tx.rollback();
			    }
	
			    pm.close();
			}
			
			// Cierre del primer try
			} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}		
	}
}

