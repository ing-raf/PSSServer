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
	public ArrayList<? extends Autovettura> retrieveModelList() throws Exception {
		return this.stub.retrieveModelList();
	}

	@Override
	public boolean addBattery(int IDbatteria, float costosostituzione, int maxciclidiricarica, int modelloautovettura)
			throws Exception {
		return this.stub.addBattery(IDbatteria, costosostituzione, maxciclidiricarica, modelloautovettura);
	}

	@Override
	public ArrayList<? extends Batteria> retrieveNearlyExhaustedBatteries() throws Exception {
		return this.stub.retrieveNearlyExhaustedBatteries();
	}

	@Override
	public ArrayList<? extends AutovetturaCliente> retrieveCompatibleCars(int codicebadge)
			throws Exception {
		return this.stub.retrieveCompatibleCars(codicebadge);
	}

	@Override
	public ArrayList<? extends Stazione> remoteRetrieveCompatibleBatteries(int modello) throws Exception {
		return this.stub.remoteRetrieveCompatibleBatteries(modello);
	}

	@Override
	public UltimaSostituzione retrieveLastSubstitution(int autovettura) throws Exception {
		return this.stub.retrieveLastSubstitution(autovettura);
	}

}
