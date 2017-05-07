import java.time.*;

public class BookCopy extends LibraryMaterialCopy {
	private Book book;
	public static final int BORROWING_WEEKS = 3;
	public static final int RENEWAL_WEEKS = 2;
	public static final double FINE_PER_DAY = .10;
	public static final boolean IS_RENEWABLE = true;

	
	public BookCopy(Book b)
	{
		super();
		book = b;
	}
	
	@Override
	public LibraryMaterial getLibraryMaterial() {
		return book;
	}
	
	@Override
	public int getBorrowingWeeks() {return BORROWING_WEEKS;}
	
	@Override
	public double getFinePerDay() {return FINE_PER_DAY;}
	
	@Override
	public String getTitle(){return book.getTitle();}
	
	@Override
	public String getISBN(){return book.getISBN();}
	public String getAuthor() {return book.getAuthor();}
	
	@Override
	public boolean isRenewable(){return IS_RENEWABLE;}
	
	public boolean renew (LocalDate renewalDate)
	//renews book using RENEWAL_WEEKS as interval
	//returns false if books is not checked out
	{
		if (card == null)
			return false;
		dueDate = renewalDate.plusWeeks(RENEWAL_WEEKS);
		return true;
	}
	
	public boolean renew ()
	//default method uses todays date as renewal date
	{
		return renew(LocalDate.now());
	}
	
	public void print()
	{
		book.print();
		super.print();
	}
	
	//implementing so that a string is still passed to equalTitle. LibraryMaterialCopy will have to pass getTitle() as parameter
	public boolean equalTitle(String s){
		if (book.getTitle() == s)
			return true;
		return false;
	}
	


}
