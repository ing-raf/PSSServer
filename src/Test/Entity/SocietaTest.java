package Test.Entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import Server.DAO.PopulateTestDatabase;
import Server.Entity.ModelloAutovettura;
import Server.Entity.Societa;
import Server.Entity.Stazione;

public class SocietaTest {
	static Societa s_test = null ;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PopulateTestDatabase.populate();
		s_test = Societa.getSociety();
	}

	@Test
	public void testGetModelList() {
		final String idTest = "Test di getModelList";
		
		ModelloAutovettura[] oracle = new ModelloAutovettura[] { 
				new ModelloAutovettura(),
				new ModelloAutovettura(),
				new ModelloAutovettura(),
				new ModelloAutovettura(),
				new ModelloAutovettura(),
				new ModelloAutovettura(),
				new ModelloAutovettura()};
		
		oracle[0].setBrand("Maserati");
		oracle[0].setModel("Quattroporte");
		oracle[1].setBrand("Lamborghini");
		oracle[1].setModel("Gallardo");
		oracle[2].setBrand("Mercedes");
		oracle[2].setModel("SLK");
		oracle[3].setBrand("Alfa Romeo");
		oracle[3].setModel("Giulietta");
		oracle[4].setBrand("Alfa Romeo");
		oracle[4].setModel("Mito");
		oracle[5].setBrand("Peugeot");
		oracle[5].setModel("207");
		oracle[6].setBrand("Fiat");
		oracle[6].setModel("Panda");
		
		ArrayList<ModelloAutovettura> listaModelli = s_test.getModelList();
		
		assertEquals(idTest + " riuscito", 7, listaModelli.size() );
		
		for (ModelloAutovettura m : oracle) {
			System.err.println(m.getModel());
			assertTrue(idTest + " riuscito", listaModelli.contains(m));
		}
	}

	@Test
	public void testFindBadge() {
		final String idTest = "Test di findBadge";
		assertTrue (idTest + " riuscito", Societa.findBadge(0));
		assertFalse (idTest + " riuscito", Societa.findBadge(4));
	}

	@Test
	public void testGetStationList() {
		final String idTest = "Test di getStationList";
		
		Stazione[] oracle = new Stazione[3] ;
		
		if (Societa.findStation(1) && Societa.findStation(2) && Societa.findStation(3)){
			oracle [0] = s_test.getStation(1);
			oracle [1] = s_test.getStation(2);
			oracle [2] = s_test.getStation(3);
			ArrayList<Stazione> listaStazioni = s_test.getStationList();
		
			assertEquals(idTest + " riuscito", 3, listaStazioni.size() );
		
			for (Stazione s : oracle) 
				assertTrue(idTest + " riuscito", listaStazioni.contains(s));
		}
	}

	@Test
	public void testFindStation() {
		final String idTest = "Test di findStation";
		
		assertTrue (idTest + " riuscito", Societa.findStation(1));
		assertFalse (idTest + " riuscito", Societa.findStation(0));
		
	}

}
