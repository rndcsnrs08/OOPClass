//sample solution to HW2

import java.util.ArrayList;
import java.time.LocalDate;
import 	java.time.temporal.ChronoUnit;


public class LibraryCard {
	
	private String id;
	private String cardholderName;
	private ArrayList<LibraryMaterialCopy> libraryMaterialCheckedOut;
	private double balance;
	
	public LibraryCard(String i, String name)
	{
		id = i;
		cardholderName = name;
		libraryMaterialCheckedOut = new ArrayList<LibraryMaterialCopy>();
		balance = 0;
	}
	
	public String getID() {return id;}
	public String getCardholderName() {return cardholderName;}
	public ArrayList<LibraryMaterialCopy> getlibraryMaterialCheckedOut() {return libraryMaterialCheckedOut;}
	
	public void setCardholderName (String name) {cardholderName = name;}
	
	public boolean checkOutLibraryMaterial (LibraryMaterialCopy lM, LocalDate todaysDate)
	//checks out LibraryMaterial and sends message to LibraryCopy to check itself out too
	//returns false if lM is already checked out
	//takes parameter that reflects the date that the checkout is happening
	{
		if (!lM.checkOut(this,todaysDate))
			return false;
		libraryMaterialCheckedOut.add(lM);
		return true;
	}
	
	public boolean checkOutLibraryMaterial(LibraryMaterialCopy lM)
	//default check out, uses today's date
	{
		return checkOutLibraryMaterial(lM, LocalDate.now());
	}
	
	public boolean returnLibraryMaterial (LibraryMaterialCopy lM, LocalDate returnDate)
	//returns lM and sends message to LibraryMaterialCopy to do the same
	//returns false if lM is not checked out
	//takes parameter that expresses the date of return
	{
		LocalDate dueDate = lM.getDueDate();
		if (!lM.returnLibraryMaterial())
			return false;
		if (!libraryMaterialCheckedOut.remove(lM))
			return false;
		long daysBetween = ChronoUnit.DAYS.between(dueDate, returnDate);
		if (daysBetween > 0) //book is returned late
		{
			balance += lM.getFinePerDay() * daysBetween;
		}

		return true;
	}
	
	public boolean returnLibraryMaterial (LibraryMaterialCopy lM)
	//default method, uses today's date as returns date
	{
		return returnLibraryMaterial(lM, LocalDate.now());
	}
	
	public boolean renewLibraryMaterial(LibraryMaterialCopy lM, LocalDate renewalDate)
	//renews lM. Returns false if lM is not checked out already
	//takes parameter that expresses date of renewal
	{
		if (!libraryMaterialCheckedOut.contains(lM))
			return false;
		if (!lM.renew(renewalDate))
			return false;
		return true;
	}
	
	public boolean renewLibraryMaterial (LibraryMaterialCopy lM)
	//default renewal method uses today's date as renewal date.
	{
		return renewLibraryMaterial(lM, LocalDate.now());
	}
	
	public ArrayList<LibraryMaterialCopy> getLibraryMaterialDueBy(LocalDate date)
	//returns an ArrayList of LibraryMaterial due on or before date
	{
		ArrayList<LibraryMaterialCopy> LibraryMaterialDue = new ArrayList();
		for (LibraryMaterialCopy lM: libraryMaterialCheckedOut)
		{
			if (lM.getDueDate().isBefore(date) || lM.getDueDate().equals(date))
			{
				LibraryMaterialDue.add(lM);
			}
		}
		
		return LibraryMaterialDue;
	}
	
	public ArrayList<LibraryMaterialCopy>  getLibraryMaterialOverdue (LocalDate todaysDate)
	//returns LibraryMaterial overdue as of todaysDate
	//which means that they were actually due by yesterday
	{
		return getLibraryMaterialDueBy(todaysDate.minusDays(1));
	}
	
	public ArrayList getLibraryMaterialOverdue()
	//default method, returns LibraryMaterial overdue as of today, which means that they 
	//were due by yesterday
	{
		return getLibraryMaterialOverdue(LocalDate.now());
	}

	public ArrayList<LibraryMaterialCopy> getLibraryMaterialSorted()
	//returns ArrayList of LibraryMaterial, sorted by due date (earliest due date first)
	//uses insertion sort 
	{
		for (int i = 1; i < libraryMaterialCheckedOut.size(); i++)
		{
			int j = i;
			while (j > 0 && libraryMaterialCheckedOut.get(j-1).getDueDate().isAfter(libraryMaterialCheckedOut.get(j).getDueDate()))
			{
				//swap elements in positions j and j-1
				LibraryMaterialCopy temp = libraryMaterialCheckedOut.get(j);
				libraryMaterialCheckedOut.set(j, libraryMaterialCheckedOut.get(j-1));
				libraryMaterialCheckedOut.set(j-1, temp);
				
				j = j-1;
			}
		}

		return libraryMaterialCheckedOut;
	}
}
