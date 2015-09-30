package Server.Entity;

import Server.DAO.BadgeDAO;

public class Badge {
	
	private int codice;
	private float creditoResiduo;
	private Cliente possessore;
	
	public Badge(int cod){
		
		BadgeDAO dao = BadgeDAO.findBadge(cod);
		this.codice = dao.getCode();
		this.creditoResiduo = dao.getCredit();
		this.possessore = new Cliente(dao.getClient().getName(),dao.getClient().getSurname(),dao.getClient().getBirthDate());

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
