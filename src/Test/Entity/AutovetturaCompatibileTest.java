package Test.Entity;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Server.DAO.AutovetturaCompatibileDAO;
import Server.DAO.PopulateTestDatabase;
import Server.DAO.StazioneDAO;
import Server.Entity.AutovetturaCompatibile;
import Server.Entity.Batteria;
import Server.Entity.ModelloAutovettura;
import Server.Entity.Stazione;
import Server.Entity.UltimaSostituzione;

public class AutovetturaCompatibileTest {
	
	private static AutovetturaCompatibile oracle = null;
	private AutovetturaCompatibile test = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PopulateTestDatabase.populate();
		oracle = AutovetturaCompatibile.getCar("EA 210 BB");
	}

	@Before
	public void setUp() throws Exception {
		test = AutovetturaCompatibile.getCar("EA 210 BB");
	}

	@Test
	public void testAutovetturaCompatibileAutovetturaCompatibileDAO() {
		final String idTest = "Test del costruttore dal DAO";
		
		AutovetturaCompatibileDAO dao = AutovetturaCompatibileDAO.findCar("EA 210 BB");
		AutovetturaCompatibile nuova = new AutovetturaCompatibile(dao);
		
		assertEquals(idTest + " riuscito", oracle, nuova);
	}

	@Test
	public void testGetNumberPlate() {
		final String idTest = "Test di getNumberPlate";
		
		assertEquals(idTest + " riuscito", "EA 210 BB", test.getNumberPlate());
	}

	@Test
	public void testSetNumberPlate() {
		final String idTest = "Test di setNumberPlate";
		
		test.setNumberPlate("PS 300 SS");;
		assertEquals(idTest +  "riuscito", "PS 300 SS", test.getNumberPlate());
	}

	@Test
	public void testGetModel() {
		final String idTest = "Test di getModel";
		
		test = AutovetturaCompatibile.getCar("EA 210 BB");
		ModelloAutovettura m = new ModelloAutovettura();
		m.setBrand("Mercedes");
		m.setModel("SLK");
		
		assertEquals(idTest + "riuscito", m.equals(test.getModel()));
		
	}

	@Test
	public void testSetModel() {
		final String idTest = "Test di setModel";
		
		ModelloAutovettura m = new ModelloAutovettura();
		m.setBrand("Fiat");
		m.setModel("Panda");
		test.setModel(m);
		
		assertEquals(idTest + "riuscito", m.equals(test.getModel()));
	}

	@Test
	public void testGetLastSubstitution() {
		final String idTest = "Test di getLastSubstitution";
		
		test = AutovetturaCompatibile.getCar("EA 210 BB");
		UltimaSostituzione u = UltimaSostituzione.getLastSubstitution("EA 210 BB");	
		
		assertEquals(idTest + "riuscito", u.equals(test.getLastSubstitution()));
	}

	@Test
	public void testSetLastSubstitution() {
		final String idTest = "Test di setLastSubstitution";
		Batteria b = Batteria.getBattery(21);
		Stazione s = Stazione.getStation(2);
		Calendar d = null;
		d.clear();
		d.set(2015, 10, 02, 12, 8);
		UltimaSostituzione u = new UltimaSostituzione();
		u.setBattery(b);
		u.setDateHour(d);
		u.setSubstitutionStation(s);
		
		assertEquals(idTest + "riuscito", u.equals(test.setLastSubstitution(u)));
	}

	@Test
	public void testPrepareDAO() {
		final String idTest = "Test di prepareDAO";
		
		AutovetturaCompatibileDAO dao = test.prepareDAO();
		
		assertEquals(idTest + "riuscito", AutovetturaCompatibileDAO.findCar("EA 210 BB"), dao);
	}

}
