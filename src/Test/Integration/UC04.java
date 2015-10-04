package Test.Integration;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import Presentation.TerminaleGestore.GestoreAutenticatoClientLipe;
import Presentation.TerminaleGestore.InterfacciaGestoreAutenticato;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.UltimaSostituzione;

public class UC04 {

	@Test
	public void TC01() {
		
		final String idTest = "TC01";
		final int idStazione = 1;
		final int codiceBadge = -3;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
			
		try {
			ArrayList<? extends AutovetturaCliente> autovetture = client.retrieveAutovettureCliente(codiceBadge);
			
			assertEquals(idTest + " riuscito", true, autovetture.isEmpty());
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}

	}
	
	@Test
	public void TC02() {
		
		final String idTest = "TC02";
		final int idStazione = 1;
		final int codiceBadge = 0;
		final int indiceAutovettura = 0;
		final int giorno = 20;
		final int mese = Calendar.JULY;
		final int anno = 2015;
		final int ora = 21;
		final int minuti = 12;
		final int idBatteria = 32;
		final String nomeStazione = "Stazione Centrale";
		final String indirizzoStazione = "Piazzale Tecchio";
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
			
		try {
			ArrayList<? extends AutovetturaCliente> autovetture = client.retrieveAutovettureCliente(codiceBadge);
		
			assertNotEquals(idTest + " riuscito", true, autovetture.isEmpty());

		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
					
		UltimaSostituzione ultima = null;
		
		try {
			ultima = client.retrieveUltimaSostituzione(indiceAutovettura);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}

		assertNotEquals(idTest + " riuscito", null, ultima);
		
		assertEquals(idTest + " riuscito", giorno, ultima.getGiorno() );
		assertEquals(idTest + " riuscito", mese, ultima.getMese() );
		assertEquals(idTest + " riuscito", anno, ultima.getAnno() );
		assertEquals(idTest + " riuscito", ora, ultima.getOra() );
		assertEquals(idTest + " riuscito", minuti, ultima.getMinuti() );
		assertEquals(idTest + " riuscito", idBatteria, ultima.getIDBatteria() );
		assertEquals(idTest + " riuscito", nomeStazione, ultima.getNomeStazione() );
		assertEquals(idTest + " riuscito", indirizzoStazione, ultima.getIndirizzoStazione() );
	}
	
	@Test
	public void TC03() {
		
		final String idTest = "TC03";
		final int idStazione = 1;
		final int codiceBadge = 5;
		final int indiceAutovettura = 2;
		final int giorno = 20;
		final int mese = Calendar.AUGUST;
		final int anno = 2015;
		final int ora = 9;
		final int minuti = 20;
		final int idBatteria = 35;
		final String nomeStazione = "Stazione Agnoli";
		final String indirizzoStazione = "Via Nuova Agnano";
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
			
		try {
			ArrayList<? extends AutovetturaCliente> autovetture = client.retrieveAutovettureCliente(codiceBadge);
			
			assertNotEquals(idTest + " riuscito", true, autovetture.isEmpty());
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}

		
		UltimaSostituzione ultima = null;
		
		try {
			ultima = client.retrieveUltimaSostituzione(indiceAutovettura);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}

		assertNotEquals(idTest + " riuscito", null, ultima);
		
		assertEquals(idTest + " riuscito", giorno, ultima.getGiorno() );
		assertEquals(idTest + " riuscito", mese, ultima.getMese() );
		assertEquals(idTest + " riuscito", anno, ultima.getAnno() );
		assertEquals(idTest + " riuscito", ora, ultima.getOra() );
		assertEquals(idTest + " riuscito", minuti, ultima.getMinuti() );
		assertEquals(idTest + " riuscito", idBatteria, ultima.getIDBatteria() );
		assertEquals(idTest + " riuscito", nomeStazione, ultima.getNomeStazione() );
		assertEquals(idTest + " riuscito", indirizzoStazione, ultima.getIndirizzoStazione() );
	}
	
	@SuppressWarnings("unused")
	@Test
	public void TC04() {
		
		final String idTest = "TC04";
		final int idStazione = -1;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
			
			fail(idTest + " riuscito");
			
		} catch (Exception e) {
			assertTrue(true);
		}

	}

	@Test
	public void TC08() {
		
		final String idTest = "TC08";
		final int idStazione = 1;
		final int codiceBadge = 10;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		ArrayList<? extends AutovetturaCliente> autovetture = new ArrayList<AutovetturaCliente>();
			
		try {
			autovetture = client.retrieveAutovettureCliente(codiceBadge);
			
			assertEquals(idTest + " riuscito", null, autovetture);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
	
	}
			
}
