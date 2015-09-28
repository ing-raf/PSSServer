package Test.Integration;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import Presentation.TerminaleCliente.BadgeClientRMI;
import Presentation.TerminaleCliente.ClienteRegistratoClientRMI;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Batteria;

public class UC01 {

	@Test
	public void TC01() {
		
		final String idTest = "TC01";
		final int idStazione = 3;
		final int codiceBadge = 5;
		final int indiceAutovettura = 3;
		final int indiceBatteria = 0;
		
		BadgeClientRMI clientBadge = null;
		ClienteRegistratoClientRMI client = null;
		
		try {
			 clientBadge = new BadgeClientRMI(idStazione, "localhost");
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
			 
		try {
			 client = new ClienteRegistratoClientRMI(idStazione, "localhost");
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		try {
			clientBadge.startValidazione(codiceBadge);
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			assertTrue(idTest + " riuscito", client.verificaEsitoValidazione() );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			ArrayList<? extends AutovetturaCliente> autovetture = client.retrieveAutovetture();
			
			assertFalse(idTest + " riuscito", autovetture.isEmpty() );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		ArrayList<?> output = null;
		
		try {
			
			output = client.retrieveBatterieCompatibili(indiceAutovettura);
			
			assertFalse(idTest + " riuscito", output.isEmpty() );
			
			assertTrue(idTest + " riuscito", output.get(0) instanceof Batteria);
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			assertTrue ( client.startInstallazione(indiceBatteria) );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}

	}

}
