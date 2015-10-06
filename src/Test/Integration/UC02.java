package Test.Integration;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Presentation.TerminaleGestore.GestoreAutenticatoClientLipe;
import Presentation.TerminaleGestore.InterfacciaGestoreAutenticato;
import Server.RMIInterface.Batteria;

public class UC02 {

	@Test
	public void TC01() {
		
		final String idTest = "TC01";
		final int idStazione = 2;
		final int size = 2;
		final int[] idBatteria = {9, 10};
		final float[] costo = {250.25f, 20.25f};
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
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
		final int idStazione = 3;
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
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
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(idStazione, "localhost");
			
			fail(idTest + " riuscito");
		} catch (Exception e) {
			assertTrue(true);
		}
		
	}

}
