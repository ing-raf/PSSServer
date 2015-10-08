package SistemaSostituzione.RMIDeviceInterface;

import java.rmi.Remote;

public interface ServizidiSostituzione extends Remote {

	boolean removeBatteria() throws Exception;

	/**
	 * 
	 * @param id
	 * @throws RemoteException 
	 */
	boolean installBatteria(int idBatteria) throws Exception;

	/**
	 * 
	 * @param id
	 * @throws Exception 
	 */
	boolean rechargeBatteria(int idBatteria) throws Exception;

	/**
	 * 
	 * @param id
	 * @throws Exception 
	 */
	boolean discardBatteria(int idBatteria) throws Exception;

}