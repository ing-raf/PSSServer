package Server.RMIInterface;

import java.io.*;

public interface Sostituzione extends Serializable {

	int getGiorno();

	int getMese();

	int getAnno();

	int getOra();

	int getMinuti();

	string getIndirizzoStazione();

	int getIDbatteria();

}