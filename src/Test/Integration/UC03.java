package Test.Integration;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import Presentation.TerminaleGestore.GestoreAutenticatoClientLipe;
import Presentation.TerminaleGestore.InterfacciaGestoreAutenticato;
import Server.DAO.PopulateTestDatabase;
import Server.DAO.StazioneDAO;
import Server.RMIInterface.Autovettura;

public class UC03 {
	
	private Server.DAO.BatteriaDAO inserita;
	private int idStazione;
	
	@After
	public void tearDown() throws Exception {
		
		if (inserita != null) {
			StazioneDAO s = new StazioneDAO();
			s = s.getStazione(this.idStazione);
			s.deleteBatteria(this.inserita);
		}
			
	}

	@Test
	public void TC01() {
		final String idTest = "TC01";
		this.idStazione = 2;
		final int idBatteria = 6;
		final float costo = 10.21f;
		final int cicli = 14;
		final int indiceAutovettura = 6;
		final int idModello = 43;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			ArrayList<? extends Autovettura> modelli = client.retrieveListaModelli();
			
			assertFalse(idTest + " riuscito", modelli.isEmpty() );
			
			assertTrue(idTest + " riuscito", client.addBatteria(idBatteria, costo, cicli, indiceAutovettura) );
			
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		inserita = PopulateTestDatabase.testStazione(idStazione, idBatteria, cicli, costo, idModello);
		
		assertNotEquals (idTest + " riuscito", null, inserita);
			
	}
	
	@Test
	public void TC02() {
		final String idTest = "TC02";
		this.idStazione = 2;
		final int idBatteria = 0;
		final float costo = 8.25f;
		final int cicli = 5;
		final int indiceAutovettura = 6;
		final int idModello = 43;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			ArrayList<? extends Autovettura> modelli = client.retrieveListaModelli();
			
			assertNotEquals(idTest + " riuscito", true, modelli.isEmpty() );
			
			
			assertEquals(idTest + " riuscito", true, client.addBatteria(idBatteria, costo, cicli, indiceAutovettura) );
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		inserita = PopulateTestDatabase.testStazione(idStazione, idBatteria, cicli, costo, idModello);
		
		assertNotEquals (idTest + " riuscito", null, inserita);
			
	}
	
	@Test
	public void TC03() {
		final String idTest = "TC03";
		this.idStazione = 2;
		final int idBatteria = 4;
		final float costo = 6.50f;
		final int cicli = 2;
		final int indiceAutovettura = 6;
		final int idModello = 43;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			ArrayList<? extends Autovettura> modelli = client.retrieveListaModelli();
			
			assertNotEquals(idTest + " riuscito", true, modelli.isEmpty() );
			
			
			assertEquals(idTest + " riuscito", true, client.addBatteria(idBatteria, costo, cicli, indiceAutovettura) );
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		inserita = PopulateTestDatabase.testStazione(idStazione, idBatteria, cicli, costo, idModello);
		
		assertNotEquals (idTest + " riuscito", null, inserita);
			
	}
	
	@Test
	public void TC04() {
		final String idTest = "TC04";
		this.idStazione = 2;
		final int idBatteria = 15;
		final float costo = 5.00f;
		final int cicli = 1;
		final int indiceAutovettura = 6;
		final int idModello = 43;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			ArrayList<? extends Autovettura> modelli = client.retrieveListaModelli();
			
			assertNotEquals(idTest + " riuscito", true, modelli.isEmpty() );
			
			
			assertEquals(idTest + " riuscito", true, client.addBatteria(idBatteria, costo, cicli, indiceAutovettura) );
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		inserita = PopulateTestDatabase.testStazione(idStazione, idBatteria, cicli, costo, idModello);
		
		assertNotEquals (idTest + " riuscito", null, inserita);
			
	}

	
	@SuppressWarnings("unused")
	@Test
	public void TC05() {
		final String idTest = "TC05";
		final int idStazione = 9;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
	
			fail(idTest + " riuscito");
		} catch (Exception e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void TC09() {
		final String idTest = "TC09";
		this.idStazione = 2;
		final int idBatteria = 21;
		final float costo = 10.00f;
		final int cicli = 30;
		final int indiceAutovettura = 6;
		final int idModello = 43;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			ArrayList<? extends Autovettura> modelli = client.retrieveListaModelli();
			
			assertNotEquals(idTest + " riuscito", true, modelli.isEmpty() );
			
			assertNotEquals(idTest + " riuscito", true,  client.addBatteria(idBatteria, costo, cicli, indiceAutovettura) );

		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		System.err.println("prima del testStazione");
		
		inserita = PopulateTestDatabase.testStazione(idStazione, idBatteria, cicli, costo, idModello);
		
		System.err.println("dopo il testStazione");
		
		assertEquals (idTest + " riuscito", null, inserita);
			
	}
	
	@Test
	public void TC10() {
		final String idTest = "TC10";
		this.idStazione = 2;
		final int idBatteria = 22;
		final float costo = 8.00f;
		final int cicli = 3;
		final int indiceAutovettura = 6;
		final int idModello = 43;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			ArrayList<? extends Autovettura> modelli = client.retrieveListaModelli();
			
			assertNotEquals(idTest + " riuscito", true, modelli.isEmpty() );
			
			assertNotEquals(idTest + " riuscito", true, client.addBatteria(idBatteria, costo, cicli, indiceAutovettura) ); 

		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		inserita = PopulateTestDatabase.testStazione(idStazione, idBatteria, cicli, costo, idModello);
		
		assertEquals (idTest + " riuscito", null, inserita);
			
	}

}
