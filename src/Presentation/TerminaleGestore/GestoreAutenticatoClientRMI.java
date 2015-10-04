package Presentation.TerminaleGestore;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import Server.RMIInterface.Autovettura;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Batteria;
import Server.RMIInterface.ServiziGestore;
import Server.RMIInterface.UltimaSostituzione;
import Server.RMIInterface.Stazione;

public class GestoreAutenticatoClientRMI implements InterfacciaGestoreAutenticato {
	
	private static int PORT_OFFSET = 3307;
	private final String serverHostname;
	private final int IDstazione;
	private Registry registry;
	private ServiziGestore stub;
	
	
	public GestoreAutenticatoClientRMI (int IDstazione, String serverHostname) throws Exception {
		this.IDstazione = IDstazione;
		this.serverHostname = serverHostname;
		this.registry = LocateRegistry.getRegistry(this.serverHostname, PORT_OFFSET + 2 * this.IDstazione + 1);
		this.stub = (ServiziGestore)registry.lookup("ServiziGestore");
	}

	@Override
	public ArrayList<? extends Autovettura> retrieveListaModelli() throws Exception {
		return this.stub.retrieveListaModelli();
	}

	@Override
	public boolean addBatteria(int IDbatteria, float costosostituzione, int maxciclidiricarica, int modelloautovettura)
			throws Exception {
		return this.stub.addBatteria(IDbatteria, costosostituzione, maxciclidiricarica, modelloautovettura);
	}

	@Override
	public ArrayList<? extends Batteria> retrieveBatterieQuasiEsauste(int IDstazione) throws Exception {
		return this.stub.retrieveBatterieQuasiEsauste(IDstazione);
	}

	@Override
	public ArrayList<? extends AutovetturaCliente> retrieveAutovettureCliente(int codicebadge)
			throws Exception {
		return this.stub.retrieveAutovettureCliente(codicebadge);
	}

	@Override
	public ArrayList<? extends Stazione> remoteRetrieveBatterieCompatibili(int modello) throws Exception {
		return this.stub.remoteRetrieveBatterieCompatibili(modello);
	}

	@Override
	public UltimaSostituzione retrieveUltimaSostituzione(int autovettura) throws Exception {
		return this.stub.retrieveUltimaSostituzione(autovettura);
	}

}
