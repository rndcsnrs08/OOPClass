import java.util.Vector;

//I didn't create setters for any classes because it doesn't make sense to
//assign serial numbers and IDs to something that can be changed
public class LibraryCard {
	private int IDNumber;
	private static int counter = 1;
	private String name;
	private Vector<BookCopy> bookList = new Vector();
	
	public LibraryCard(String nm){
		IDNumber = counter;
		++counter;
		name = nm;
		bookList.removeAllElements();//make sure this is an actual function
	}
	public String getName() {return name;}
	public int getCard() {return IDNumber;}
	public void checkOut(String copyName){
		
	}
	
}