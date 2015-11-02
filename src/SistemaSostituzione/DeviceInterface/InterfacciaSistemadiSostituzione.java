package SistemaSostituzione.DeviceInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import SistemaSostituzione.RMIDeviceInterface.*;

public class InterfacciaSistemadiSostituzione extends UnicastRemoteObject implements ServizidiSostituzione {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1875640802971240440L;



	protected InterfacciaSistemadiSostituzione() throws RemoteException {
		super();
	}

	private static final int SECONDS = 1000;
	private static final int TIME_TO_WAIT = 1;
	

	public boolean removeBatteria() throws Exception {
		System.out.println("Inizio la rimozione della batteria");
		Thread.sleep(TIME_TO_WAIT*SECONDS);
		System.out.println("Terminata la rimozione della batteria");
		return true;
	}

	/**
	 * 
	 * @param id
	 * @throws Exception 
	 */
	public boolean installBatteria(int id) throws Exception {
		System.out.println("Inizio l'installazione della batteria " + id);
		Thread.sleep(TIME_TO_WAIT*SECONDS);
		System.out.println("Terminata l'installazione della batteria " + id);
		return true;
	}

	/**
	 * 
	 * @param idBatteria
	 * @throws Exception 
	 */
	public boolean rechargeBatteria(int idBatteria) throws Exception {
		System.out.println("Inizio la ricarica della batteria " + idBatteria);
		Thread.sleep(TIME_TO_WAIT*SECONDS);
		System.out.println("Terminata la ricarica della batteria " + idBatteria);
		return true;
	}

	/**
	 * 
	 * @param idBatteria
	 * @throws Exception 
	 */
	public boolean discardBatteria(int idBatteria) throws Exception {
		System.out.println("Inizio lo scarto della batteria " + idBatteria);
		Thread.sleep(TIME_TO_WAIT*SECONDS);
		System.out.println("Terminato lo scarto della batteria " + idBatteria);
		return true;
	}

}