package ORM_study01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo01 {

	public static void main(String[] args) {
		String sql = "SELECT * FROM BOOK";		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BOOKSHOP_JDBC","BOOKSHOP_JDBC");
				PreparedStatement ps  = conn.prepareStatement(sql);){
			
			ps.execute();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3)+" ");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
