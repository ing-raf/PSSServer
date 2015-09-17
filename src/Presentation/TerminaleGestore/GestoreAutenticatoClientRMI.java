package Presentation.TerminaleGestore;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import Server.RMIInterface.Autovettura;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Batteria;
import Server.RMIInterface.ServiziGestore;
import Server.RMIInterface.Sostituzione;
import Server.RMIInterface.Stazione;

public class GestoreAutenticatoClientRMI implements InterfacciaGestoreAutenticato {
	
	private static int PORT_OFFSET = 1024;
	private final String hostname;
	private final int IDstazione;
	Registry registry;
	ServiziGestore stub;
	
	
	GestoreAutenticatoClientRMI (int IDstazione, String hostname) throws Exception {
		this.IDstazione = IDstazione;
		this.hostname = hostname;
		registry = LocateRegistry.getRegistry(this.hostname, PORT_OFFSET + this.IDstazione);
		this.stub = (ServiziGestore)registry.lookup("ServiziGestore");
	}

	@Override
	public ArrayList<? extends Autovettura> retrieveListaModelli() throws RemoteException {
		return this.stub.retrieveListaModelli();
	}

	@Override
	public boolean addBatteria(int IDbatteria, float costosostituzione, int maxciclidiricarica, int modelloautovettura)
			throws RemoteException {
		return this.stub.addBatteria(IDbatteria, costosostituzione, maxciclidiricarica, modelloautovettura);
	}

	@Override
	public ArrayList<? extends Batteria> retrieveBatterieQuasiEsauste(int IDstazione) throws RemoteException {
		return this.stub.retrieveBatterieQuasiEsauste(IDstazione);
	}

	@Override
	public boolean retrieveAutovettureCliente(int codicebadge, ArrayList<? extends AutovetturaCliente> elencoAutovetture)
			throws RemoteException {
		return this.stub.retrieveAutovettureCliente(codicebadge, elencoAutovetture);
	}

	@Override
	public ArrayList<? extends Stazione> remoteRetrieveBatterieCompatibili(int modello) throws RemoteException {
		return this.stub.remoteRetrieveBatterieCompatibili(modello);
	}

	@Override
	public Sostituzione retrieveUltimaSostituzione(int autovettura) throws RemoteException {
		return this.stub.retrieveUltimaSostituzione(autovettura);
	}

}
