package Server.RMIInterface;

import java.io.*;

public interface AutovetturaCliente extends Autovettura, Serializable {

	String getNumeroTarga();

}