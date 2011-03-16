package model;

public class Produto {
	
	private int cod_produto;
	private String nome;
	private String descricao;
	private int cod_area;
	private int quantidade;
	private int quantidade_vendida;
	private double valor_unitario;
	private String login;
	
	public Produto() {
		this(0,"","",0,0,0,0.0,"");
	}
	
	public Produto(int codProduto, String nome, String descricao, int codArea,
			int quantidade, int quantidadeVendida, double valorUnitario,
			String login) {
		super();
		cod_produto = codProduto;
		this.nome = nome;
		this.descricao = descricao;
		cod_area = codArea;
		this.quantidade = quantidade;
		quantidade_vendida = quantidadeVendida;
		valor_unitario = valorUnitario;
		this.login = login;
	}



	public int getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(int codProduto) {
		cod_produto = codProduto;
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
	public void setCod_area(int codArea) {
		cod_area = codArea;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getQuantidade_vendida() {
		return quantidade_vendida;
	}

	public void setQuantidade_vendida(int quantidadeVendida) {
		quantidade_vendida = quantidadeVendida;
	}

	public double getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(double valorUnitario) {
		valor_unitario = valorUnitario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
}
