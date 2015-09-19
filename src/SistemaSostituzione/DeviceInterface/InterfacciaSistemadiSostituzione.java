package SistemaSostituzione.DeviceInterface;

import SistemaSostituzione.RMIDeviceInterface.*;

public class InterfacciaSistemadiSostituzione implements ServizidiSostituzione {
	
	private static final int SECONDS = 1000;

	public boolean removeBatteria() throws Exception {
		System.out.println("Inizio la rimozione della batteria");
		Thread.sleep(30*SECONDS);
		System.out.println("Terminata la rimozione della batteria");
		return true;
	}

	/**
	 * 
	 * @param id
	 * @throws Exception 
	 */
	public boolean installBatteria(int id) throws Exception {
		System.out.println("Inizio l'installazione della batteria nº " + id);
		Thread.sleep(30*SECONDS);
		System.out.println("Terminata l'installazione della batteria nº " + id);
		return true;
	}

	/**
	 * 
	 * @param idBatteria
	 * @throws Exception 
	 */
	public boolean rechargeBatteria(int idBatteria) throws Exception {
		System.out.println("Inizio la ricarica della batteria nº " + idBatteria);
		Thread.sleep(30*SECONDS);
		System.out.println("Terminata la ricarica della batteria nº " + idBatteria);
		return true;
	}

	/**
	 * 
	 * @param idBatteria
	 * @throws Exception 
	 */
	public boolean discardBatteria(int idBatteria) throws Exception {
		System.out.println("Inizio la ricarica della batteria nº " + idBatteria);
		Thread.sleep(30*SECONDS);
		System.out.println("Terminata la ricarica della batteria nº " + idBatteria);
		return true;
	}

}