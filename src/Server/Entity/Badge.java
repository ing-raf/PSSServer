package Server.Entity;


import Server.DAO.BadgeDAO;

public class Badge {
	
	private int codice;
	private float creditoResiduo;
	private Cliente possessore;
	
	static Badge getBadge(int cod){
		
		BadgeDAO dao = BadgeDAO.findBadge(cod);
		return new Badge (dao);

	}
	
	Badge(){
		
	}
	
	Badge (BadgeDAO dao) {
		this.codice = dao.getCode();
		this.creditoResiduo = dao.getCredit();
		this.possessore = new Cliente (dao.getClient());
		
	}

	public BadgeDAO prepareDAO (){
		BadgeDAO dao =  new BadgeDAO ();
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
		
		BadgeDAO dao = new BadgeDAO();
		dao.setCode(this.getCode());
		dao.setClient(this.getClient().prepareDAO());
		dao.setCredit(this.getCredit());
		
		return dao.update();
		
	}
	
	public boolean equals (Object obj){
		Badge b = (Badge) obj;  
		if ((b.getCode() == this.codice) &&
				(Float.compare(b.getCredit(), this.creditoResiduo) == 0) && 
				(b.getClient().equals(this.possessore))) 
			return true;
		else
			return false;
		}
}
