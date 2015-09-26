package Presentation.TerminaleCliente;

import java.awt.EventQueue;

public class Interfaccia {

	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					InterfacciaClienteNonRegistrato.idleScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
