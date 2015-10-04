package Server.RMIInterface;

import java.io.*;

public interface UltimaSostituzione extends Serializable {

	public int getDay();

	public int getMonth();

	public int getYear();

	public int getHour();

	public int getMinutes();
	
	public String getStationName();

	public String getStationAddress();

	int getBatteryID();

}