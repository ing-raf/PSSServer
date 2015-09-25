package Server.RMIInterface;

import java.io.*;

public interface Sostituzione extends Serializable {

//	int getGiorno();

//	int getMese();

//	int getAnno();

//	int getOra();

//	int getMinuti();
	
	String getNomeStazione();

	String getIndirizzoStazione();

	int getIDBatteria();

}