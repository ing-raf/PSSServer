package Test.Entity;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Server.DAO.BatteriaDAO;
import Server.DAO.PopulateTestDatabase;
import Server.Entity.Batteria;
import Server.Entity.ModelloAutovettura;


public class BatteriaTest {
	
	private static Batteria oracle = null;
	private Batteria test = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PopulateTestDatabase.populate();
		oracle = Batteria.getBattery(1);
	}


	@Before
	public void setUp() throws Exception {
		test = Batteria.getBattery(1);
	}

	@After
	public void tearDown() throws Exception {
		oracle.update();
	}

	

	@Test
	public void testBatteriaDAO() {
	final String idTest = "Test del costruttore dal DAO";
		
		BatteriaDAO dao = BatteriaDAO.findBattery(1);
		Batteria nuova = new Batteria(dao);
		
		assertEquals(idTest + " riuscito", oracle, nuova);
	}

	@Test
	public void testInserimentoBatteria() {
		final String idTest = "Test di inserimento nuova batteria nel Database";
		ModelloAutovettura mod = new ModelloAutovettura ();
		mod.setBrand("Fiat");
		mod.setModel("Panda");
		Batteria b = new Batteria (50, 400.00f, 71, mod);
		
		assertEquals(idTest + " riuscito", Batteria.getBattery(50),b );
		
		Batteria b1 = new Batteria (22, 600.00f, 23, mod);
		assertFalse(idTest + " riuscito", Batteria.getBattery(22).equals(b1));
	}

	@Test
	public void testGetID() {
		final String idTest = "Test di getID";
		
		assertEquals(idTest + " riuscito", 1, test.getID());
	}

	

	@Test
	public void testGetCostSubstitution() {
		final String idTest = "Test di getCostSubstitution";
		
		assertEquals(idTest + " riuscito", 610.21 , test.getCostSubstitution(),0.001);
	}

	@Test
	public void testGetCyclesRecharge() {
		final String idTest = "Test di getCyclesRecharge";
		
		assertEquals(idTest + " riuscito", 121 , test.getCyclesRecharge());
	}

	@Test
	public void testGetModel() {
		final String idTest = "Test di getModel";
		ModelloAutovettura mod = new ModelloAutovettura ();
		mod.setBrand("Lamborghini");
		mod.setModel("Gallardo");
		assertTrue(idTest + " riuscito", test.getModel().equals(mod));
	}

	@Test
	public void testSetID() {
		final String idTest = "Test di setID";
		test.setID(40);
		assertEquals(idTest + " riuscito", 40 , test.getID());
	}

	@Test
	public void testSetCostSubstitution() {
		final String idTest = "Test di setCostSubstitution";
		test.setCostSubstitution(400.00f);;
		assertEquals(idTest + " riuscito", 400.00f , test.getCostSubstitution(),0.001);
	}

	@Test
	public void testSetCyclesRecharge() {
		final String idTest = "Test di setCyclesRecharge";
		test.setCyclesRecharge(71);;
		assertEquals(idTest + " riuscito", 71 , test.getCyclesRecharge());
		
	}

	@Test
	public void testSetModel() {
		final String idTest = "Test di SetModel";
		ModelloAutovettura mod = new ModelloAutovettura ();
		mod.setBrand("Fiat");
		mod.setModel("Panda");
		test.setModel(mod);
		assertTrue(idTest + " riuscito", test.getModel().equals(mod));
	}

	@Test
	public void testPrepareDAO() {
		final String idTest = "Test di prepareDAO";
		
		BatteriaDAO dao = test.prepareDAO();
		
		assertEquals(idTest + "riuscito", BatteriaDAO.findBattery(1), dao);
	}

	@Test
	public void testUpdate() {
		final String idTest = "Test di update";
		test.setCostSubstitution(20.00f);
		test.setCyclesRecharge(56);
		test.update();
		Batteria b = Batteria.getBattery(1); 
		
		assertEquals(idTest + "riuscito",20.00f, b.getCostSubstitution(),0.001);
		
	}


}
