package Test.Entity;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Server.DAO.PopulateTestDatabase;
import Server.DAO.UltimaSostituzioneDAO;
import Server.Entity.Batteria;
import Server.Entity.Societa;
import Server.Entity.Stazione;
import Server.Entity.UltimaSostituzione;

public class UltimaSostituzioneTest {
	
	private static final String targa = "EA 210 BB";
	private static UltimaSostituzione oracle = null;
	private UltimaSostituzione test = null;
	private static Societa s_test = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PopulateTestDatabase.populate();
		oracle = UltimaSostituzione.getLastSubstitution(targa);
		s_test = Societa.getSociety();
	}

	@Before
	public void setUp() throws Exception {
		test = UltimaSostituzione.getLastSubstitution(targa);
	}

//	@After
	public void tearDown() throws Exception {
	//	oracle.update();
	}

	@Test
	public void testUltimaSostituzioneDAO() {
		final String idTest = "Test del costruttore dal DAO";
		
		UltimaSostituzioneDAO dao = UltimaSostituzioneDAO.findSubstitution(targa);
		UltimaSostituzione nuova = new UltimaSostituzione(dao);
		
		assertEquals(idTest + " riuscito", oracle, nuova);		
	}

	@Test
	public void testGetDateHour() {
		final String idTest = "Test di getDateHour";
		
		Calendar data = Calendar.getInstance();
		data.clear();
		data.set(2015, Calendar.SEPTEMBER, 1, 13, 30);
		assertEquals(idTest + " riuscito", data, test.getDateHour());
	}

	@Test
	public void testSetDateHour() {
		final String idTest = "Test di setDateHour";
		
		Calendar data = Calendar.getInstance();
		data.clear();
		data.set(2015, 10, 2, 12, 9);		
		test.setDateHour(data);
		
		assertEquals(idTest + "riuscito", data, test.getDateHour());
	}

	@Test
	public void testGetSubstitutionStation() {
		final String idTest = "Test di getSubstitutionStation";
		
		Stazione s = null;
		if (s_test.findStation(3))
			s = s_test.getStation(3);		
		assertEquals(idTest + "riuscito", s, test.getSubstitutionStation());
	}

	@Test
	public void testSetSubstitutionStation() {
		final String idTest = "Test di setSubstitutionStation";
		
		Stazione s = null;
		if (s_test.findStation(1))
			s = s_test.getStation(1);
		test.setSubstitutionStation(s);
		assertEquals(idTest + "riuscito", s, test.getSubstitutionStation());
	}

	@Test
	public void testGetBattery() {
		final String idTest = "Test di getBattery";
		
		Batteria b = Batteria.getBattery(34);		
		assertEquals(idTest + "riuscito", b, test.getBattery());
	}

	@Test
	public void testSetBattery() {
		final String idTest = "Test di setBattery";
		
		Batteria b = Batteria.getBattery(9);
		test.setBattery(b);
		assertEquals(idTest + "riuscito", b, test.getBattery());
	}

	@Test
	public void testPrepareDAO() {
		final String idTest = "Test di prepareDAO";
		
		UltimaSostituzioneDAO dao = test.prepareDAO(targa);
		
		assertEquals(idTest + "riuscito", UltimaSostituzioneDAO.findSubstitution(targa), dao);
	}

	@Test
	public void testUpdate() {
		final String idTest = "Test di update";
		
		Calendar data = Calendar.getInstance();
		data.clear();
		data.set(2015, 10, 2, 12, 27);		
		test.setDateHour(data);
		Stazione s = null;
		if (s_test.findStation(2))
			s = s_test.getStation(2);
		test.setSubstitutionStation(s);
		test.setBattery(Batteria.getBattery(9));
		
		test.update(targa);
		UltimaSostituzione last = UltimaSostituzione.getLastSubstitution(targa);
		last.getBattery().getID();
		
		assertEquals(idTest + "riuscito", Batteria.getBattery(9), last.getBattery());
		assertEquals(idTest + "riuscito", s, last.getSubstitutionStation());
		assertEquals(idTest + "riuscito", data, last.getDateHour());
	}

}
