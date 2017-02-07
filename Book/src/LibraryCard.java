
import java.util.Vector;


public class LibraryCard {
	private int IDNumber;
	private static int counter = 1;
	private String name;
	private Vector<BookCopy> bookList = new Vector();
	
	public String getName() {return name;}
	public int getCard() {return IDNumber;}
	public void checkOut(String copyName){
		
	}
	
}
