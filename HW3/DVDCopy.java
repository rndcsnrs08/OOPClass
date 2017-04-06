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
	
	//Accessors. Note that they call accessors to the other class as well	-Randolph Cisneros
	public LibraryMaterial getLibraryMaterial() {return dvd;}
	public String getTitle() {return dvd.getTitle();}
	public String getIsbn() { return dvd.getIsbn();}
	public LibraryCard getCard() {return card;}
	public LocalDate getDueDate() {return dueDate;}
	//Here again, we have accessors for the public static variables. It
	//seems like this would be a smart standard practice, especially for
	//any subclass.	-Randolph Cisneros
	public double getFinePerDay(){ return FINE_PER_DAY; }
	public int getBorrowingPeriod() { return BORROWING_WEEKS; }
	
	public boolean checkOut(LibraryCard borrower, LocalDate dateOfBorrowing)
	
	/*checks dvd out by setting card reference to borrower.
	returns false if dvd is already checked out
	sets due date to BORROWING_WEEKS after current date passed	-Randolph Cisneros */
	
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
			//returns dvd by removing card reference
			//returns false if there is no reference to a card
	{
		if (card == null)
			return false;
		card = null;
		return true;
	}
	
	//a simple class that returns false. I decided to override this method rather than omit,
	//since it felt like a safer bet	-Randolph Cisneros
	public boolean renew (LocalDate renewDate){
		System.out.println("Cannot renew DVDs");
		return false;
	}
	
	public boolean renew ()
	//same here	-Randolph Cisneros
	{
		System.out.println("Cannot renew DVDs");
		return false;
	}
	
	//print method for this class. uses dvd print method, then has to create local librarycard and duedate variables
	//to use their accessors	-Randolph Cisneros
	public void print() {
		dvd.print();
		LibraryCard c = getCard();
		LocalDate dD = getDueDate();
		System.out.println("Card: " + c.getCardholderName() + "Due Date" + dD.toString());
	}
	
}
