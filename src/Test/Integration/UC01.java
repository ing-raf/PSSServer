package Test.Integration;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import Presentation.TerminaleCliente.BadgeClientRMI;
import Presentation.TerminaleCliente.ClienteRegistratoClientRMI;
import Server.DAO.BadgeDAO;
import Server.DAO.BatteriaDAO;
import Server.DAO.PopulateTestDatabase;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Install_Outcome;
import Server.RMIInterface.Stazione;

public class UC01 {
	
	private String host = "localhost";

	@Test
	public void TC01() throws InterruptedException {
		
		final String idTest = "TC01";
		final int idStazione = 3;
		final int codiceBadge = 5;
		final int indiceAutovettura = 0;
		final int indiceBatteria = 0;
		final String targa = "DZ 120 FP";
		BadgeClientRMI clientBadge = null;
		ClienteRegistratoClientRMI client = null;
		
		try {
			 clientBadge = new BadgeClientRMI(idStazione, this.host);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
			 
		try {
			 client = new ClienteRegistratoClientRMI(idStazione, this.host);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		try {
			clientBadge.startValidation(codiceBadge);
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			assertTrue(idTest + " riuscito", client.verifyValidationOutcome() );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			ArrayList<? extends AutovetturaCliente> autovetture = client.retrieveCompatibleCars();
			
			assertFalse(idTest + " riuscito", autovetture.isEmpty() );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		ArrayList<?> output = null;
		
		try {
			
			output = client.retrieveCompatibleBatteries(indiceAutovettura);
			
			assertFalse(idTest + " riuscito", output.isEmpty() );
			
			assertTrue(idTest + " riuscito", output.get(0) instanceof Server.RMIInterface.Batteria );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			assertEquals (idTest + " riuscito", Install_Outcome.OK, client.startInstallation(indiceBatteria) );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		assertEquals (idTest + " riuscito", 1, PopulateTestDatabase.testSostituzione(targa).getID() );

		Thread.sleep(5*1000);
		
		BatteriaDAO vecchia = BatteriaDAO.findBattery(33); 
				
		assertEquals (idTest + " riuscito", 77, vecchia.getCyclesRecharge() );
		
		BadgeDAO b = BadgeDAO.findBadge(codiceBadge);
		
		assertEquals (idTest + " riuscito", 389.79 , b.getCredit(), 0.001f );
		
	}

	
	@Test
	public void TC02() {
		
		final String idTest = "TC02";
		final int idStazione = 3;
		final int codiceBadge = 0;
		final int indiceAutovettura = 0;
		final int indiceBatteria = 0;
		final String targa = "CB 739 HJ";
		
		BadgeClientRMI clientBadge = null;
		ClienteRegistratoClientRMI client = null;
		
		try {
			 clientBadge = new BadgeClientRMI(idStazione, this.host);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
			 
		try {
			 client = new ClienteRegistratoClientRMI(idStazione, this.host);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		try {
			clientBadge.startValidation(codiceBadge);
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			assertTrue(idTest + " riuscito", client.verifyValidationOutcome() );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			ArrayList<? extends AutovetturaCliente> autovetture = client.retrieveCompatibleCars();
			
			assertFalse(idTest + " riuscito", autovetture.isEmpty() );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		ArrayList<?> output = null;
		
		try {
			
			output = client.retrieveCompatibleBatteries(indiceAutovettura);
			
			assertFalse(idTest + " riuscito", output.isEmpty() );
			
			assertTrue(idTest + " riuscito", output.get(0) instanceof Server.RMIInterface.Batteria);
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			assertEquals (idTest + " riuscito", Install_Outcome.NO_MONEY, client.startInstallation(indiceBatteria) );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		assertEquals (idTest + " riuscito", 32, PopulateTestDatabase.testSostituzione(targa).getID() );
		
	}
	
	@Test
	public void TC03() {
		
		final String idTest = "TC03";
		final int idStazione = 3;
		final int codiceBadge = -3;
		
		BadgeClientRMI clientBadge = null;
		ClienteRegistratoClientRMI client = null;
		
		try {
			 clientBadge = new BadgeClientRMI(idStazione, this.host);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
			 
		try {
			 client = new ClienteRegistratoClientRMI(idStazione, this.host);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		try {
			clientBadge.startValidation(codiceBadge);
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			assertTrue(idTest + " riuscito", client.verifyValidationOutcome() );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			ArrayList<? extends AutovetturaCliente> autovetture = client.retrieveCompatibleCars();
			
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
			 clientBadge = new BadgeClientRMI(idStazione, this.host);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
			 
		try {
			 client = new ClienteRegistratoClientRMI(idStazione, this.host);
		} catch (Exception e) {
			fail(idTest + " riuscito");
		}
		
		try {
			clientBadge.startValidation(codiceBadge);
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			assertTrue(idTest + " riuscito", client.verifyValidationOutcome() );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		try {
			
			ArrayList<? extends AutovetturaCliente> autovetture = client.retrieveCompatibleCars();
			
			assertFalse(idTest + " riuscito", autovetture.isEmpty() );
			
		} catch (RemoteException e) {
			fail(idTest + " riuscito");
		}
		
		ArrayList<?> output = null;
		
		try {
			
			output = client.retrieveCompatibleBatteries(indiceAutovettura);
			
			assertFalse(idTest + " riuscito", output.isEmpty() );
			
			assertTrue(idTest + " riuscito", output.get(0) instanceof Stazione);
			
			assertEquals(idTest + " riuscito", 1, output.size() );
			
			assertEquals(idTest + " riuscito", "Stazione Centrale", ( (Stazione) output.get(0) ).getName() );
			
			assertEquals(idTest + " riuscito", "Piazzale Tecchio", ( (Stazione) output.get(0) ).getAddress() );
			
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
				 clientBadge = new BadgeClientRMI(idStazione, this.host);
			} catch (Exception e) {
				fail(idTest + " riuscito");
			}
				 
			try {
				 client = new ClienteRegistratoClientRMI(idStazione, this.host);
			} catch (Exception e) {
				fail(idTest + " riuscito");
			}
			
			try {
				clientBadge.startValidation(codiceBadge);
			} catch (RemoteException e) {
				fail(idTest + " riuscito");
			}
			
			try {
				
				assertTrue(idTest + " riuscito", client.verifyValidationOutcome() );
				
			} catch (RemoteException e) {
				fail(idTest + " riuscito");
			}
			
			try {
				
				ArrayList<? extends AutovetturaCliente> autovetture = client.retrieveCompatibleCars();
				
				assertFalse(idTest + " riuscito", autovetture.isEmpty() );
				
			} catch (RemoteException e) {
				fail(idTest + " riuscito");
			}
			
			ArrayList<?> output = null;
			
			try {
				
				output = client.retrieveCompatibleBatteries(indiceAutovettura);
				
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
				 clientBadge = new BadgeClientRMI(idStazione, this.host);
			} catch (Exception e) {
				fail(idTest + " riuscito");
			}
				 
			try {
				 client = new ClienteRegistratoClientRMI(idStazione, this.host);
			} catch (Exception e) {
				fail(idTest + " riuscito");
			}
			
			try {
				clientBadge.startValidation(codiceBadge);
			} catch (RemoteException e) {
				fail(idTest + " riuscito");
			}
			
			try {
				
				assertFalse(idTest + " riuscito", client.verifyValidationOutcome() );
				
			} catch (RemoteException e) {
				fail(idTest + " riuscito");
			}
		
	}
		
}
