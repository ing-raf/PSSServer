package Server.BusinessLogic;

public class StazioneBL {
	
	private int ID;
	private String nome;
	private String indirizzo;
	
	public StazioneBL() {
		
	}
	
	public StazioneBL(int ID, String nome, String indirizzo) {
		this.setID(ID);
		this.setName(nome);
		this.setAddress(indirizzo);
	}
	
	public int getID() {
		return this.ID;
	}

	public void setID(int id) {
		this.ID = id;
	}

	public String getName() {
		return this.nome;
	}
	
	public void setName(String nome) {
		this.nome = nome;
	}

	public String getAddress() {
		return this.indirizzo;
	}

	public void setAddress(String indirizzo) {
		this.indirizzo = indirizzo;
	}
}