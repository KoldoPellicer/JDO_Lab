package es.deusto.ingenieria.sd.jdo.lab;

import java.util.List;

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
				Reserva res2 = new Reserva(2345,"12345678Y",2,"2-02-2018","12:00");
				Reserva res3 = new Reserva(3456,"23456789Z",3,"3-03-2018","14:00");
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
				pm.makePersistent(pag);
				pm.makePersistent(pag2);
				
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
			
			//TODO Falta rellenar para seleccionar algo de una fila de tabla concreta en base a una condici�n
			try {
				
				System.out.println("- Retrieving reserves with code = 2345 using a 'Query'...");			
				//Get the Persistence Manager
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();

				Query<Reserva> query = pm.newQuery(Reserva.class);
				query.setFilter("codigoR==2345");
			
				@SuppressWarnings("unchecked")
				List<Reserva> reservas = (List<Reserva>) query.execute();

				//End the transaction
				tx.commit();
		
				for (Reserva r : reservas) {
					System.out.println(" - " + r.codigoR  + " - " + r.dni  + " - " + r.asiento + " - " + r.fSalida  + " - " + r.hSalida);
				}

			} catch (Exception ex) {
				System.out.println("# Error selecting: " + ex.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
				
				if (pm != null && !pm.isClosed()) {
					pm.close();
				}
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
				System.out.println("# Error deleting: " + ex.getMessage());
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
			
			 //Delete registro
			 Query<Registro> query1 = pm.newQuery(Registro.class);
			 System.out.println(" * '" + query1.deletePersistentAll() + "' Register deleted from the DB.");
			 //Delete vuelo
			 Query<Vuelo> query2 = pm.newQuery(Vuelo.class);
			 System.out.println(" * '" + query2.deletePersistentAll() + "' Flyes deleted from the DB.");
			 //Delete Reserva
			 Query<Reserva> query3 = pm.newQuery(Reserva.class);
			 System.out.println(" * '" + query3.deletePersistentAll() + "' Reserves deleted from the DB.");
			
			 System.out.println("Delete DB content: SUCCESFUL");
			
			 } catch (Exception ex) {
			 System.out.println("# Error cleaning DB: " + ex.getMessage());
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

