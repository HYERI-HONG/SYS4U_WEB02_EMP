package dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
  
	public static Connection getConnection() throws NamingException, SQLException {
		
		//JNDI(Java Naming Directory Interface)
		//도서관 책 찾는 프로그램에 비유
		//계층적으로 이름을 붙여서 객체를 관리하는 것
		 Context context = new InitialContext(); 
		 DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/orcl"); 
		 Connection connection = dataSource.getConnection();
		 
		 return connection;
	
	}
}
