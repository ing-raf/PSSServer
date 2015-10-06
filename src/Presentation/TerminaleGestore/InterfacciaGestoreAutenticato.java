package Presentation.TerminaleGestore;

import java.util.ArrayList;

import Server.RMIInterface.Autovettura;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Batteria;
import Server.RMIInterface.UltimaSostituzione;
import Server.RMIInterface.Stazione;

public interface InterfacciaGestoreAutenticato {
	// TODO questa classe contiene i metodi con cui il client interroga il server
	// e che l'interfaccia del gestore chiamerà
	public ArrayList<? extends Autovettura> retrieveModelList() throws Exception;
	
	public boolean addBattery(int IDbatteria, float costosostituzione, int maxciclidiricarica, int modelloautovettura) throws Exception;
	
	public ArrayList<? extends Batteria> retrieveNearlyExhaustedBatteries() throws Exception;

	public ArrayList<? extends AutovetturaCliente> retrieveCompatibleCars(int codicebadge) throws Exception;

	public ArrayList<? extends Stazione> remoteRetrieveCompatibleBatteries(int modello) throws Exception;

	public UltimaSostituzione retrieveLastSubstitution(int autovettura) throws Exception;

}