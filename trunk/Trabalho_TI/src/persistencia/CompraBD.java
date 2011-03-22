package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Compra;
import model.Produto;

public class CompraBD {
	
private static CompraBD instance;
	
	public static CompraBD getInstance() {
		if (instance == null) {
			instance = new CompraBD();
		}
		return instance;
	}
	
	public List<Produto> buscarCompras(int cpf){
		
		List<Produto> list = new ArrayList<Produto>();
		
		try {
			String sql="select p.nome,p.descricao,p.valor_unitario,c.qtde from" +
					" compra c, produto p " +
					"where c.cod_produto=p.cod_produto and c.cpf=? ;";

			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setInt(1, cpf);
			rs = st.executeQuery();
		
			while (rs.next()) {
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				int quantidade = rs.getInt("qtde");
				double valor_unitario = rs.getDouble("valor_unitario");
				list.add(new Produto(0, nome, descricao, 0, quantidade, 0, valor_unitario, ""));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
		
	}
	
	public void comprar(Compra compra){
		
		try {
			Connection con = null;
			PreparedStatement st = null;
			
			String sql = "INSERT INTO COMPRA (CPF,QTDE,COD_PRODUTO) VALUES(?,?,?)";
			
			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setInt(1, compra.getCpf());
			st.setInt(2, compra.getQtde());
			st.setInt(3, compra.getCod_produto());
			
			st.executeUpdate();
			
			sql = "UPDATE PRODUTO SET QUANTIDADE=QUANTIDADE-?, QUANTIDADE_VENDIDA=? WHERE COD_PRODUTO = ?";
			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setInt(1, compra.getQtde());
			st.setInt(2, compra.getQtde());
			st.setInt(3, compra.getCod_produto());
			
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
