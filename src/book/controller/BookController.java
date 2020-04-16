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
		
		if(list.isEmpty()) //★★★==null로 비교하면 안됨
		{
			System.out.println("검색 되는 도서가 없습니다.");
		}
		else
		{
			bm.displayBookTitle(list);
		}
	}

}
