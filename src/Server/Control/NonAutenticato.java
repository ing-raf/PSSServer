package Server.Control;


import Server.BusinessLogic.GestoreBadge;
import Server.RMIInterface.Install_Outcome;

public class NonAutenticato extends Stato {

	public boolean verifyValidationOutcome() {
		return false;
	}
	@Override
	public void startValidation(CoordinatoreClienteRegistrato coordinatore, int codice) {
		
		try {
			
			@SuppressWarnings("unused")
			GestoreBadge cercaBadge = new GestoreBadge(codice);
			
			coordinatore.setState( new Autenticato (codice) );
		} catch (NullPointerException e) {
			System.err.println("Inserimento di un badge non valido");
		}
			
	}
	
	@Override
	public Install_Outcome startInstallation(CoordinatoreClienteRegistrato coordinatore, int indiceBatteria) {
		return Install_Outcome.NO_VALIDATE;
	}
	
	@Override
	public void logOut(CoordinatoreClienteRegistrato coordinatore) {		
	}

}