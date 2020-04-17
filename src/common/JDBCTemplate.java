package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// 펙토리 패턴 : 외부에서 생성자를 통해 객체를 생성하지 않고 모두가 동일한 메소드를 호출하여 원하는 반환값을(Connection)을 동일하게 가져감
public class JDBCTemplate 
{
	//Connection, 트랜잭션 정의
	
	// 1. 드라이버 등록
	// 2. Connection 객체 생성 후 반환
	
	public static Connection getConnection()
	{
		Connection conn = null;
		Properties prop = new Properties();
		
		try 
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","STUDENT","STUDENT");
			
			prop.load(new FileReader("driver.properties"));
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//jdbc에서 사용하는 객체들 close
	public static void close(Statement stmt)
	{
		try 
		{
			if(stmt != null && !stmt.isClosed())
			{	
				stmt.close();
			} 
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset)
	{
		try 
		{
			if(rset != null && !rset.isClosed())
			{	
				rset.close();
			} 
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn)
	{
		try 
		{
			if(conn != null && !conn.isClosed())
			{	
				conn.close();
			} 
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//트렌젝션 처리
	public static void commit(Connection conn)
	{
		try 
		{
			if(conn != null & !conn.isClosed())
			{				
				conn.commit();
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn)
	{
		try 
		{
			if(conn != null & !conn.isClosed())
			{				
				conn.rollback();
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
