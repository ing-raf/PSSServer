package Test.Integration;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Presentation.TerminaleGestore.GestoreAutenticatoClientLipe;
import Presentation.TerminaleGestore.InterfacciaGestoreAutenticato;
import Server.RMIInterface.Autovettura;
import Server.RMIInterface.Stazione;

public class UC05 {

	private String host = "localhost";
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void TC01() {
		
		final String idTest = "TC01";
		final int idStazione = 3;
		final int indiceModello = 0;
		final String[] nomeStazione = {"Stazione Centrale"};
		final String[] indirizzoStazione = {"Piazzale Tecchio"};
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, this.host);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		ArrayList<Stazione> stazioni = new ArrayList<Stazione>();
		
		try {
			ArrayList<? extends Autovettura> modelli = client.retrieveModelList();
			
			assertNotEquals(idTest + " riuscito", true, modelli.isEmpty() );
			
			stazioni = (ArrayList<Stazione>) client.remoteRetrieveCompatibleBatteries(indiceModello);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}

		assertNotEquals(idTest + " riuscito", true, stazioni.isEmpty() );
		
		assertEquals(idTest + " riuscito", nomeStazione[0], stazioni.get(0).getName() );
		assertEquals(idTest + " riuscito", indirizzoStazione[0], stazioni.get(0).getAddress() );
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void TC02() {
		
		final String idTest = "TC02";
		final int idStazione = 3;
		final int indiceModello = 4;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, this.host);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		ArrayList<Stazione> stazioni = new ArrayList<Stazione>();
		
		try {
			ArrayList<? extends Autovettura> modelli = client.retrieveModelList();
			
			assertNotEquals(idTest + " riuscito", true, modelli.isEmpty() );
			
			stazioni = (ArrayList<Stazione>) client.remoteRetrieveCompatibleBatteries(indiceModello);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		assertEquals(idTest + " riuscito", true, stazioni.isEmpty() );
		
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void TC03() {
		
		final String idTest = "TC03";
		final int idStazione = 3;
		final int indiceModello = 5;
		final String[] nomeStazione = {"Stazione Agnoli"};
		final String[] indirizzoStazione = {"Via Nuova Agnano"};
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, this.host);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		ArrayList<Stazione> stazioni = new ArrayList<Stazione>();
		
		try {
			ArrayList<? extends Autovettura> modelli = client.retrieveModelList();
			
			assertNotEquals(idTest + " riuscito", true, modelli.isEmpty() );
			
			stazioni = (ArrayList<Stazione>) client.remoteRetrieveCompatibleBatteries(indiceModello);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		assertNotEquals(idTest + " riuscito", true, stazioni.isEmpty() );
		
		assertEquals(idTest + " riuscito", nomeStazione[0], stazioni.get(0).getName() );
		assertEquals(idTest + " riuscito", indirizzoStazione[0], stazioni.get(0).getAddress() );
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void TC04() {
		
		final String idTest = "TC04";
		final int idStazione = 1;
		final int indiceModello = 0;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, this.host);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		ArrayList<Stazione> stazioni = new ArrayList<Stazione>();
		
		try {
			ArrayList<? extends Autovettura> modelli = client.retrieveModelList();
			
			assertNotEquals(idTest + " riuscito", true, modelli.isEmpty() );
			
			stazioni = (ArrayList<Stazione>) client.remoteRetrieveCompatibleBatteries(indiceModello);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		assertEquals(idTest + " riuscito", true, stazioni.isEmpty() );
		
	}
	
	@SuppressWarnings("unused")
	@Test
	public void TC05() {
		
		final String idTest = "TC05";
		final int idStazione = 9;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, this.host);
			
			fail(idTest + " riuscito");
		} catch (Exception e) {
			assertTrue(true);
		}
	
	}

}
