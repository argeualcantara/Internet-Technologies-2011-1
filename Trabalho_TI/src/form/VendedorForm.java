package form;

import org.apache.struts.action.ActionForm;

public class VendedorForm extends ActionForm{
	private static final long serialVersionUID = 5645506817976300250L;

	private int cod_vendedor;
	private String login;
	private String senha;
	private String senhaCheck;
	
	public int getCod_vendedor() {
		return cod_vendedor;
	}
	public void setCod_vendedor(int cod_vendedor) {
		this.cod_vendedor = cod_vendedor;
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
	public void setSenhaCheck(String senhaCheck) {
		this.senhaCheck = senhaCheck;
	}
	public String getSenhaCheck() {
		return senhaCheck;
	}
	
}
