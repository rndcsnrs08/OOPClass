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
	
	//accessors. we also need access to static variables because they will be different
	//between subclasses	-Randolph Cisneros
	public LibraryMaterial getLibraryMaterial() {return book;}
	public String getTitle() {return book.getTitle();}
	public String getIsbn() {return book.getIsbn();}
	public LibraryCard getCard() {return card;}
	public LocalDate getDueDate() {return dueDate;}
	public double getFinePerDay(){ return FINE_PER_DAY; }
	public int getBorrowingPeriod() { return BORROWING_WEEKS; }
	
	public boolean checkOut(LibraryCard borrower, LocalDate dateOfBorrowing)
	
	/*checks book out by setting card reference to borrower.
	returns false if book is already checked out
	sets due date to BORROWING_WEEKS after current date passed 	-Randolph Cisneros */
	
	{
		if (card != null)
			return false;
		card = borrower;
		dueDate = dateOfBorrowing.plusWeeks(BORROWING_WEEKS);
		return true;
	}
	
	public boolean checkOut (LibraryCard borrower)
	//default check out method that uses todays' date	-Randolph Cisneros
	{
		return checkOut(borrower, LocalDate.now());
	}
	
	public boolean returnLibraryMaterial()
			//returns book by removing card reference
			//returns false if there is no reference to a card	-Randolph Cisneros
	{
		if (card == null)
			return false;
		card = null;
		return true;
	}
	
	public boolean renew (LocalDate renewalDate)
	//renews book using RENEWAL_WEEKS as interval
	//returns false if books is not checked out	-Randolph Cisneros
	{
		if (card == null)
			return false;
		dueDate = renewalDate.plusWeeks(RENEWAL_WEEKS);
		return true;
	}
	
	public boolean renew ()
	//default method uses todays date as renewal date	-Randolph Cisneros
	{
		return renew(LocalDate.now());
	}
	
	//users other class's method, which calls super class's print method	-Randolph Cisneros
	public void print()
	{
		book.print();
		LibraryCard c = getCard();
		LocalDate dD = getDueDate();
		System.out.println("Card: " + c.getCardholderName() + "Due Date: " + dD.toString());
	}

}
