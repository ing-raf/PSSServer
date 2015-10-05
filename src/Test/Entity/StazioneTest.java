package Test.Entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Server.DAO.PopulateTestDatabase;
import Server.DAO.StazioneDAO;
import Server.Entity.Batteria;
import Server.Entity.Societa;
import Server.Entity.Stazione;

public class StazioneTest {
	
	private static Stazione oracle = null;
	private Stazione test = null;
	private static Societa s_test = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PopulateTestDatabase.populate();
		s_test = Societa.getSociety();
		if (Societa.findStation(1))
			oracle = s_test.getStation(1);
	}
	
	@Before
	public void setUp() throws Exception {
		if (Societa.findStation(1))
			test = s_test.getStation(1);
	}

	@After
	public void tearDown() throws Exception {
		oracle.update();
	}

	

	@Test
	public void testGetID() {
		final String idTest = "Test di getID";
		
		assertEquals(idTest + " riuscito", 1, test.getID());
	}

	@Test
	public void testGetName() {
		final String idTest = "Test di getName";
		
		assertEquals(idTest + " riuscito", "Stazione Centrale", test.getName());
	}

	@Test
	public void testGetAddress() {
		final String idTest = "Test di getAddress";
		
		assertEquals(idTest + " riuscito", "Piazzale Tecchio", test.getAddress());
	}

	@Test
	public void testGetAvailableBatteries() {
		final String idTest = "Test di getAvailableBatteries";
		
		assertEquals(idTest + " riuscito", Batteria.getBattery(2), test.getAvailableBatteries().get(0) );
		assertEquals(idTest + " riuscito", Batteria.getBattery(3), test.getAvailableBatteries().get(1) );
		assertEquals(idTest + " riuscito", Batteria.getBattery(22), test.getAvailableBatteries().get(2) );
	}

	@Test
	public void testSetID() {
		final String idTest = "Test di setID";
		
		test.setID(2);
		assertEquals(idTest +  "riuscito", 2, test.getID());
	}

	@Test
	public void testSetName() {
		final String idTest = "Test di setName";
		
		test.setName("pippo");
		assertEquals(idTest + "riuscito", "pippo", test.getName());
		
	}

	@Test
	public void testSetAddress() {
		final String idTest = "Test di setAddress";
		
		test.setAddress("via Libertà");
		assertEquals(idTest + "riuscito", "via Libertà", test.getAddress());
	}

	@Test
	public void testSetAvailableBatteries() {
		final String idTest = "Test di setAvailableBatteries";
		
		Batteria b = Batteria.getBattery(1);
		test.setAvailableBatteries(b);
		assertTrue(idTest + "riuscito", test.getAvailableBatteries().contains(b));
	}

	@Test
	public void testPrepareDAO() {
		final String idTest = "Test di prepareDAO";
		
		StazioneDAO dao = test.prepareDAO();
		
		assertEquals(idTest + "riuscito", StazioneDAO.findStation(1), dao);
	}

	@Test
	public void testRemoveBattery() {
		final String idTest = "Test di removeBattery";
		
		Batteria b = Batteria.getBattery(3);
		test.removeBattery(b);
		
		assertFalse(idTest + "riuscito", test.getAvailableBatteries().contains(b));
	}

	@Test
	public void testUpdate() {
		final String idTest = "Test di update";
		
		Batteria b = Batteria.getBattery(3);
		test.removeBattery(b);
		
		test.update();
		Stazione s = null;
		if (Societa.findStation(2))
			s = s_test.getStation(2);
		
		
		assertFalse(idTest + "riuscito", s.getAvailableBatteries().contains(b));
	}

}
