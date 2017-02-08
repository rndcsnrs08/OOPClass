import java.util.*;


public class Tester {
	public static void main(String[] args){
		
		Vector<BookCopy> bookList = new Vector<BookCopy>();
		
		Book catHat = new Book("Cat hat", "Seuss");
		Book lionWitch = new Book("Lion Witch", "Lewis");
		Book gatsby = new Book("Gatsby", "Fitzgerald");
		Book wonka = new Book("Wonka", "Dahl");
		Book greenEggs = new Book("Green Eggs", "Seuss");
		Book ender = new Book("Ender", "Card");
		Book quixote = new Book("Quixote", "Dunno");
		Book math = new Book("Math", "Freund");
		Book oop = new Book("OOP", "Java");
		Book tired = new Book("Tired", "Me");
		
		BookCopy cH = new BookCopy(catHat);
		BookCopy lW= new BookCopy(lionWitch);
		BookCopy gat= new BookCopy(gatsby);
		BookCopy gE = new BookCopy(greenEggs);
		BookCopy end = new BookCopy(ender);
		BookCopy qui = new BookCopy(quixote);
		BookCopy mat = new BookCopy(math);
		BookCopy oo = new BookCopy(oop);
		BookCopy tir = new BookCopy(tired);
		BookCopy won = new BookCopy(wonka);
		
		//I wanted to use vectors of bookCopies but that was more
		//complicated than necessary so I just did this
		bookList.add(cH);
		bookList.add(lW);
		bookList.add(gat);
		bookList.add(gE);
		bookList.add(end);
		bookList.add(qui);
		bookList.add(mat);
		bookList.add(oo);
		bookList.add(tir);
		bookList.add(won);
		bookList.add(cH);
		bookList.add(lW);
		bookList.add(gat);
		bookList.add(gE);
		bookList.add(end);
		bookList.add(qui);
		bookList.add(mat);
		bookList.add(oo);
		bookList.add(tir);
		bookList.add(won);
		
		for(BookCopy b: bookList){
			System.out.println(b.getTitle());
		}
		
		List<LibraryCard> userList = new ArrayList<LibraryCard>();
		LibraryCard bobSmith = new LibraryCard("Bob Smith");
		LibraryCard janeDoe = new LibraryCard("Jane Doe");
		LibraryCard johnDoe = new LibraryCard("John Doe");
		
		userList.add(bobSmith);
		userList.add(janeDoe);
		userList.add(johnDoe);
		
		for(LibraryCard u : userList)
			System.out.println(u.getName());
		System.out.println("Program completed");
	}
}