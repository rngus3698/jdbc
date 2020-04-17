package book.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import book.model.dao.BookDao;
import book.model.vo.Book;


public class BookService {

	/*
	 * 
	 * service : 1. 컨트롤러로부터 매개변수로 정보를 전달 받는다.(사용자가 입력한 것과 관계된 정보)
	 * 			 2. Connection 객체를 생성한다.
	 * 			 3. 생성한 Connection 객체와 전달받은 매개변수로
	 * 				같이 DAO패키지에 있는 클래스의 메소드로 전달한다.
	 * 			 4. 수행 결과에 따른 트랜잭션(commit, rollback)을 관리한다.
	 */
	public ArrayList<Book> selectAllBooks() 
	{
		Connection conn = getConnection();
		
		BookDao bd = new BookDao();
		
		ArrayList<Book> list = bd.selectAllBooks(conn);
		
		close(conn);//Connection close
		
		return list;
	}

	public int insertBook(Book b) 
	{
		Connection conn = getConnection();
		
		BookDao bd = new BookDao();
		
		int result = bd.insertBook(conn, b);
		
		if(result > 0)
		{
			commit(conn);			
		}
		else
		{
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Book selectBook(int bId) {

		Connection conn = getConnection();
		BookDao bd = new BookDao();
		
		Book b = bd.selectBook(conn, bId);
		
		close(conn);
		
		return b;
	}

	public int deleteBook(int bId) {
		Connection conn = getConnection();
		
		BookDao bd = new BookDao();
		
		int result = bd.deleteBook(conn, bId);
		if(result > 0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
		}
		return result;
	}

	public int updateBook(int bId, Book b) {
		Connection conn = getConnection();
		
		BookDao bd = new BookDao();
		
		int result = bd.updateBook(conn, bId, b);
		
		if(result > 0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Book searchBook(String title) 
	{
		Connection conn = getConnection();
		
		BookDao bd = new BookDao();
		
		Book b = bd.searchBook(conn, title);
		
		close(conn);
		
		return b;
	}

	

}
