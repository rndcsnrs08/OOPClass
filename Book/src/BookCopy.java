public class BookCopy {
	private Book title;
	private LibraryCard renter;
	
	public BookCopy(Book t){
		title = t;
		renter = null;
	}
	public void checkOut(LibraryCard r){
		if (renter == null)
			renter = r;
		else
		System.out.println("Checked out");
	}
	public void checkIn(){
		renter = null;
	}
	public String getTitle(){return title.getTitle();};
	private String getRenter(){return renter.getName();};// private to create a query of how has books checked out
}
