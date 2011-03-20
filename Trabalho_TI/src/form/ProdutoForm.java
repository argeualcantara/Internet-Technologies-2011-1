package form;

import org.apache.struts.action.ActionForm;

public class ProdutoForm extends ActionForm{
	private static final long serialVersionUID = 7024081834137487769L;
	
	private int cod_produto;
	private String nome;
	private String descricao;
	private int cod_area;
	private int quantidade;
	private double valor_unitario;
	private String login;
	private String [] marcados;
	
	public ProdutoForm(){
		cod_produto = 0;
	}
	
	public String[] getMarcados() {
		return marcados;
	}
	public void setMarcados(String[] marcados) {
		this.marcados = marcados;
	}
	public int getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCod_area() {
		return cod_area;
	}
	public void setCod_area(int cod_area) {
		this.cod_area = cod_area;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getLogin() {
		return login;
	}
}
