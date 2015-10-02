package Test.Entity;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Server.DAO.BadgeDAO;
import Server.DAO.PopulateTestDatabase;
import Server.DAO.StazioneDAO;
import Server.Entity.Badge;
import Server.Entity.Batteria;
import Server.Entity.Cliente;
import Server.Entity.Stazione;

public class BadgeTest {
	
	private static Badge oracle = null;
	private Badge test = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PopulateTestDatabase.populate();
		oracle = Badge.getBadge(0);
	}

	@Before
	public void setUp() throws Exception {
		test = Badge.getBadge(0);
	}

	@After
	public void tearDown() throws Exception {
		oracle.update();
	}

	@Test
	public void testGetBadge() {
		fail("Not yet implemented");
	}


	@Test
	public void testPrepareDAO() {
		final String idTest = "Test di prepareDAO";
		
		BadgeDAO dao = test.prepareDAO();
		
		assertEquals(idTest + "riuscito", BadgeDAO.findBadge(0), dao);
	}

	@Test
	public void testGetCode() {
		final String idTest = "Test di getCode";
		
		assertEquals(idTest + " riuscito", 0, test.getCode());
	}

	@Test
	public void testGetCredit() {
		final String idTest = "Test di getCredit";
		
		assertEquals(idTest + " riuscito", true, Float.compare((float) 18.21, test.getCredit()));
	}

	@Test
	public void testGetClient() {
		final String idTest = "Test di getClient";
		Calendar d = Calendar.getInstance();
		d.clear();
		d.set(1965, 0, 30);
		Cliente c = Cliente.getClient("Paolo", "Brambilla", d);
		
		assertEquals(idTest + " riuscito", true, c.equals(test.getClient()));
	}

	@Test
	public void testSetCode() {
		final String idTest = "Test di setCode";
		
		test.setCode(2);
		assertEquals(idTest +  "riuscito", 2, test.getCode());
	}

	@Test
	public void testSetCredit() {
		final String idTest = "Test di setCredit";
		
		test.setCredit(249.5f);
		assertEquals(idTest +  "riuscito", true, Float.compare(249.5f, test.getCredit()));
	}

	@Test
	public void testSetClient() {
		final String idTest = "Test di setClient";
		Calendar d = Calendar.getInstance();
		d.clear();
		d.set(1984, 6, 3);
		Cliente c = Cliente.getClient("Mario", "Rossi", d);
		
		test.setClient(c);
		
		assertEquals(idTest + " riuscito", true, c.equals(test.getClient()));
	}

	@Test
	public void testUpdate() {
		final String idTest = "Test di update";
		
		test.setCredit(300.8f);
		
		test.update();
		
		assertEquals(idTest + "riuscito", true, Float.compare(300.8f, test.getCredit()));
	}

}
