package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

    private static final String URL = "jdbc:mysql://localhost/trabalho_ti";   
    private static final String DRIVER = "com.mysql.jdbc.Driver";   
    private static final String USUARIO = "root";   
    private static final String SENHA = "root";   
	private static Connection con;
    
    public static Connection getCon() throws SQLException{   
       try{   
           Class.forName( DRIVER );   
           con = DriverManager.getConnection(URL,USUARIO,SENHA);  
           return  con;
       }   
       catch (ClassNotFoundException e ) {   
           throw new SQLException( e.getMessage());   
       }   
    }
    
    public static void closeCon(){   
           try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }  
}
