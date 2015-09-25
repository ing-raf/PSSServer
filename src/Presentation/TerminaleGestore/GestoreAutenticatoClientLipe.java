package Presentation.TerminaleGestore;

import java.util.ArrayList;

import Server.RMIInterface.Autovettura;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Batteria;
import Server.RMIInterface.ServiziGestoreAndroid;
import Server.RMIInterface.Sostituzione;
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
		CallHandler callHandler = new CallHandler();
		this.IDstazione = IDstazione;
		this.serverHostname = serverHostname;
		this.client = new Client(this.serverHostname, PORT_OFFSET + 2 * this.IDstazione + 1, callHandler);
		this.stub = (ServiziGestoreAndroid) client.getGlobal (ServiziGestoreAndroid.class);
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
	public Sostituzione retrieveUltimaSostituzione(int autovettura) throws Exception {
		return this.stub.retrieveUltimaSostituzione(autovettura);
	}

}
