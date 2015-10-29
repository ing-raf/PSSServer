package Server.Entity;

import java.util.ArrayList;
import java.util.Calendar;


import Server.DAO.AutovetturaCompatibileDAO;
import Server.DAO.ClienteDAO;


public class Cliente {
	
	private String nome;
	private String cognome;
	private Calendar dataNascita;
	private ArrayList<AutovetturaCompatibile> autovetturePossedute;
	
	public static Cliente getClient (String n, String s, Calendar d){
		
		ClienteDAO dao = ClienteDAO.findClient(n, s, d);
		
		return new Cliente (dao);
	}
	
	public Cliente (ClienteDAO dao){
		this.nome = dao.getName();
		this.cognome = dao.getSurname();
		this.dataNascita = dao.getBirthDate();
		this.autovetturePossedute = new ArrayList<AutovetturaCompatibile> ();
		for (AutovetturaCompatibileDAO a: dao.getOwnedCars()){
			this.autovetturePossedute.add(new AutovetturaCompatibile (a));
		}

	}
	
	public ClienteDAO prepareDAO (){
		ClienteDAO dao = new ClienteDAO ();
		dao.setID( ClienteDAO.findClient(this.nome, this.cognome, this.dataNascita).getID() );
		dao.setName(this.nome);
		dao.setSurname(this.cognome);
		dao.setDate(this.dataNascita);
		for(AutovetturaCompatibile a : this.autovetturePossedute){
			dao.setOwnedCars(a.prepareDAO());
		}
		return dao;
		
	}
	
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public String getName(){
		return this.nome;
	}
	
	public String getSurname(){
		return this.cognome;
	}
	
	public ArrayList<AutovetturaCompatibile> getOwnedCars() {
		return this.autovetturePossedute;
	}
	public Calendar getBirthDate(){
		return this.dataNascita;
	}
	
	public void setName(String n){
		this.nome = n;
	}

	public void setSurname(String s){
		this.cognome = s;
	}
	
	public void setBirthDate(Calendar date){
		this.dataNascita = date;
	}
	
	public boolean equals (Object obj){
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Cliente c = (Cliente) obj;  
		
		for (int i = 0; i < this.autovetturePossedute.size(); i++){
			if (!(c.getOwnedCars().get(i).equals(this.autovetturePossedute.get(i))))
				return false;	
		}
		
		if ((this.nome.equals(c.getName())) &&
				(this.cognome.equals(c.getSurname())) && 
				(this.dataNascita.equals(c.getBirthDate())) &&
				(this.autovetturePossedute.size() == c.getOwnedCars().size())) 
			return true;
		else
			return false;
	
	}
	

}
