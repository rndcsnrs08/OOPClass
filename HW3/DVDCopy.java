// Sample solution for HW2
import java.time.LocalDate;

public class DVDCopy extends LibraryMaterialCopy {
	public static final int BORROWING_WEEKS = 3;
	public static final int RENEWAL_WEEKS = 2;
	public static final double FINE_PER_DAY = .10;
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
	public DVD getDVD() {return dvd;}
	public LibraryMaterial getLibraryMaterial() {return dvd;}
	public String getTitle() {return dvd.getTitle();}
	public String getISBN() { return dvd.getISBN();}
	
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
	
	public boolean returnDVD()
			//returns dvd by removing card reference
			//returns false if there is no reference to a card
	{
		if (card == null)
			return false;
		card = null;
		return true;
	}
	
	public boolean renew (LocalDate renewalDate)
	//renews dvd using RENEWAL_WEEKS as interval
	//returns false if dvds is not checked out
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
	

}
