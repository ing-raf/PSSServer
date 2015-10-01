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
	private List<Batteria> disponibili;
	
	public Stazione(int cod){
		StazioneDAO dao = StazioneDAO.findStation(cod);
		this.ID = dao.getID();
		this.nome = dao.getName();
		this.indirizzo = dao.getAddress();
		this.disponibili = new ArrayList<Batteria> ();
		for (BatteriaDAO b: dao.getAvailableBatteries()){
			Batteria batt = new Batteria ();
			batt.setID(b.getID());
			batt.setCostSubstitution(b.getCostSubstitution());
			batt.setCyclesRecharge(b.getCyclesRecharge());
			ModelloAutovettura mod = new ModelloAutovettura ();
			mod.setBrand(b.getModel().getBrand());
			mod.setModel(b.getModel().getModel());
			batt.setModel(mod);
			this.disponibili.add(batt);
		}
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
	
	public void removeBattery (Batteria vecchia){
		if (vecchia == null ) System.err.println("lota");
		else if (this.disponibili == null) System.err.println("merda");
		for (Batteria b: this.disponibili){
			if (b.equals(vecchia))
				this.disponibili.remove(vecchia);
			
		}
		
	}
	
	public boolean update(){
		
		StazioneDAO dao = StazioneDAO.findStation(this.getID());
		dao.setAddress(this.getAddress());
		dao.setID(this.getID());
		dao.setName(this.getName());
		
		for(int i=0; i<this.getAvailableBatteries().size(); i++){
			BatteriaDAO batt = new BatteriaDAO();
			batt.setID( this.getAvailableBatteries().get(i).getID() );
			batt.setCostSubstitution( this.getAvailableBatteries().get(i).getCostSubstitution() );
			batt.setCyclesRecharge( this.getAvailableBatteries().get(i).getCyclesRecharge() );
				ModelloAutovetturaDAO mod = new ModelloAutovetturaDAO();
				mod.setBrand( this.getAvailableBatteries().get(i).getModel().getBrand() );
				mod.setModel( this.getAvailableBatteries().get(i).getModel().getModel() );
			batt.setModel(mod);
			
			dao.setAvailableBatteries(batt);
		}
		return dao.update();
		
	}
	
}
