package Server.RMIInterface;

import java.util.ArrayList;

public interface ServiziGestoreAndroid {

	ArrayList<? extends Autovettura> retrieveModelList() throws Exception;

	boolean addBattery(int IDbatteria, float costosostituzione, int maxciclidiricarica, int modelloautovettura) throws Exception;

	ArrayList<? extends Batteria> retrieveNearlyExhaustedBatteries() throws Exception;

	ArrayList<? extends AutovetturaCliente> retrieveCompatibleCars(int codicebadge) throws Exception;

	ArrayList<? extends Stazione> remoteRetrieveCompatibleBatteries(int modello) throws Exception;

	UltimaSostituzione retrieveLastSubstitution(int autovettura) throws Exception;

}