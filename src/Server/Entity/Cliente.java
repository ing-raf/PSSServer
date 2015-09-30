package Server.Entity;

import java.util.Calendar;

import Server.DAO.ClienteDAO;


public class Cliente {
	
	private String nome;
	private String cognome;
	private Calendar dataNascita;
	
	public Cliente(String n, String s, Calendar d){
		
		ClienteDAO dao = ClienteDAO.findClient(n, s, d);
		this.nome = dao.getName();
		this.cognome = dao.getSurname();
		this.dataNascita = dao.getBirthDate();

	}
	
	public String getName(){
		return this.nome;
	}
	
	public String getSurname(){
		return this.cognome;
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
	

}
