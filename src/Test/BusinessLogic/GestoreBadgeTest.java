package Test.BusinessLogic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Server.BusinessLogic.GestoreBadge;
import Server.BusinessLogic.GestoreStazione;
import Server.DAO.PopulateTestDatabase;

public class GestoreBadgeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PopulateTestDatabase.populate();
	}

	//@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	//@Before
	public void setUp() throws Exception {
	}

	//@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("unused")
	@Test
	public void testGestoreBadge() {
		final String idTest = "Test del costruttore";
		
		try {
			GestoreBadge gb = new GestoreBadge(0);
		} catch (Exception e) {
			fail (idTest + " riuscito");
		}
		
		try {
			GestoreBadge gb = new GestoreBadge(-1);
			
			fail (idTest + " riuscito");
		} catch (NullPointerException e) {
			assertTrue(true);
		} catch (Exception whateverElse) {
			fail (idTest + " riuscito");
		}
	}

	//@Test
	public void testVerifyCredit() {
		fail("Not yet implemented");
	}

	//@Test
	public void testDebit() {
		fail("Not yet implemented");
	}

	//@Test
	public void testRetrieveCarList() {
		fail("Not yet implemented");
	}

	//@Test
	public void testFindLastSubstitution() {
		fail("Not yet implemented");
	}

}
