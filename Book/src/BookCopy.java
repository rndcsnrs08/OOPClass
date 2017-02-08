import java.util.Vector;


public class BookCopy extends Vector {
	private Book title;
	private LibraryCard renter;
	
	public BookCopy(Book t){
		title = t;
		renter = null;
	}
	public checkOut(LibraryCard r){
		renter = r;
	}
	public checkIn(){
		renter = null;
	}
}
