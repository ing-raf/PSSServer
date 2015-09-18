package Server.Entity;
import java.util.Calendar;

//import Server.Entity.*;
public class Test {
	public static void main(String[] args) {
		Cliente c = new Cliente ();
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
		c1.salva();
		Badge b1 = new Badge ();
		b1.setCodice(43);
		b1.setCredito(434);
		b1.setCliente(c1);
		b1.salva();
		Badge b2 = new Badge (834);
		Cliente c2 = b2.getCliente();
		System.out.println(b2.getCliente().getNome() + " " + c2.getCognome());
	}

}
