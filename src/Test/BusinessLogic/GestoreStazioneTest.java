package Test.BusinessLogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;


import org.junit.BeforeClass;
import org.junit.Test;

import Server.BusinessLogic.AutovetturaBL;
import Server.BusinessLogic.AutovetturaClienteBL;
import Server.BusinessLogic.BatteriaBL;
import Server.BusinessLogic.GestoreStazione;
import Server.BusinessLogic.StazioneBL;
import Server.DAO.BatteriaDAO;
import Server.DAO.PopulateTestDatabase;
import Server.DAO.StazioneDAO;
import Server.Entity.Batteria;
import Server.Entity.Societa;
import Server.Entity.UltimaSostituzione;

public class GestoreStazioneTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PopulateTestDatabase.populate();
	}

//	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

//	@Before
	public void setUp() throws Exception {
	}

//	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("unused")
	@Test
	public void testGestoreStazione() {
		final String idTest = "Test del costruttore";
		
		try {
			GestoreStazione gs = new GestoreStazione(1, 5);
		} catch (Exception e) {
			fail (idTest + " riuscito");
		}
		
		try {
			GestoreStazione gs = new GestoreStazione(-1, 5);
			
			fail (idTest + " riuscito");
		} catch (NullPointerException e) {
			assertTrue(true);
		} catch (Exception whateverElse) {
			fail (idTest + " riuscito");
		}
		
	}

	@Test
	public void testInsertBattery() {
		final String idTest = "Test di InsertBattery";
		
		GestoreStazione gs = new GestoreStazione(2, 5);
		
		assertTrue(idTest + " riuscito", gs.insertBattery( new BatteriaBL(60, 23.20f, 72, "Panda", "Fiat") ));
		
		assertFalse(idTest + " riuscito", gs.insertBattery( new BatteriaBL(21, 11.50f, 24, "Panda", "Fiat") ) );
	
	BatteriaDAO dao = BatteriaDAO.findBattery(60);
	
		assertEquals(idTest + " riuscito", 23.20 ,dao.getCostSubstitution(), 0.001);
		assertEquals(idTest + " riuscito", 72 ,dao.getCyclesRecharge());
		assertEquals(idTest + " riuscito", "Panda" ,dao.getModel().getModel() );
		assertEquals(idTest + " riuscito", "Fiat" ,dao.getModel().getBrand() );
	}

	@Test
	public void testAddBattery() {
	final String idTest = "Test di AddBattery";
		
		GestoreStazione gs = new GestoreStazione(2, 5);
		
		assertTrue(idTest + " riuscito", gs.insertBattery( new BatteriaBL(31, 40.55f, 6, "Giulietta", "Alfa Romeo") ));
		
		StazioneDAO dao = StazioneDAO.findStation(2);
		
		assertTrue(idTest + " riuscito", dao.getAvailableBatteries().contains( BatteriaDAO.findBattery(31) ) );
	}

	@Test
	public void testVerifyRecharge() {
		final String idTest = "Test di VerifyRecharge";
		
		GestoreStazione gs = new GestoreStazione(3, 5);
		
		assertTrue(idTest + " riuscito", gs.verifyRecharge( new BatteriaBL(21, 11.50f, 24, "Panda", "Fiat") ) );
		assertFalse(idTest + " riuscito", gs.verifyRecharge( new BatteriaBL(44, 725.30f, 0, "Gallardo", "Lamborghini") ) );
	}

	@Test
	public void testDiscardBattery() {
		final String idTest = "Test di DiscardBattery";
		
		GestoreStazione gs = new GestoreStazione(1, 5);
		
		assertTrue(idTest + " riuscito", gs.discardBattery( new BatteriaBL(2, 550.50f, 4, "Quattroporte", "Maserati") ) );
		
		assertEquals(idTest + " riuscito", null, BatteriaDAO.findBattery(2));
	}

	@Test
	public void testRetrieveCompatibleBatteries() {
		
		final String idTest = "Test di RetrieveCompatibleBatteries";
		
		GestoreStazione gs = new GestoreStazione(3, 5);
		
		ArrayList<BatteriaBL> trovate = gs.retrieveCompatibleBatteries( new AutovetturaBL("207", "Peugeot"));
		
		assertEquals(idTest + " riuscito", 1, trovate.size());
		
		assertEquals(idTest + " riuscito", new BatteriaBL(12, 21.50f, 20, "207", "Peugeot"), trovate.get(0));
		
		trovate = gs.retrieveCompatibleBatteries( new AutovetturaBL("SLK", "Mercedes"));
		
		assertTrue(idTest + " riuscito", trovate.isEmpty());
		
		ArrayList<BatteriaBL> trovate1 = gs.retrieveCompatibleBatteries( new AutovetturaBL("Panda", "Fiat"));
		
		
		assertTrue(idTest + " riuscito", trovate1.isEmpty());
	}

	@Test
	public void testRemoteRetrieveCompatibleBatteries() {
		final String idTest = "Test di RemoteRetrieveCompatibleBatteries";
		
		GestoreStazione gs = new GestoreStazione(3, 5);
		
		ArrayList<StazioneBL> trovate = gs.remoteRetrieveCompatibleBatteries( new AutovetturaBL("207", "Peugeot"));
		
		assertEquals(idTest + " riuscito", 1, trovate.size());
		
		assertEquals(idTest + " riuscito", new StazioneBL(2, "Stazione Agnoli","Via Nuova Agnano"), trovate.get(0));
	}

	@Test
	public void testUpdateSubstitution() {
		final String idTest = "Test di UpdateSubstitution";
		
		GestoreStazione gs = new GestoreStazione(1, 5);
		
		BatteriaBL vecchia = new BatteriaBL();
		
		Calendar momentoSostituzione = Calendar.getInstance();
		momentoSostituzione.clear();
		momentoSostituzione.set(Calendar.getInstance().get(Calendar.YEAR),
				Calendar.getInstance().get(Calendar.MONTH), 
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
				Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
				Calendar.getInstance().get(Calendar.MINUTE) );
		
		AutovetturaClienteBL car = new AutovetturaClienteBL("Maserati", "Quattroporte", "EF 580 AA");
		
		assertTrue(idTest + " riuscito", gs.updateSubstitution(car, new BatteriaBL(3, 490.25f, 79, "Quattroporte", "Maserati"), vecchia) );
		
		assertEquals(idTest + " riuscito", new BatteriaBL(36, 530.3f, 108, "Quattroporte", "Maserati"), vecchia);
		
		assertEquals(idTest + " riuscito", Batteria.getBattery(3),  UltimaSostituzione.getLastSubstitution("EF 580 AA").getBattery());
		
		Societa laSocieta = Societa.getSociety();
		
		assertEquals(idTest + " riuscito",  laSocieta.getStation(1), UltimaSostituzione.getLastSubstitution("EF 580 AA").getSubstitutionStation() );
		
		assertTrue(idTest + " riuscito", UltimaSostituzione.getLastSubstitution("EF 580 AA").getDateHour().compareTo(momentoSostituzione) >= 0);
	}

	@Test
	public void testRetrieveNearlyExhaustedBatteries() {
		final String idTest = "Test di RetrieveNearlyExhaustedBatteries";
		
		GestoreStazione gs = new GestoreStazione(2, 25);
		ArrayList<BatteriaBL> nearlyExhausted = gs.retrieveNearlyExhaustedBatteries();
		
		assertEquals(idTest + " riuscito", 3, nearlyExhausted.size());
		
		BatteriaBL[] oracle = new BatteriaBL[] {
				new BatteriaBL(9, 250.25f, 3, "SLK", "Mercedes"),
				new BatteriaBL(10, 20.25f, 2, "207", "Peugeot"),
				new BatteriaBL(21, 11.50f, 24, "Panda", "Fiat"),
				};
		
		for (BatteriaBL b : oracle)
			assertTrue(idTest + " riuscito", nearlyExhausted.contains(b));
		
	}
		
}
