package JDBC_study01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Demo07 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String sql = "INSERT INTO BOOK (ISBN, BOOK_NAME,PUBLICATION_DATE) VALUES(?,?,?)";
		try (Connection connction = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BOOKSHOP_JDBC","BOOKSHOP_JDBC");
				PreparedStatement ps = connction.prepareStatement(sql) ){
			
			
			
			for(int i=0; i<10; i++) {
				long rand = 1000000000+new Random().nextInt(1000000000);
				java.sql.Date date = new java.sql.Date(System.currentTimeMillis()-rand);
				ps.setObject(1, "a"+i);
				ps.setObject(2, "i");
				ps.setObject(3, date);		
				ps.execute();
			}
			
			
			connction.commit();

			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
