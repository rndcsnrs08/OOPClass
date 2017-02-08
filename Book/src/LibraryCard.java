
import java.util.Vector;


public class LibraryCard {
	private int IDNumber;
	private static int counter = 1;
	private String name;
	private Vector<BookCopy> bookList = new Vector();
	
	public LibraryCard(String nm){
		IDNumber = counter;
		++counter;
		name = nm;
		bookList = empty();//make sure this is an actual function
	}
	public String getName() {return name;}
	public int getCard() {return IDNumber;}
	public void checkOut(String copyName){
		
	}
	
}
