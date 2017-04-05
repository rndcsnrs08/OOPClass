import java.time.LocalDate;

public abstract class LibraryMaterialCopy {
	private LibraryCard card;
	private LocalDate dueDate;
	
	//THIS METHOD MAY CAUSE AN ERROR!!! KEEP THIS IN MIND
	public LibraryMaterialCopy() {
		card = null;
		dueDate = null;
	}
	
	abstract LibraryMaterial getLibraryMaterial();
	abstract String getTitle();
	abstract String getISBN();
	abstract LocalDate getDueDate();
	abstract boolean returnLibraryMaterial();
	abstract boolean renew();
	abstract boolean renew(LocalDate);

	//abstract helper methods for polymorphism
	abstract double getFinePerDay();
	abstract int getBorrowingPeriod();
	
	//taken straight from BookCopy; may need to set to an empty code block.
	abstract boolean checkOut(LibraryCard borrower, LocalDate dateOfBorrowing)
	
	/*checks book out by setting card reference to borrower.
	returns false if book is already checked out
	sets due date to BORROWING_WEEKS after current date passed */
	
	{
		if (card != null)
			return false;
		card = borrower;
		dueDate = dateOfBorrowing.plusWeeks(getBorrowingPeriod());		//set getBorrowingPeriod() for abstract methods
		return true;
	}
	
	abstract boolean checkOut (LibraryCard borrower)
	//default check out method that uses todays' date
	{
		return checkOut(borrower, LocalDate.now());
	}
	
	
}
