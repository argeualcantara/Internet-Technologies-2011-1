package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	public ArrayList<Area> buscarAreas() {
		ArrayList<Area> listaArea = new ArrayList<Area>();
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
				Area a = new Area(id_area, descricao);
				listaArea.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaArea;
	}
}
