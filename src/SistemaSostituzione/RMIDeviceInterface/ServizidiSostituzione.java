package SistemaSostituzione.RMIDeviceInterface;

import java.rmi.*;

public interface ServizidiSostituzione extends Remote {

	boolean removeBatteria();

	/**
	 * 
	 * @param id
	 */
	boolean installBatteria(int id);

	/**
	 * 
	 * @param id
	 */
	boolean rechargeBatteria(int id);

	/**
	 * 
	 * @param id
	 */
	boolean discardBatteria(int id);

}