package Test.Integration;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import Presentation.TerminaleCliente.BadgeClientRMI;
import Presentation.TerminaleCliente.ClienteRegistratoClientRMI;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Batteria;
import Server.RMIInterface.Install_Outcome;
import Server.RMIInterface.Stazione;

public class UC01 {

	@Test
	public void TC01() {
		
		final String idTest = "TC01";
		final int idStazione = 3;
		final int codiceBadge = 5;
		final int indiceAutovettura = 0;
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
			
			assertEquals (idTest + " riuscito", Install_Outcome.OK, client.startInstallazione(indiceBatteria) );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}

		
//		fail("To be verified");
		
	}

	
	@Test
	public void TC02() {
		
		final String idTest = "TC02";
		final int idStazione = 3;
		final int codiceBadge = 0;
		final int indiceAutovettura = 0;
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
			
			assertEquals (idTest + " riuscito", Install_Outcome.NO_MONEY, client.startInstallazione(indiceBatteria) );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}

		
//		fail("To be verified");
		
	}
	
	@Test
	public void TC03() {
		
		final String idTest = "TC03";
		final int idStazione = 3;
		final int codiceBadge = -3;
		
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
			
			assertTrue(idTest + " riuscito", autovetture.isEmpty() );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
	}
	
	@Test
	public void TC04() {
		
		final String idTest = "TC04";
		final int idStazione = 3;
		final int codiceBadge = 5;
		final int indiceAutovettura = 3;
		
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
			
			assertTrue(idTest + " riuscito", output.get(0) instanceof Stazione);
			
			assertEquals(idTest + " riuscito", 1, output.size() );
			
			assertEquals(idTest + " riuscito", "Stazione Centrale", ( (Stazione) output.get(0) ).getNome() );
			
			assertEquals(idTest + " riuscito", "Piazzale Tecchio", ( (Stazione) output.get(0) ).getIndirizzo() );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
	}

		@Test
		public void TC05() {
			
			final String idTest = "TC05";
			final int idStazione = 3;
			final int codiceBadge = 1;
			final int indiceAutovettura = 0;
			
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
				
				assertTrue(idTest + " riuscito", output.isEmpty() );
				
			} catch (RemoteException e) {
				fail(idTest + " riuscito");
			}
		
	}
		
		@Test
		public void TC06() {
			
			final String idTest = "TC06";
			final int idStazione = 3;
			final int codiceBadge = 8;
			
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
				
				assertFalse(idTest + " riuscito", client.verificaEsitoValidazione() );
				
			} catch (RemoteException e) {
				fail(idTest + " riuscito");
			}
		
	}
		
}
