package form;

import org.apache.struts.action.ActionForm;

public class CompraForm extends ActionForm{
	
	private static final long serialVersionUID = -1245113242367345460L;
	private int cpf;
	private int qtde;
	private int cod_produto;
	
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}
	public int getCod_produto() {
		return cod_produto;
	}
}
