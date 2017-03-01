import java.util.ArrayList;

import java.time.LocalDate;


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

	public void setBalance (double b) { balance += b; }	


	public boolean checkOutBook (BookCopy book)
	
	//checks out book and sends message to BookCopy to check itself out too

	//returns false if book is already checked out

	{
	
		if (!book.checkOut(this))

			return false;

		booksCheckedOut.add(book);

		book.setDueDate();
		return true;

	}


	public boolean checkOutBook (BookCopy book, LocalDate makeDate)
	
	//checks out book and sends message to BookCopy to check itself out too

	//returns false if book is already checked out

	{
	
		if (!book.checkOut(this))

			return false;

		booksCheckedOut.add(book);

		book.setDueDate(makeDate);
		return true;

	}
	


	public boolean returnBook (BookCopy book)

	//returns book and sends message to BookCopy to do the same

	//returns false if book is not checked out

	{

		if (!book.returnBook())

			return false;

		if (!booksCheckedOut.remove(book))

			return false;

		return true;

	}

	public ArrayList<BookCopy> isOverdue()
	//iterates through books checked out
	//returns true if any books are overdue; else it returns false
	{
		ArrayList<BookCopy> overdueBooks = new ArrayList<BookCopy>();
		LocalDate today = LocalDate.now();
		for (int i = 0; i < booksCheckedOut.size(); i++){
			BookCopy bookToQuery = booksCheckedOut.get(i);
			if (bookToQuery.getDueDate().isBefore(today))		//check logic
				overdueBooks.add(bookToQuery);
		}
		return overdueBooks;
	}

	public ArrayList<BookCopy> isOverdue(LocalDate makeDate)
	//Overloaded method for testing
	//iterates through books checked out
	//returns true if any books are overdue; else it returns false
	{
		ArrayList<BookCopy> overdueBooks = new ArrayList<BookCopy>();
		for (int i = 0; i < booksCheckedOut.size(); i++){
			BookCopy bookToQuery = booksCheckedOut.get(i);
			if (bookToQuery.getDueDate().isBefore(makeDate))		//check logic
				overdueBooks.add(bookToQuery);
		}
		return overdueBooks;
	}

	public ArrayList<BookCopy> dateQuery(LocalDate queryDate)
	//iterates through books checked out
	//compares due dates to queried date and adds to list if they are not due
	// after the queried date
	{
		ArrayList<BookCopy> dateQueryList = new ArrayList<BookCopy>();
			for (int i = 0; i < booksCheckedOut.size(); i++){
				BookCopy bookToQuery = booksCheckedOut.get(i);
				if (!(bookToQuery.getDueDate().isAfter(queryDate)))
					dateQueryList.add(bookToQuery);
			}
		return dateQueryList;
	}	

	public ArrayList<BookCopy> sortList(){
		ArrayList<BookCopy> sortedList = new ArrayList<BookCopy>();
		for(int i = 0; i < booksCheckedOut.size(); i++){
			BookCopy t = booksCheckedOut.get(i);
			sortedList.add(t);
		}

		for (int j = 0; j < booksCheckedOut.size() -1; j++){
			for (int k = 1; k < booksCheckedOut.size() - j; k++){
				BookCopy a = sortedList.get(k-1);
				BookCopy b = sortedList.get(k);
				if(a.getDueDate().isAfter(b.getDueDate())){
					sortedList.set(k-1, b);
					sortedList.set(k, a);
				}
			}
		}
		return sortedList;
	}
				
				
	

}
