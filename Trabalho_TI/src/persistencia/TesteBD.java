package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Teste;

public class TesteBD {

private static TesteBD instance;
	
	public static TesteBD getInstance() {
		if (instance == null) {
			instance = new TesteBD();
		}
		return instance;
	}
	
	public Teste buscar(int id) {
		Teste teste = new Teste();
		try {
			String sql = "SELECT * FROM TESTE WHERE ID="+id;

			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			
			while (rs.next()) {
				teste.setDesc(rs.getString("DESC"));
				teste.setId(rs.getInt("ID"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		BD.closeCon();
		return teste;
	}
	
}
