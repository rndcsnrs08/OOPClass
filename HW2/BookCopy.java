import java.time.LocalDate;
// Sample solution for HW1

public class BookCopy {

	private Book book;

	private LibraryCard card;

	private LocalDate dueDate;
	
	public BookCopy(Book b)

	{

		book = b;

		card = null;

		dueDate = null;
	}
	

	public Book getBook() {return book;}

	public LibraryCard getCard() {return card;}
	public LocalDate getDueDate() {return dueDate;}	


	public boolean checkOut(LibraryCard borrower)

	//checks book out by setting card reference to borrower.

	//returns false if book is already checked out

	{

		if (card != null)

			return false;

		card = borrower;

		setDueDate();
		return true;

	}


	public boolean checkOut(LibraryCard borrower, LocalDate makeDate)

	//Overloaded test method
	//checks book out by setting card reference to borrower.

	//returns false if book is already checked out

	{

		if (card != null)

			return false;

		card = borrower;

		setDueDate(makeDate);
		return true;

	}

	

	public boolean returnBook()
		
	//returns book by removing card reference
		
	//returns false if there is no reference to a card

	{
		if (card == null)

				return false;
			LocalDate today = LocalDate.now();
			if (today.isAfter(dueDate))
	//fix			card.setBalance((double)(.10 * (java.lang.Math.abs(today.compareTo(dueDate)))));
			card = null;

			dueDate = null;
			return true;

	}

	public boolean returnBook(LocalDate makeDate)

	//Overloaded test method		
	//returns book by removing card reference
		
	//returns false if there is no reference to a card

	{
		if (card == null)

				return false;
			if (makeDate.isAfter(dueDate))
	//fix			card.setBalance((double)(.10 * (java.lang.Math.abs(today.compareTo(dueDate)))));
			card = null;

			dueDate = null;
			return true;

	}

	public void setDueDate()
	//sets due date to 3 weeks from now
	{
		LocalDate today = LocalDate.now();
		dueDate = today.plusWeeks(3);
	}

	public void setDueDate(LocalDate makeDate)
	//sets due date to 3 weeks from now
	{
		dueDate = makeDate;
	}

	public void renewDueDate()
	//adds two weeks to date they want renewed
	{
		LocalDate today = LocalDate.now();
		dueDate = today.plusWeeks(2);
	}
	

}
