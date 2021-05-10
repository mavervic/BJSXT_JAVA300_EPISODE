package JDBC_study01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class Demo05_CreateBigData {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String sql = "SELECT * FROM BOOK";
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BOOKSHOP_JDBC","BOOKSHOP_JDBC");
				PreparedStatement statement = con.prepareStatement(sql); ){
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getObject(1)+"---"+rs.getObject(2)+"---");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
