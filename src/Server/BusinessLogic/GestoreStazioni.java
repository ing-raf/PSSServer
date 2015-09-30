package Server.BusinessLogic;

import java.util.ArrayList;

import Server.DAO.Stazione;
import Server.Entity.Societa;

public class GestoreStazioni {
	
	public static ArrayList<Integer> retriveListaId (){
		ArrayList <Server.DAO.Stazione> list_staz = (ArrayList <Server.DAO.Stazione>) Societa.getListaStazioni();
		ArrayList <Integer> list = new ArrayList<Integer>() ;
		for (int i = 0; i < list_staz.size();i++){
			list.add(list_staz.get(i).getID());	
		}
		return list;
	}

}
