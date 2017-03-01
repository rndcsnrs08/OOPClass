import java.util.*;
import java.time.*;

public class DriverProgram {
	public static void main (String[] args) {

		Book catHat = new Book("001","Cat hat", "Seuss");
		Book lionWitch = new Book("002","Lion Witch", "Lewis");
		Book gatsby = new Book("003","Gatsby", "Fitzgerald");
		Book wonka = new Book("004","Wonka", "Dahl");
		Book greenEggs = new Book("005","Green Eggs", "Seuss");
		Book ender = new Book("006","Ender", "Card");
		Book quixote = new Book("007","Quixote", "Dunno");
		Book math = new Book("008","Math", "Freund");
		Book oop = new Book("009","OOP", "Java");
		Book tired = new Book("010","Tired", "Me");
		

		BookCopy lW= new BookCopy(lionWitch);
		BookCopy gat= new BookCopy(gatsby);
		BookCopy gE = new BookCopy(greenEggs);
		BookCopy end = new BookCopy(ender);
		BookCopy qui = new BookCopy(quixote);
		BookCopy mat = new BookCopy(math);
		BookCopy oo = new BookCopy(oop);
		BookCopy tir = new BookCopy(tired);
		BookCopy won = new BookCopy(wonka);
		
		LibraryCard bobSmith = new LibraryCard("01","Bob Smith");
		LibraryCard janeDoe = new LibraryCard("02","Jane Doe");
		LibraryCard johnDoe = new LibraryCard("03","John Doe");

		LocalDate today = LocalDate.now();
		LocalDate earlyDueDate = today.minusWeeks(5);

		
		//public void testRegCheckOut(LibraryCard user, BookCopy bc){
		//test regular checkOut
		System.out.println(janeDoe.checkOutBook(lW));
		System.out.println(lW.getDueDate());
		//}
		
		//public void testEarlyCheckOut(LibraryCard user, BookCopy bc, LocalDate earlyDate){
		//checkOut with early date	
		janeDoe.checkOutBook(end);
		janeDoe.checkOutBook(gat, earlyDueDate);
		janeDoe.checkOutBook(end, earlyDueDate);
		janeDoe.checkOutBook(gE, earlyDueDate);
		System.out.println(gat.getDueDate());
		//}

		//void testRenewDueDate(BookCopy bc){
		//tests renewDueDate
		gE.renewDueDate();
		System.out.println(gE.getDueDate());
		//}

		//tests list sort
		ArrayList<BookCopy> mainSortedList = janeDoe.sortList();
		traverseAndPrintDate(mainSortedList);

		ArrayList<BookCopy> lateBooks = janeDoe.isOverdue();
		traverseAndPrintDate(lateBooks);

		
	}

	public static void traverseAndPrintDate(ArrayList<BookCopy> bookList){
		for (int i = 0; i < bookList.size(); i++){
			BookCopy itBookCopy = bookList.get(i);
			Book itBook = itBookCopy.getBook();
			System.out.println(itBook.getTitle() + " " + itBookCopy.getDueDate());
		}
	}
}