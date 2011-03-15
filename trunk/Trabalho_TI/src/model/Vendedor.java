package model;

public class Vendedor {
	
	private int cod_vendedor;
	private String login;
	private String senha;
	
	public Vendedor(){
		this(0,"","");
	}
	
	public Vendedor(int codVendedor, String login, String senha) {
		this.cod_vendedor = codVendedor;
		this.login = login;
		this.senha = senha;
	}
	
	public int getCod_vendedor() {
		return cod_vendedor;
	}
	public void setCod_vendedor(int codVendedor) {
		cod_vendedor = codVendedor;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
