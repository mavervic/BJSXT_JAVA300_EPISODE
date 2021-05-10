package JDBC_study01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class Demo01 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String sql = "INSERT INTO BOOK (ISBN, BOOK_NAME,PUBLICATION_DATE) VALUES(?,?,?)";
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BOOKSHOP_JDBC","BOOKSHOP_JDBC");
				PreparedStatement statement = con.prepareStatement(sql); ){
			
			//勤勞工程師的寫法
//			statement.setString(1, "9780596009205");
//			statement.setString(2, "Head First Java");
//			statement.setDate(3, new Date(2020, Calendar.MAY, 31));
			
			//懶人工程師的寫法
			statement.setObject(1, "9780596009205");
			statement.setObject(2, "Head First Java");
			statement.setObject(3, new Date(2020, Calendar.MAY, 31));
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
