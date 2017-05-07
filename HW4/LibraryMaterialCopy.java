// Sample solution for HW1
import java.time.LocalDate;

public abstract class LibraryMaterialCopy {
	
	protected LibraryCard card;
	protected LocalDate dueDate;
	
	public LibraryMaterialCopy()
	{
		card = null;
		dueDate = null;
	}
	
	public abstract LibraryMaterial getLibraryMaterial();
	public abstract String getTitle();
	public abstract String getISBN();
	public abstract int getBorrowingWeeks();
	public abstract double getFinePerDay();
	public abstract boolean isRenewable();
	public abstract boolean equalTitle();
	
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
		dueDate = dateOfBorrowing.plusWeeks(getBorrowingWeeks());
		return true;
	}
	
	public boolean checkOut (LibraryCard borrower)
	//default check out method that uses todays' date
	{
		return checkOut(borrower, LocalDate.now());
	}
	
	public boolean returnCopy ()
			//returns book by removing card reference
			//returns false if there is no reference to a card
	{
		if (card == null)
			return false;
		card = null;
		return true;
	}
	
	public void print()
	{
		if (card != null)
		{
			System.out.println("Checked out to: " + card.getCardholderName() + ", " + card.getID());
			System.out.println("Due: " + dueDate);
		}
	}
	
		

}
