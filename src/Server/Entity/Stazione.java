package Server.Entity;

import java.util.ArrayList;
import java.util.List;

import Server.DAO.BatteriaDAO;
import Server.DAO.ModelloAutovetturaDAO;
import Server.DAO.StazioneDAO;

public class Stazione {
	
	private int ID;	
	private String nome;
	private String indirizzo;
	private ArrayList<Batteria> disponibili;
	
	
	
	public Stazione() {
		this.disponibili = new ArrayList <Batteria> ();
	}

	
	public Stazione(StazioneDAO dao){
		this.ID = dao.getID();
		this.nome = dao.getName();
		this.indirizzo = dao.getAddress();
		this.disponibili = new ArrayList<Batteria> ();
		for (BatteriaDAO b: dao.getAvailableBatteries()){
			
			this.disponibili.add(new Batteria(b));
		}
		
	}
	
	public static Stazione getStation(int cod){
		
		StazioneDAO dao = StazioneDAO.findStation(cod);
		return  new Stazione(dao);
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
	
	public List<Batteria> getAvailableBatteries (){
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
		if (vecchia == null ) System.err.println("lota");
		else if (this.disponibili == null) System.err.println("merda");
		for (Batteria b: this.disponibili){
			if (b.equals(vecchia))
				this.disponibili.remove(vecchia);
			
		}
		
	}
	
	public boolean update(){
		
		StazioneDAO dao = new StazioneDAO();
//		StazioneDAO dao = StazioneDAO.findStation(this.getID() );
//		if (!dao.getAvailableBatteries().isEmpty())
//			System.err.println("Puttana maiala");
		dao.setAddress(this.getAddress());
		dao.setID(this.getID());
		dao.setName(this.getName());
		
		for(Batteria b: this.disponibili){
			BatteriaDAO batt = new BatteriaDAO();
			batt.setID(b.getID() );
			batt.setCostSubstitution(b.getCostSubstitution() );
			batt.setCyclesRecharge( b.getCyclesRecharge() );
				ModelloAutovetturaDAO mod = new ModelloAutovetturaDAO();
				mod.setBrand( b.getModel().getBrand() );
				mod.setModel( b.getModel().getModel() );
				mod.setID();
			batt.setModel(mod);
			
			dao.setAvailableBatteries(batt);
		}
		
		return dao.update();
		
	}
	
}
