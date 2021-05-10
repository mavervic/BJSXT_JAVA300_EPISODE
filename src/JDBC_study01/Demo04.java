package JDBC_study01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Demo04 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String sql = "SELECT * FROM BOOK";
		try (Connection connction = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BOOKSHOP_JDBC","BOOKSHOP_JDBC");
				Statement statement = connction.createStatement(); ){
			connction.setAutoCommit(false);
			long start = new Date().getTime();
			for(int i=0; i<100000; i++) {
				statement.addBatch("DELETE FROM BOOK WHERE ISBN = 'you"+i+"'");
//				statement.addBatch("INSERT INTO BOOK (ISBN, BOOK_NAME) VALUES('you"+i+"', 6666)");
			}
			statement.executeBatch();
			connction.commit();
			
			long end = new Date().getTime();
			System.out.println(end-start);
			

			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
