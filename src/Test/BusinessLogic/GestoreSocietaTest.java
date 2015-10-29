package Test.BusinessLogic;

import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.BeforeClass;
import org.junit.Test;

import Server.BusinessLogic.AutovetturaBL;
import Server.BusinessLogic.GestoreSocieta;
import Server.BusinessLogic.StazioneBL;
import Server.DAO.PopulateTestDatabase;

public class GestoreSocietaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PopulateTestDatabase.populate();
	}

//	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

//	@Before
	public void setUp() throws Exception {
	}

//	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testRetrieveModelList() {
		final String idTest = "Test del RetrieveCarList ";
		GestoreSocieta gs = new GestoreSocieta();
		ArrayList<AutovetturaBL> list = gs.retrieveModelList();
		ArrayList<AutovetturaBL> oracolo = new ArrayList<AutovetturaBL> ();
		
		oracolo.add(new AutovetturaBL("Quattroporte","Maserati"));
		oracolo.add(new AutovetturaBL("Gallardo","Lamborghini"));
		oracolo.add(new AutovetturaBL("SLK","Mercedes"));
		oracolo.add(new AutovetturaBL("Giulietta","Alfa Romeo"));
		oracolo.add(new AutovetturaBL("Mito","Alfa Romeo"));
		oracolo.add(new AutovetturaBL("207","Peugeot"));
		oracolo.add(new AutovetturaBL("Panda","Fiat"));
		
		for (int i=0; i<7; i++){
			assertEquals(idTest + " riuscito", oracolo.get(i),list.get(i));
		}
	}

	@Test
	public void testRetrieveStationList() {
		final String idTest = "Test del RetrieveStationList ";
		GestoreSocieta gs = new GestoreSocieta();
		ArrayList<StazioneBL> list = gs.retrieveStationList();
		ArrayList<StazioneBL> oracolo = new ArrayList<StazioneBL> ();
		
		oracolo.add(new StazioneBL(1,"Stazione Centrale","Piazzale Tecchio"));
		oracolo.add(new StazioneBL(2,"Stazione Agnoli","Via Nuova Agnano"));
		oracolo.add(new StazioneBL(3,"Stazione Stadio","Via Claudio"));
		
		
		for (int i=0; i<3; i++){
			assertTrue(idTest + " riuscito",list.contains(oracolo.get(i)));
		}
	}

}
