package Test.Integration;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Presentation.TerminaleCliente.BadgeClientRMI;
import Presentation.TerminaleGestore.GestoreAutenticatoClientLipe;
import Presentation.TerminaleGestore.InterfacciaGestoreAutenticato;
import Server.RMIInterface.Batteria;

public class UC02 {
	
	private String host = "localhost";

	@Test
	public void TC01() {
		
		final String idTest = "TC01";
		final int idStazione = 2;
		final int size = 2;
		final int[] idBatteria = {9, 10};
		final float[] costo = {250.25f, 20.25f};
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, this.host);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		ArrayList<? extends Batteria> esauste = new ArrayList<Batteria>();
		
		try {
			esauste = client.retrieveNearlyExhaustedBatteries();
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		assertNotEquals(idTest + " riuscito", true, esauste.isEmpty() );
		assertEquals(idTest + " riuscito", size, esauste.size() );
		
		for (int i = 0; i < size; i++) {
			assertEquals(idTest + " riuscito", idBatteria[i], esauste.get(i).getID() );		
			assertEquals(idTest + " riuscito", costo[i], esauste.get(i).getCostSubstitution(), 0.001f );
		}

	}
	
	@Test
	public void TC02() {
		
		final String idTest = "TC02";
		final int idStazione = 0;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, this.host);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		ArrayList<? extends Batteria> esauste = new ArrayList<Batteria>();
		
		try {
			esauste = client.retrieveNearlyExhaustedBatteries();
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		assertEquals(idTest + " riuscito", true, esauste.isEmpty() );
		
	}
	
	@SuppressWarnings("unused")
	@Test
	public void TC03() {
		
		final String idTest = "TC03";
		final int idStazione = 9;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, this.host);
			
			fail(idTest + " riuscito");
		} catch (Exception e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void TC04() {
		final String idTest = "TC04";
		final int idStazione = -1;
		final int idStazione1 = -5;
		
		boolean ris = false;
		
		@SuppressWarnings("unused")
		BadgeClientRMI clientBadge = null;
		
		try {
			 clientBadge = new BadgeClientRMI(idStazione, this.host);
			 ris=true;
			 fail(idTest + " riuscito");
		} catch (Exception e) {
			assertFalse(idTest + " riuscito", ris );
			
		}
		
		 clientBadge = null;
		
		try {
			 clientBadge = new BadgeClientRMI(idStazione1, this.host);
			 ris=true;
			 fail(idTest + " riuscito");
		} catch (Exception e) {
			assertFalse(idTest + " riuscito", ris );
			
		}
		
		
	}

}
