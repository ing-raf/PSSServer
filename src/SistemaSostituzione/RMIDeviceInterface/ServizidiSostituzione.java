package SistemaSostituzione.RMIDeviceInterface;

import java.rmi.Remote;

public interface ServizidiSostituzione extends Remote {

	boolean removeBattery() throws Exception;

	boolean installBattery(int idBatteria) throws Exception;

	boolean rechargeBattery(int idBatteria) throws Exception;

	boolean discardBattery(int idBatteria) throws Exception;

}