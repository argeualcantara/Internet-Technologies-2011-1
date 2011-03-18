package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Area;

import model.Produto;

public class ProdutoBD {

private static ProdutoBD instance;
	
	public static ProdutoBD getInstance() {
		if (instance == null) {
			instance = new ProdutoBD();
		}
		return instance;
	}
	
	public void inserir(final Produto produto) {
		try {
			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO, COD_AREA, VALOR_UNITARIO, LOGIN, QUANTIDADE, QUANTIDADE_VENDIDA) VALUES (?,?,?,?,?,?,?)";

			Connection con = null;
			PreparedStatement st = null;

			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setString(1, produto.getNome());
			st.setString(2, produto.getDescricao());
			st.setInt(3, produto.getCod_area());
			st.setDouble(4, produto.getValor_unitario());
			st.setString(5, produto.getLogin());
			st.setInt(6, produto.getQuantidade());
			st.setInt(7, 0);
			st.executeUpdate();
			BD.closeCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Produto buscarProduto(int cod){
		
		Produto produto = new Produto();
		try {
			String sql = "SELECT * FROM PRODUTO WHERE COD_PRODUTO = ?";

			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setInt(1, cod);
			rs = st.executeQuery();
			
			while (rs.next()) {
				int cod_produto = rs.getInt("cod_produto");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				int cod_area = rs.getInt("cod_area");
				int quantidade = rs.getInt("quantidade");
				int quantidade_vendida = rs.getInt("quantidade_vendida");
				double valor_unitario = rs.getDouble("valor_unitario");
				produto= new Produto(cod_produto, nome, descricao, cod_area, quantidade, quantidade_vendida, valor_unitario, "");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return produto;
	}
	
	public void mudarEstoque(final Produto produto, int quantidade){
		try {
			String sql = "UPDATE PRODUTO SET QUANTIDADE = ? WHERE COD_PRODUTO = ?";

			Connection con = null;
			PreparedStatement st = null;

			quantidade = produto.getQuantidade() + quantidade;
			
			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setInt(1, quantidade);
			st.setInt(2, produto.getCod_produto());
			st.executeUpdate();
			BD.closeCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void vender(final Produto produto, int quantidade){
		try {
			String sql = "UPDATE PRODUTO SET QUANTIDADE = ?, QUANTIDADE_VENDIDA = ? WHERE COD_PRODUTO = ?";

			Connection con = null;
			PreparedStatement st = null;

			quantidade = produto.getQuantidade() - quantidade;
			int quantidade_vendida = produto.getQuantidade_vendida() + quantidade;
			
			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setInt(1, quantidade);
			st.setInt(2, quantidade_vendida);
			st.setInt(3, produto.getCod_produto());
			st.executeUpdate();
			BD.closeCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Area> listarAreas(){
		List<Area> list = new ArrayList<Area>();
		
		try {
			String sql = "SELECT * FROM AREA";

			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				int id_area = rs.getInt("id_area");
				String descricao = rs.getString("descricao");
				list.add(new Area(id_area, descricao));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Produto> listarProdutos(String login){
		List<Produto> list = new ArrayList<Produto>();
		
		try {
			String sql = "SELECT * FROM PRODUTO WHERE LOGIN = ?";

			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setString(1, login);
			rs = st.executeQuery();
		
			while (rs.next()) {
				int cod_produto = rs.getInt("cod_produto");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				int cod_area = rs.getInt("cod_area");
				int quantidade = rs.getInt("quantidade");
				int quantidade_vendida = rs.getInt("quantidade_vendida");
				double valor_unitario = rs.getDouble("valor_unitario");
				list.add(new Produto(cod_produto, nome, descricao, cod_area, quantidade, quantidade_vendida, valor_unitario, login));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Produto> listarProdutos(String login, int cod){
		List<Produto> list = new ArrayList<Produto>();
		
		try {
			String sql = "SELECT * FROM PRODUTO WHERE LOGIN = ? AND COD_AREA = ?";

			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setString(1, login);
			st.setInt(2, cod);
			rs = st.executeQuery();
		
			while (rs.next()) {
				int cod_produto = rs.getInt("cod_produto");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				int cod_area = rs.getInt("cod_area");
				int quantidade = rs.getInt("quantidade");
				int quantidade_vendida = rs.getInt("quantidade_vendida");
				double valor_unitario = rs.getDouble("valor_unitario");
				list.add(new Produto(cod_produto, nome, descricao, cod_area, quantidade, quantidade_vendida, valor_unitario, login));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Produto> listarProdutos(String login, String n){
		List<Produto> list = new ArrayList<Produto>();
		
		try {
			String sql = "SELECT * FROM PRODUTO WHERE LOGIN = ? AND NOME LIKE '%"+n+"%'";

			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setString(1, login);		
			rs = st.executeQuery();
		
			while (rs.next()) {
				int cod_produto = rs.getInt("cod_produto");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				int cod_area = rs.getInt("cod_area");
				int quantidade = rs.getInt("quantidade");
				int quantidade_vendida = rs.getInt("quantidade_vendida");
				double valor_unitario = rs.getDouble("valor_unitario");
				list.add(new Produto(cod_produto, nome, descricao, cod_area, quantidade, quantidade_vendida, valor_unitario, login));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Produto> listarProdutos(String login, int cod, String n){
		List<Produto> list = new ArrayList<Produto>();
		
		try {
			String sql = "SELECT * FROM PRODUTO WHERE LOGIN = ? AND COD_AREA = ? AND NOME LIKE '%"+n+"%'";
			
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			
			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setString(1, login);
			st.setInt(2, cod);
			rs = st.executeQuery();
			
			while (rs.next()) {
				int cod_produto = rs.getInt("cod_produto");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				int cod_area = rs.getInt("cod_area");
				int quantidade = rs.getInt("quantidade");
				int quantidade_vendida = rs.getInt("quantidade_vendida");
				double valor_unitario = rs.getDouble("valor_unitario");
				list.add(new Produto(cod_produto, nome, descricao, cod_area, quantidade, quantidade_vendida, valor_unitario, login));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	public List<Produto> listarProdutosCliente(String nome) {
		List<Produto> list = new ArrayList<Produto>();
		
		try {
			String sql = "SELECT * FROM PRODUTO WHERE NOME LIKE ? ";
			
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			
			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setString(1, "%"+nome+"%");
			
			rs = st.executeQuery();
			
			while (rs.next()) {
				int cod_produto = rs.getInt("cod_produto");
				String nomeProd = rs.getString("nome");
				String login=rs.getString("login");
				String descricao = rs.getString("descricao");
				int cod_area = rs.getInt("cod_area");
				int quantidade = rs.getInt("quantidade");
				int quantidade_vendida = rs.getInt("quantidade_vendida");
				double valor_unitario = rs.getDouble("valor_unitario");
				list.add(new Produto(cod_produto, nomeProd, descricao, cod_area, quantidade, quantidade_vendida, valor_unitario,login));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	public List<Produto> listarProdutosCliente(int cod_area) {
		List<Produto> list = new ArrayList<Produto>();
		
		try {
			String sql = "SELECT * FROM PRODUTO WHERE COD_AREA = ?";

			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setInt(1, cod_area);
			
			rs = st.executeQuery();
		
			while (rs.next()) {
				int cod_produto = rs.getInt("cod_produto");
				String nome = rs.getString("nome");
				String login=rs.getString("login");
				String descricao = rs.getString("descricao");
				int cod_areaProd = rs.getInt("cod_area");
				int quantidade = rs.getInt("quantidade");
				int quantidade_vendida = rs.getInt("quantidade_vendida");
				double valor_unitario = rs.getDouble("valor_unitario");
				list.add(new Produto(cod_produto, nome, descricao, cod_areaProd, quantidade, quantidade_vendida, valor_unitario, login));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	public List<Produto> listarProdutosCliente(int cod_area, String nome) {
List<Produto> list = new ArrayList<Produto>();
		
		try {
			String sql = "SELECT * FROM PRODUTO WHERE COD_AREA = ? AND NOME LIKE '%"+nome+"%'";
			
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			
			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setInt(1, cod_area);
			
			rs = st.executeQuery();
			
			while (rs.next()) {
				int cod_produto = rs.getInt("cod_produto");
				String nomeProd = rs.getString("nome");
				String login=rs.getString("login");
				String descricao = rs.getString("descricao");
				int cod_areaProd = rs.getInt("cod_area");
				int quantidade = rs.getInt("quantidade");
				int quantidade_vendida = rs.getInt("quantidade_vendida");
				double valor_unitario = rs.getDouble("valor_unitario");
				list.add(new Produto(cod_produto, nomeProd, descricao, cod_areaProd, quantidade, quantidade_vendida, valor_unitario, login));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
}
