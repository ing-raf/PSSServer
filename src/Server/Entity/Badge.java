package Server.Entity;

import Server.DAO.AutovetturaCompatibileDAO;
import Server.DAO.BadgeDAO;

public class Badge {
	
	private int codice;
	private float creditoResiduo;
	private Cliente possessore;
	
	public static Badge getBadge(int cod){
		
		BadgeDAO dao = BadgeDAO.findBadge(cod);
		return new Badge (dao);

	}
	
	public Badge(){
		
	}
	
	public Badge (BadgeDAO dao) {
		this.codice = dao.getCode();
		this.creditoResiduo = dao.getCredit();
		this.possessore = new Cliente (dao.getClient());
		
	}

	public BadgeDAO prepareDAO (){
		BadgeDAO dao = new BadgeDAO ();
		dao.setClient(this.getClient().prepareDAO());
		dao.setCode(this.codice);
		dao.setCredit(this.creditoResiduo);
		return dao;
	}
	public int getCode(){
		return this.codice;
	}
	
	public float getCredit(){
		return this.creditoResiduo;
	}
	
	public Cliente getClient(){
		return this.possessore;
	}
	
	public void setCode(int cod){
		this.codice = cod;
	}
	
	public void setCredit(float cred){
		this.creditoResiduo = cred;
	}
	
	public void setClient(Cliente cliente){
		this.possessore = cliente;
	}
	
	public boolean update(){
		
		BadgeDAO dao = BadgeDAO.findBadge(this.getCode());
		dao.setCredit(this.getCredit());
		
		return dao.update();
		
	}
}
