import java.util.ArrayList;
import java.util.List;

public class mainProgram {

	public static void main(String[] args) {
		ArrayList<LibraryMaterial> books = new ArrayList<LibraryMaterial>();
		books.add(new Book("12345678910", "Harry Potter", "J. K. Rowling"));
		books.add (new Book ("98765432", "Berenstein Bears", "Stan and Jan"));
		books.add (new Book ("6547901", "Curious George", "No Clue"));
		books.add (new Book("5678322222", "Samantha", "Me Myself"));
		
		ArrayList<LibraryMaterialCopy> bookCopies = new ArrayList<LibraryMaterialCopy>();
	
		for (LibraryMaterial b: books)
		{
			bookCopies.add(new BookCopy ((Book)b));
			bookCopies.add(new BookCopy ((Book)b));

		}
		
		ArrayList<LibraryCard> cards = new ArrayList();
		cards.add(new LibraryCard ("123456", "Devorah Kletenik"));
		cards.add (new LibraryCard ("87654", "Me and Me"));
		cards.add (new LibraryCard ("8887654", "Sarah Kletenik"));
		
		for (LibraryMaterialCopy bc: bookCopies)
		{
			System.out.println(cards.get(0).checkOutLibraryMaterial(bc));
			System.out.println(cards.get(1).checkOutLibraryMaterial(bc));
			System.out.println(cards.get(2).checkOutLibraryMaterial(bc));
			
		}
		
		List<LibraryMaterialCopy> bookCopies2 = cards.get(0).getLibraryMaterialsSorted();
		for (LibraryMaterialCopy book: bookCopies2)
			System.out.println(book.getTitle() + " " + book.getDueDate());
		
		System.out.println("got here");

		System.out.println(bookCopies.get(3).getTitle());
		((BookCopy)bookCopies.get(3)).renew();
		
		System.out.println("renewed");
		
		bookCopies2 = cards.get(0).getLibraryMaterialsSorted();
		System.out.println("and here again");
		for (LibraryMaterialCopy book: bookCopies2)
			System.out.println(book.getTitle() + " " + book.getDueDate());
		
		System.out.println("here again");
		
		
		for (LibraryMaterialCopy bc: bookCopies)
		{
			System.out.println(cards.get(0).returnLibraryMaterial(bc));
			System.out.println(cards.get(1).returnLibraryMaterial(bc));
			System.out.println(cards.get(2).returnLibraryMaterial(bc));
		}
				

	}

}
