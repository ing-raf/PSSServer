package Test.BusinessLogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;
import Server.BusinessLogic.AutovetturaClienteBL;
import Server.BusinessLogic.GestoreBadge;
import Server.BusinessLogic.UltimaSostituzioneBL;
import Server.DAO.BadgeDAO;
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

	@Test
	public void testVerifyCredit() {
		final String idTest = "Test del verifyCredit";
		GestoreBadge gb = new GestoreBadge(5);
		assertTrue(idTest + " riuscito", gb.verifyCredit(400.00f));
	}

	@Test
	public void testDebit() {
		final String idTest = "Test del Debit";
		GestoreBadge gb = new GestoreBadge(5);
		gb.debit(400.00f);
		BadgeDAO dao = BadgeDAO.findBadge(5);
		assertEquals(idTest + " riuscito", 600.00,dao.getCredit(), 0.001);
	}

	@Test
	public void testRetrieveCarList() {
		final String idTest = "Test del RetrieveCarList ";
		GestoreBadge gb = new GestoreBadge(0);
		ArrayList<AutovetturaClienteBL> list = gb.retrieveCarList();
		
		AutovetturaClienteBL test = new AutovetturaClienteBL("Peugeot","207","CB 739 HJ");
		assertEquals(idTest + " riuscito", test,list.get(0));
		
		
	}

	
	@Test
	public void testFindLastSubstitution() {
		final String idTest = "Test del FindLastSubstitution ";
		GestoreBadge gb = new GestoreBadge(0);
		UltimaSostituzioneBL usbl = gb.findLastSubstitution("CB 739 HJ");
		Calendar data  = Calendar.getInstance();
		data.clear();
		data.set(2015, Calendar.JULY, 20,21,12);
		
		UltimaSostituzioneBL oracolo = new UltimaSostituzioneBL (data,"Stazione Sorrento","Corso Italia", 32);
		assertEquals(idTest + " riuscito", oracolo,usbl);
		
		
	}

}
