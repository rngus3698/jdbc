package book.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import book.model.vo.Book;

import static common.JDBCTemplate.*;

/*
 * DAO(Database Access Object) : DB와 연결되는 클래스로 CRUD와 관련된 쿼리 실행
 * 
 * C : create (INSERT)
 * R : read (SELECT)
 * U : update (UPDATE)
 * D : delete (DELETE)
 */
public class BookDao {

	public ArrayList<Book> selectAllBooks(Connection conn) 
	{
		ArrayList<Book> list = new ArrayList();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM BOOK";
		
		try 
		{
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			while(rset.next())
			{
				Book b = new Book();
				b.setBid(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPub(rset.getString("publisher"));
				b.setPub_date(rset.getString("publisher_date"));
				b.setPrice(rset.getInt("price"));
				
				list.add(b);
						
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			close(stmt);
			close(rset);
		}
		return list;
	}

}
