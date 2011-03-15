package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Produto;

public class ProdutoBD {

private static ProdutoBD instance;
	
	public static ProdutoBD getInstance() {
		if (instance == null) {
			instance = new ProdutoBD();
		}
		return instance;
	}
	
//	private int cod_produto;
//	private String nome;
//	private String descricao;
//	private int cod_area;
//	private int quantidade;
//	private double valor_unitario;
	
	public void inserir(final Produto produto) {
		try {
			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO, COD_AREA, VALOR_UNITARIO, LOGIN) VALUES (?,?)";

			Connection con = null;
			PreparedStatement st = null;

			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setString(1, produto.getNome());
			st.setString(2, produto.getDescricao());
			st.setInt(3, produto.getCod_area());
			st.setDouble(4, produto.getValor_unitario());
			st.setString(5, produto.getNome());
			st.setString(6, produto.getLogin());
			st.executeUpdate();
			BD.closeCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
