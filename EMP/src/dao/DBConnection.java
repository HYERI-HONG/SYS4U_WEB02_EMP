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
		//������ å ã�� ���α׷��� ����
		//���������� �̸��� �ٿ��� ��ü�� �����ϴ� ��
		 Context context = new InitialContext(); 
		 DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/orcl"); 
		 Connection connection = dataSource.getConnection();
		 
		 return connection;
	
	}
}
