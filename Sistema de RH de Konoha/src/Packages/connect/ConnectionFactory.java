package Packages.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String url = "jdbc:mysql://konoha-db.chdovoqaowqk.us-east-1.rds.amazonaws.com:3306/db_system?useTimezone=true&serverTimezone=UTC"; 
	private static final String user = "admin"; 
	private static final String pass = "hashirama"; 
	
	public static Connection getConnection() {
        try {
        	return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o Banco de Dados!",e);
        }
	}

	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);
		
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
