// Sample solution for HW2
import java.time.LocalDate;

public class BookCopy extends LibraryMaterialCopy {
	public static final int BORROWING_WEEKS = 3;
	public static final int RENEWAL_WEEKS = 2;
	public static final double FINE_PER_DAY = .10;
	private Book book;
	private LibraryCard card;
	private LocalDate dueDate;
	
	public BookCopy(Book b)
	{
		book = b;
		card = null;
		dueDate = null;
	}
	
	//****Make sure this doesn't return ERRORS; same for other abstract classes
	public LibraryMaterial getLibraryMaterial() {return book;}
	public String getTitle() {return book.getTitle();}
	public String getIsbn() {return book.getIsbn();}
	
	public LibraryCard getCard() {return card;}
	public LocalDate getDueDate() {return dueDate;}
	
	public boolean checkOut(LibraryCard borrower, LocalDate dateOfBorrowing)
	
	/*checks book out by setting card reference to borrower.
	returns false if book is already checked out
	sets due date to BORROWING_WEEKS after current date passed */
	
	{
		if (card != null)
			return false;
		card = borrower;
		dueDate = dateOfBorrowing.plusWeeks(BORROWING_WEEKS);
		return true;
	}
	
	public boolean checkOut (LibraryCard borrower)
	//default check out method that uses todays' date
	{
		return checkOut(borrower, LocalDate.now());
	}
	
	public boolean returnBook()
			//returns book by removing card reference
			//returns false if there is no reference to a card
	{
		if (card == null)
			return false;
		card = null;
		return true;
	}
	
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
	
	//make sure these print methods compile
	public void print()
	{
		book.print();
		System.out.println("Card: " + getCard() + "Due Date: " + getDueDate());
	}

}
