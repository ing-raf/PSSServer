package Presentation.TerminaleGestore;

import java.util.ArrayList;

import Server.RMIInterface.Autovettura;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Batteria;
import Server.RMIInterface.Sostituzione;
import Server.RMIInterface.Stazione;

public interface InterfacciaGestoreAutenticato {
	// TODO questa classe contiene i metodi con cui il client interroga il server
	// e che l'interfaccia del gestore chiamerà
	public ArrayList<? extends Autovettura> retrieveListaModelli() throws Exception;
	
	public boolean addBatteria(int IDbatteria, float costosostituzione, int maxciclidiricarica, int modelloautovettura) throws Exception;
	
	public ArrayList<? extends Batteria> retrieveBatterieQuasiEsauste(int IDstazione) throws Exception;

	public ArrayList<? extends AutovetturaCliente> retrieveAutovettureCliente(int codicebadge) throws Exception;

	public ArrayList<? extends Stazione> remoteRetrieveBatterieCompatibili(int modello) throws Exception;

	public Sostituzione retrieveUltimaSostituzione(int autovettura) throws Exception;

}