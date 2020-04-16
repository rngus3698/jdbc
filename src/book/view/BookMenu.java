package book.view;

import java.util.ArrayList;
import java.util.Scanner;

import book.controller.BookController;
import book.model.vo.Book;

public class BookMenu {

	public void displayMenu() 
	{
		Scanner sc = new Scanner(System.in);
		BookController bc = new BookController();
		do
		{
			System.out.println("***도서 관리 프로그램***");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 정보 수정");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 아이디로 조회");
			System.out.println("5. 도서 제목으로 조회");
			System.out.println("6. 도서 목록 전체 조회");
			System.out.println("9. 끝내기");
			System.out.print("번호 선택 : ");
			
			int no = sc.nextInt();
			
			switch(no)
			{
			case 1:
				System.out.println("1번 눌렀네");
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				bc.selectAll();
				break;
			case 9:
				
				return;
				
			default:
					System.out.println("번호를 잘못 누르셨습니다.");
			}
		}while(true);
	}

	public void displayBookTitle(ArrayList<Book> list) 
	{
		// 단순 for문
		for(int i = 0; i<list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}

}
