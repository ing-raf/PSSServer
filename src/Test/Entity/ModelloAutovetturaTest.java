package Test.Entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Server.DAO.ModelloAutovetturaDAO;
import Server.DAO.PopulateTestDatabase;
import Server.DAO.StazioneDAO;
import Server.Entity.ModelloAutovettura;
import Server.Entity.Stazione;

public class ModelloAutovetturaTest {

	private ModelloAutovettura test = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PopulateTestDatabase.populate();
	}

	@Before
	public void setUp() throws Exception {
		this.test = new ModelloAutovettura();
		test.setBrand("Peugeot");
		test.setModel("207");		
	}

	@Test
	public void testModelloAutovetturaDAO() {
		final String idTest = "Test del costruttore dal DAO";
		
		ModelloAutovetturaDAO dao = ModelloAutovetturaDAO.findModelloAuto("207", "Peugeot");
		ModelloAutovettura nuova = new ModelloAutovettura(dao);
		
		assertEquals(idTest + " riuscito", test, nuova);
	}

	@Test
	public void testGetBrand() {
		final String idTest = "Test di getBrand";
		
		assertEquals(idTest + " riuscito", "Peugeot", test.getBrand());
	}

	@Test
	public void testSetBrand() {
		final String idTest = "Test di setBrand";
		
		test.setBrand("Fiat");
		assertEquals(idTest + "riuscito", "Fiat", test.getBrand());
	}

	@Test
	public void testGetModel() {
		final String idTest = "Test di getModel";
		
		assertEquals(idTest + " riuscito", "207", test.getModel());
	}

	@Test
	public void testSetModel() {
		final String idTest = "Test di setModel";
		
		test.setModel("Panda");
		assertEquals(idTest + "riuscito", "Panda", test.getModel());
	}

	@Test
	public void testPrepareDAO() {
		final String idTest = "Test di prepareDAO";
		
		ModelloAutovetturaDAO dao = test.prepareDAO();
		assertEquals(idTest + "riuscito", ModelloAutovetturaDAO.findModelloAuto("207", "Peugeot"), dao);
		
	}

}
