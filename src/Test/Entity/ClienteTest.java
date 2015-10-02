package Test.Entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Server.DAO.AutovetturaCompatibileDAO;
import Server.DAO.BatteriaDAO;
import Server.DAO.ClienteDAO;
import Server.DAO.PopulateTestDatabase;
import Server.Entity.AutovetturaCompatibile;
import Server.Entity.Batteria;
import Server.Entity.Cliente;

public class ClienteTest {
	private static Cliente oracle = null;
	private Cliente test = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PopulateTestDatabase.populate();
		Calendar data  = Calendar.getInstance();
		data.clear();
		data.set(1990, 10, 21);
		oracle = Cliente.getClient("Sun", "Hu", data);
	}

	

	@Before
	public void setUp() throws Exception {
		Calendar data  = Calendar.getInstance();
		data.clear();
		data.set(1990, 10, 21);;
		test = Cliente.getClient("Sun", "Hu", data);
				
	}

	@After
	public void tearDown() throws Exception {
	}

	

	@Test
	public void testClienteDAO() {
	final String idTest = "Test del costruttore dal DAO";
	Calendar data  = Calendar.getInstance();
	data.clear();
	data.set(1990, 10, 21);;
		
	ClienteDAO dao = ClienteDAO.findClient("Sun", "Hu", data);
	Cliente nuova = new Cliente(dao);
		
		assertEquals(idTest + " riuscito", oracle, nuova);
	}

	@Test
	public void testPrepareDAO() {
		final String idTest = "Test di prepareDAO";
		Calendar data  = Calendar.getInstance();
		data.clear();
		data.set(1990, 10, 21);;
		
		ClienteDAO dao = test.prepareDAO();
		
		assertEquals(idTest + "riuscito", ClienteDAO.findClient("Sun", "Hu", data), dao);
	}

	
	@Test
	public void testGetName() {
		final String idTest = "Test di getName";
		
		assertEquals(idTest + " riuscito", "Sun" , test.getName());
	
	}

	@Test
	public void testGetSurname() {
		final String idTest = "Test di getSurname";
		
		assertEquals(idTest + " riuscito", "Hu" , test.getSurname());
	}

	@Test
	public void testGetOwnedCars() {
		final String idTest = "Test di GetOwnedCars()";
		AutovetturaCompatibile [] ac = new AutovetturaCompatibile[]{
				AutovetturaCompatibile.getCar("DZ 120 FP"),
				AutovetturaCompatibile.getCar("EA 210 BB"),
				AutovetturaCompatibile.getCar("ED 190 ES"),
				AutovetturaCompatibile.getCar("EF 580 AA"),
				AutovetturaCompatibile.getCar("EZ 711 PL")
				
		};
		
		ArrayList<AutovetturaCompatibile> list = test.getOwnedCars();
		
		assertEquals(idTest + " riuscito", 5 , list.size());
		
		for (AutovetturaCompatibile a: ac){
		assertEquals(idTest + " riuscito", true , list.contains(a));
				}
		
	}

	@Test
	public void testGetBirthDate() {
		final String idTest = "Test di getBirthDate";
		Calendar data  = Calendar.getInstance();
		data.clear();
		data.set(1990, 10, 21);
		assertEquals(idTest + " riuscito", data , test.getBirthDate());
	}

	@Test
	public void testSetName() {
		final String idTest = "Test di SetName ";
		test.setName("Domenico");
		assertEquals(idTest + " riuscito", "Domenico" , test.getName());
	}

	@Test
	public void testSetSurname() {
		final String idTest = "Test di SetSurame ";
		test.setSurname("Amalfitano");
		assertEquals(idTest + " riuscito", "Amalfitano" , test.getSurname());
	}

	@Test
	public void testSetBirthDate() {
		final String idTest = "Test di SetBirthDate ";
		Calendar data  = Calendar.getInstance();
		data.clear();
		data.set(1980, 11, 12);
		test.setBirthDate(data);
		assertEquals(idTest + " riuscito", data , test.getBirthDate());
	}

}
