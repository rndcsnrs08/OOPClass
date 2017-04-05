// Sample solution for HW2
import java.time.LocalDate;

public class DVDCopy extends LibraryMaterialCopy {
	public static final int BORROWING_WEEKS = 2;
	public static final double FINE_PER_DAY = 1.00;
	private DVD dvd;
	private LibraryCard card;
	private LocalDate dueDate;
	
	public DVDCopy(DVD d)
	{
		dvd = d;
		card = null;
		dueDate = null;
	}
	
	//Again, make sure abstract methods don't return ERRORS!!!
	public LibraryMaterial getLibraryMaterial() {return dvd;}
	public String getTitle() {return dvd.getTitle();}
	public String getIsbn() { return dvd.getIsbn();}
	
	public LibraryCard getCard() {return card;}
	public LocalDate getDueDate() {return dueDate;}
	
	public boolean checkOut(LibraryCard borrower, LocalDate dateOfBorrowing)
	
	/*checks dvd out by setting card reference to borrower.
	returns false if dvd is already checked out
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
	
	public boolean returnLibraryMaterial()
			//returns dvd by removing card reference
			//returns false if there is no reference to a card
	{
		if (card == null)
			return false;
		card = null;
		return true;
	}
	
	public boolean renew (LocalDate renewDate){
		System.out.println("Cannot renew DVDs");
		return false;
	}
	
	public boolean renew ()
	//cannot renew DVDs; returns false
	{
		System.out.println("Cannot renew DVDs");
		return false;
	}
	
	//print method for this class. uses dvd print method, then has to create local librarycard and duedate variables
	//to use their string methods
	public void print() {
		dvd.print();
		LibraryCard c = getCard();
		LocalDate dD = getDueDate();
		System.out.println("Card: " + c.getCardholderName() + "Due Date" + dD.toString());
	}
	
	//the following are overridden abstract methods that will be used for the different fines between
	//dvds and books. polymorphism
	public double getFinePerDay(){ return FINE_PER_DAY; }
	public int getBorrowingPeriod() { return BORROWING_WEEKS; }
}
