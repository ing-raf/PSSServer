package Test.Entity;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Server.DAO.PopulateTestDatabase;
import Server.DAO.UltimaSostituzioneDAO;
import Server.Entity.Batteria;
import Server.Entity.Stazione;
import Server.Entity.UltimaSostituzione;

public class UltimaSostituzioneTest {
	
	private static UltimaSostituzione oracle = null;
	private UltimaSostituzione test = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PopulateTestDatabase.populate();
		oracle = UltimaSostituzione.getLastSubstitution("EA 210 BB");
	}

	@Before
	public void setUp() throws Exception {
		test = UltimaSostituzione.getLastSubstitution("EA 210 BB");
	}

//	@After
	public void tearDown() throws Exception {
	//	oracle.update();
	}

//	@Test
	public void testUltimaSostituzioneDAO() {
		final String idTest = "Test del costruttore dal DAO";
		
		UltimaSostituzioneDAO dao = UltimaSostituzioneDAO.findSubstitution("EA 210 BB");
		UltimaSostituzione nuova = new UltimaSostituzione(dao);
		
		assertEquals(idTest + " riuscito", oracle, nuova);		
	}

//	@Test
	public void testGetDateHour() {
		final String idTest = "Test di getDateHour";
		
		Calendar data = Calendar.getInstance();
		data.clear();
		data.set(2015, Calendar.SEPTEMBER, 1, 13, 30);
		assertEquals(idTest + " riuscito", data, test.getDateHour());
	}

//	@Test
	public void testSetDateHour() {
		final String idTest = "Test di setDateHour";
		
		Calendar data = Calendar.getInstance();
		data.clear();
		data.set(2015, 10, 2, 12, 9);		
		test.setDateHour(data);
		
		assertEquals(idTest + "riuscito", data, test.getDateHour());
	}

//	@Test
	public void testGetSubstitutionStation() {
		final String idTest = "Test di getSubstitutionStation";
		
		Stazione s = Stazione.getStation(3);		
		assertEquals(idTest + "riuscito", s, test.getSubstitutionStation());
	}

//	@Test
	public void testSetSubstitutionStation() {
		final String idTest = "Test di setSubstitutionStation";
		
		Stazione s = Stazione.getStation(1);
		test.setSubstitutionStation(s);
		assertEquals(idTest + "riuscito", s, test.getSubstitutionStation());
	}

//	@Test
	public void testGetBattery() {
		final String idTest = "Test di getBattery";
		
		Batteria b = Batteria.getBattery(34);		
		assertEquals(idTest + "riuscito", b, test.getBattery());
	}

//	@Test
	public void testSetBattery() {
		final String idTest = "Test di setBattery";
		
		Batteria b = Batteria.getBattery(9);
		test.setBattery(b);
		assertEquals(idTest + "riuscito", b, test.getBattery());
	}

//	@Test
	public void testPrepareDAO() {
		final String idTest = "Test di prepareDAO";
		
//		UltimaSostituzioneDAO dao = test.prepareDAO();
		
//		assertEquals(idTest + "riuscito", UltimaSostituzioneDAO.findSubstitution("EA 210 BB"), dao);
	}

	@Test
	public void testUpdate() {
		final String idTest = "Test di update";
		
		Calendar data = Calendar.getInstance();
		data.clear();
		data.set(2015, 10, 2, 12, 27);		
		test.setDateHour(data);
		
		test.setSubstitutionStation(Stazione.getStation(2));
		test.setBattery(Batteria.getBattery(9));
		
		test.update();
		UltimaSostituzione last = UltimaSostituzione.getLastSubstitution("EA 210 BB");
		last.getBattery().getID();
		
		assertEquals(idTest + "riuscito", Batteria.getBattery(9), last.getBattery());
		assertEquals(idTest + "riuscito", Stazione.getStation(2), last.getSubstitutionStation());
		assertEquals(idTest + "riuscito", data, last.getDateHour());
	}

}
