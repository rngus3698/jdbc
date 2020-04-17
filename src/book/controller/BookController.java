package book.controller;

import java.util.ArrayList;

import book.model.service.BookService;
import book.model.vo.Book;
import book.view.BookMenu;

public class BookController {

	BookMenu bm = new BookMenu();
	
	public void selectAll() 
	{
		BookService bs = new BookService();
		
		ArrayList<Book> list = bs.selectAllBooks();
		
		if(list.isEmpty()) //★★★==null로 비교하면 안됨 Dao클래스에서 ArrayList는 객체를 만들고 시작함
		{
			System.out.println("검색 되는 도서가 없습니다.");
		}
		else
		{
			bm.displayBookTitle(list);
		}
	}

	public void insertBook(Book b) 
	{
		BookService bs = new BookService();
		
		int result = bs.insertBook(b);
		
		if(result > 0)
		{
			System.out.println("도서 정보 입력 완료");
		}
		else
		{
			bm.displayError("insert");
		}
		
	}

}
