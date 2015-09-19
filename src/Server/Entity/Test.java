package Server.Entity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import Server.Entity.*;
public class Test {
	public static void main(String[] args) {
		/*Cliente c = new Cliente ();
		c.setNome("Paola");
		c.setcognome("Venuso");
		c.setData(Calendar.getInstance());
		c.setId(453);
		c.salva();
		Badge b = new Badge ();
		b.setCodice(834);
		b.setCredito(34);
		b.setCliente(c);
		b.salva();
		Cliente c1 = new Cliente ();
		c1.setNome("Paol0");
		c1.setcognome("Vnuso");
		c1.setData(Calendar.getInstance());
		c1.setId(45);
		AutovetturaCompatibile a =new AutovetturaCompatibile();
		a.setNumeroTarga("3424");
		a.salva();
		AutovetturaCompatibile a1 =new AutovetturaCompatibile();
		a1.setNumeroTarga("4");
		a1.salva();
		Set<AutovetturaCompatibile> f = new HashSet<AutovetturaCompatibile> () ;
		f.add(a);
		c1.setAutovettura(f);
		//c1.update();
		f.add(a1);
		c1.setAutovettura(f);
		c1.salva();
		Badge b1 = new Badge ();
		b1.setCodice(43);
		b1.setCredito(434);
		b1.setCliente(c1);
		b1.salva();
		Badge b2 = new Badge (43);
		Cliente c2 = b2.getCliente();
		Cliente c3 = new Cliente (b2.getCliente().getID());
		
		System.out.println (c2.getID());
		
	/*	AutovetturaCompatibile [] t = new AutovetturaCompatibile [f.size()];
		Set<AutovetturaCompatibile> f1 = c3.getAutoPoassedute();
		if (f1 == null) System.out.println("Associazione non letta");
		System.out.println(b2.getCliente().getNome() + " " + c2.getCognome() + " " + t[0].getNumeroTarga() +" " + t[1].getNumeroTarga());*/
		Stazione s = new Stazione(1);
	//	s.setID(1);
		
		Badge b = new Badge(2);
		System.out.println( b.getCliente().getNome() );
		
//		ArrayList<Batteria> result = new ArrayList<Batteria>(s1.findBatterie());
		List<Batteria> result = s.getBatterieDisp();
		if ( result.isEmpty() ) System.out.println("Lettura fallita");
		else System.out.println(result.size());
		
		for (int i = 1; i < result.size(); i++) {
			System.out.println( result.get(i).getCostoSostituzione() );
		}
		

		
//		Batteria s = new Batteria();
		
		/*ArrayList<Batteria> result = new ArrayList<Batteria>(s.findBatterie());
		if ( result.isEmpty() ) System.out.println("Lttura fallita");
		else System.out.println(result.size());*/
		
		
	}

}
