
public class Book {
	private String title;
	private String author;
	private static int counter = 1;
	private int ISBN;
	
	public Book (String t, String a){
		title = t;
		author = a;
		ISBN = counter;
		++counter;
	}
	
	public String getTitle(){return title;}
	public String getAuthor(){return author;}
	public int getSerial(){return ISBN;}
}
