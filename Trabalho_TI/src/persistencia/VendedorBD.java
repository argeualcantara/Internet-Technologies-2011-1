package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Vendedor;

public class VendedorBD {
	
private static VendedorBD instance;
	
	public static VendedorBD getInstance() {
		if (instance == null) {
			instance = new VendedorBD();
		}
		return instance;
	}
	
	public boolean logar(String login, String senha){
		
		if(login==null || senha==null){
			return false;
		}
		
		if(login.equals("master") && senha.equals("master")){
			return true;
		}
		
		try {
			String sql = "SELECT * FROM VENDEDOR";

			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			
			while (rs.next()) {
				String loginBD=rs.getString("login");
				String senhaBD=rs.getString("senha");
				
				if(login.equals(loginBD) && senha.equals(senhaBD)){
					return true;
				}
				
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void inserir(final Vendedor vendedor) {
		try {
			String sql = "INSERT INTO VENDEDOR (LOGIN, SENHA) VALUES (?,?)";

			Connection con = null;
			PreparedStatement st = null;

			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setString(1, vendedor.getLogin());
			st.setString(2, vendedor.getSenha());
			st.executeUpdate();
			BD.closeCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean validarNomeLogin(String login){
		
		if(login==null){
			return false;
		}
		
		if(login.equals("master")){
			return false;
		}
		
		try {
			String sql = "SELECT * FROM VENDEDOR";

			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			
			while (rs.next()) {
				String loginBD=rs.getString("login");
				
				if(login.equals(loginBD)){
					return false;
				}
				
				
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return true;
	}
	
}
