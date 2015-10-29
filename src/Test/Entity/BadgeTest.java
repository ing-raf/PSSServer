package Test.Entity;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Server.DAO.BadgeDAO;
import Server.DAO.PopulateTestDatabase;
import Server.Entity.Badge;
import Server.Entity.Cliente;
import Server.Entity.Societa;


public class BadgeTest {
	
	private static Badge oracle = null;
	private Badge test = null;
	private static Societa s_test = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PopulateTestDatabase.populate();
		s_test = Societa.getSociety();
		if (s_test.findBadge(0))
			oracle = s_test.getBadge(0);
	}

	@Before
	public void setUp() throws Exception {
		if (s_test.findBadge(0))
			test = s_test.getBadge(0);
	}

	@After
	public void tearDown() throws Exception {
		oracle.update();
	}

	


	@Test
	public void testPrepareDAO() {
		final String idTest = "Test di prepareDAO";
		Badge p = null;
		if (s_test.findBadge(1))
			 p = s_test.getBadge(1);
		BadgeDAO dao = p.prepareDAO();
	
		assertEquals(idTest + "riuscito", BadgeDAO.findBadge(1), dao);
	}

	@Test
	public void testGetCode() {
		final String idTest = "Test di getCode";
		
		assertEquals(idTest + " riuscito", 0, test.getCode());
	}

	@Test
	public void testGetCredit() {
		final String idTest = "Test di getCredit";
		
		assertEquals(idTest + " riuscito", 0.00, test.getCredit(),0.001);
	}

	@Test
	public void testGetClient() {
		final String idTest = "Test di getClient";
			Calendar data  = Calendar.getInstance();
			data.clear();
			data.set(1965, 01, 30);
			Cliente c = Cliente.getClient(test.getClient().getName(), test.getClient().getSurname(), test.getClient().getBirthDate());
			
		assertEquals(idTest + " riuscito", true, test.getClient().equals(c));
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
		assertEquals(idTest +  "riuscito", 249.5, test.getCredit(),0.001);
		test.setCredit(0.0f);
	}

	//@Test
	public void testSetClient() {
		final String idTest = "Test di setClient";
		Calendar d = Calendar.getInstance();
		d.clear();
		d.set(1984, 07, 03);
		Cliente c = Cliente.getClient("Rossi", "Mario", d);
		
		test.setClient(c);
		
		assertEquals(idTest + " riuscito", true, c.equals(test.getClient()));
		test.setClient(oracle.getClient());
	}

	@Test
	public void testUpdate() {
		final String idTest = "Test di update";
		
		test.setCredit(300.8f);
		
		test.update();
		
		assertEquals(idTest + "riuscito", 300.8f,  test.getCredit(),0.001);
	}

}
