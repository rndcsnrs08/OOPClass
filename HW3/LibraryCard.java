//sample solution to HW2

import java.util.ArrayList;
import java.time.LocalDate;
import 	java.time.temporal.ChronoUnit;


public class LibraryCard {
	
	private String id;
	private String cardholderName;
	private ArrayList<BookCopy> booksCheckedOut;
	private double balance;
	
	public LibraryCard(String i, String name)
	{
		id = i;
		cardholderName = name;
		booksCheckedOut = new ArrayList<BookCopy>();
		balance = 0;
	}
	
	public String getID() {return id;}
	public String getCardholderName() {return cardholderName;}
	public ArrayList<BookCopy> getBooksCheckedOut() {return booksCheckedOut;}
	
	public void setCardholderName (String name) {cardholderName = name;}
	
	public boolean checkOutBook (BookCopy book, LocalDate todaysDate)
	//checks out book and sends message to BookCopy to check itself out too
	//returns false if book is already checked out
	//takes parameter that reflects the date that the checkout is happening
	{
		if (!book.checkOut(this,todaysDate)
			return false;
		booksCheckedOut.add(book);
		return true;
	}
	
	public boolean checkOutBook(BookCopy book)
	//default check out, uses today's date
	{
		return checkOutBook(book, LocalDate.now());
	}
	
	public boolean returnBook (BookCopy book, LocalDate returnDate)
	//returns book and sends message to BookCopy to do the same
	//returns false if book is not checked out
	//takes parameter that expresses the date of return
	{
		LocalDate dueDate = book.getDueDate();
		if (!book.returnBook())
			return false;
		if (!booksCheckedOut.remove(book))
			return false;
		long daysBetween = ChronoUnit.DAYS.between(dueDate, returnDate);
		if (daysBetween > 0) //book is returned late
		{
			balance += BookCopy.FINE_PER_DAY * daysBetween;
		}

		return true;
	}
	
	public boolean returnBook (BookCopy book)
	//default method, uses today's date as returns date
	{
		return returnBook(book, LocalDate.now());
	}
	
	public boolean renewBook(BookCopy book, LocalDate renewalDate)
	//renews book. Returns false if book is not checked out already
	//takes parameter that expresses date of renewal
	{
		if (!booksCheckedOut.contains(book))
			return false;
		if (!book.renew(renewalDate))
			return false;
		return true;
	}
	
	public boolean renewBook (BookCopy book)
	//default renewal method uses today's date as renewal date.
	{
		return renewBook(book, LocalDate.now());
	}
	
	public ArrayList<BookCopy> getBooksDueBy(LocalDate date)
	//returns an ArrayList of books due on or before date
	{
		ArrayList<BookCopy> booksDue = new ArrayList();
		for (BookCopy book: booksCheckedOut)
		{
			if (book.getDueDate().isBefore(date) || book.getDueDate().equals(date))
			{
				booksDue.add(book);
			}
		}
		
		return booksDue;
	}
	
	public ArrayList<BookCopy>  getBooksOverdue (LocalDate todaysDate)
	//returns books overdue as of todaysDate
	//which means that they were actually due by yesterday
	{
		return getBooksDueBy(todaysDate.minusDays(1));
	}
	
	public ArrayList getBooksOverdue()
	//default method, returns books overdue as of today, which means that they 
	//were due by yesterday
	{
		return getBooksOverdue(LocalDate.now());
	}

	public ArrayList<BookCopy> getBooksSorted()
	//returns ArrayList of books, sorted by due date (earliest due date first)
	//uses insertion sort 
	{
		for (int i = 1; i < booksCheckedOut.size(); i++)
		{
			int j = i;
			while (j > 0 && booksCheckedOut.get(j-1).getDueDate().isAfter(booksCheckedOut.get(j).getDueDate()))
			{
				//swap elements in positions j and j-1
				BookCopy temp = booksCheckedOut.get(j);
				booksCheckedOut.set(j, booksCheckedOut.get(j-1));
				booksCheckedOut.set(j-1, temp);
				
				j = j-1;
			}
		}

		return booksCheckedOut;
	}
}
