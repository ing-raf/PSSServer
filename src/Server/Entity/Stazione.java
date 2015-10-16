package Server.Entity;

import java.util.ArrayList;


import Server.DAO.BatteriaDAO;

import Server.DAO.StazioneDAO;

public class Stazione {
	
	private int ID;	
	private String nome;
	private String indirizzo;
	private ArrayList<Batteria> disponibili;
	
	
	
	public Stazione() {
		this.disponibili = new ArrayList <Batteria> ();
	}

	
	Stazione(StazioneDAO dao){
		this.ID = dao.getID();
		this.nome = dao.getName();
		this.indirizzo = dao.getAddress();
		this.disponibili = new ArrayList<Batteria> ();
		for (BatteriaDAO b: dao.getAvailableBatteries()){
			
			this.disponibili.add(new Batteria(b));
		}
		
	}
	
	static Stazione getStation(int cod){
		
		StazioneDAO dao = StazioneDAO.findStation(cod);
		if (dao != null)
			return  new Stazione(dao);
		else
			return null;
	}
	

	public int getID(){
		return this.ID;
	}
	
	public String getName(){
		return this.nome;
	}

	public String getAddress(){
		return this.indirizzo;
	}
	
	public ArrayList<Batteria> getAvailableBatteries (){
		return this.disponibili;
	}

	public void setID(int cod){
		this.ID = cod;
	}
	
	public void setName(String name){
		this.nome = name;
	}
	
	public void setAddress(String ind){
		this.indirizzo = ind;
	}
	
	public void setAvailableBatteries (Batteria b){
		this.disponibili.add(b);
	}
	
	public StazioneDAO prepareDAO(){
		StazioneDAO dao = new StazioneDAO();
		
		dao.setAddress(this.indirizzo);
		dao.setID(this.ID);
		dao.setName(this.nome);
		
		for(Batteria b : this.getAvailableBatteries()){
			dao.setAvailableBatteries(b.prepareDAO());
		}
		
		return dao;
	}
	
	public void removeBattery (Batteria vecchia){
		for (Batteria b: this.disponibili){
			if (b.equals(vecchia)) {
				this.disponibili.remove(vecchia);	
				break;
			}
		}
		
	}
	
	public boolean update(){	
		StazioneDAO dao = this.prepareDAO();		
		return dao.update();		
	}
	
	public boolean delete() {
		StazioneDAO dao = this.prepareDAO();
		return dao.delete();
	}


	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stazione other = (Stazione) obj;
		if (ID != other.ID)
			return false;
		if (disponibili == null) {
			if (other.disponibili != null)
				return false;
		} else if (!disponibili.equals(other.disponibili))
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}


	


	
	/*public boolean equals (Object obj){
		Stazione s = (Stazione) obj;  
		
		for (int i = 0; i < this.disponibili.size(); i++){
			if (!(s.getAvailableBatteries().get(i).equals(this.disponibili.get(i))))
				return false;	
		}
	
		
		if ((s.getID() == this.ID) &&
				(s.getAddress().equals(this.indirizzo)) && 
				(s.getName().equals(this.nome)) &&
				(s.getAvailableBatteries().size() == this.disponibili.size()))
				
			return true;
		else
			return false;
	
	}*/
	
}
