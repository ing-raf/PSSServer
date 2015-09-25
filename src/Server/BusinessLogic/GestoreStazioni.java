package Server.BusinessLogic;

import java.util.ArrayList;

import Server.Entity.Società;
import Server.Entity.Stazione;

public class GestoreStazioni {
	
	public static ArrayList<Integer> retriveListaId (){
		ArrayList <Server.Entity.Stazione> list_staz = (ArrayList <Server.Entity.Stazione>) Società.getListaStazioni();
		ArrayList <Integer> list = new ArrayList<Integer>() ;
		for (int i = 0; i < list_staz.size();i++){
			list.add(list_staz.get(i).getID());	
		}
		return list;
	}

}
