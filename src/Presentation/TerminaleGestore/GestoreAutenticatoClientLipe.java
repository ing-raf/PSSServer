package Presentation.TerminaleGestore;

import java.util.ArrayList;

import Server.RMIInterface.Autovettura;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Batteria;
import Server.RMIInterface.ServiziGestoreAndroid;
import Server.RMIInterface.UltimaSostituzione;
import Server.RMIInterface.Stazione;


import lipermi.handler.CallHandler;
import lipermi.net.Client;

public class GestoreAutenticatoClientLipe implements InterfacciaGestoreAutenticato {
	
	private static int PORT_OFFSET = 1024;
	private final String serverHostname;
	private final int IDstazione;
	private Client client;
	private ServiziGestoreAndroid stub;
	
	
	public GestoreAutenticatoClientLipe (int IDstazione, String serverHostname) throws Exception {
		
		if (IDstazione < 0) throw new NullPointerException();
		
		CallHandler callHandler = new CallHandler();
		this.IDstazione = IDstazione;
		this.serverHostname = serverHostname;
		this.client = new Client(this.serverHostname, PORT_OFFSET + 2 * this.IDstazione + 1, callHandler);
				
		this.stub = (ServiziGestoreAndroid) client.getGlobal (ServiziGestoreAndroid.class);
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
