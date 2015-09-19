package SistemaSostituzione.RMIDeviceInterface;

import java.rmi.Remote;

public interface ServizidiSostituzione extends Remote {

	boolean removeBatteria() throws Exception;

	/**
	 * 
	 * @param id
	 * @throws RemoteException 
	 */
	boolean installBatteria(int id) throws Exception;

	/**
	 * 
	 * @param id
	 * @throws Exception 
	 */
	boolean rechargeBatteria(int id) throws Exception;

	/**
	 * 
	 * @param id
	 * @throws Exception 
	 */
	boolean discardBatteria(int id) throws Exception;

}