import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class LibraryCard {
	
	private String id;
	private String cardholderName;
	private List<LibraryMaterialCopy> libraryMaterialsCheckedOut;
	private double balance;
	
	public LibraryCard(String i, String name)
	{
		id = i;
		cardholderName = name;
		libraryMaterialsCheckedOut = new ArrayList<LibraryMaterialCopy>();
		balance = 0;
	}
	
	public LibraryCard(LibraryCard lC)
	{
		id = lC.getID();
		cardholderName = lC.getCardholderName();
		libraryMaterialsCheckedOut = new ArrayList<LibraryMaterialCopy> (lC.getlibraryMaterialsCheckedOut);
		balance = lC.getBalance();
	}
	
	public String getID() {return id;}
	public String getCardholderName() {return cardholderName;}
	public double getBalance() {return balance;}
	public List<LibraryMaterialCopy> getlibraryMaterialsCheckedOut() {
		return new ArrayList<LibraryMaterialCopy>(libraryMaterialsCheckedOut);}
	
	public void setCardholderName (String name) {cardholderName = name;}
	
	public LibraryMaterialCopy lookUp (String title) {
		for(int i = 0; i < libraryMaterialsCheckedOut.size(); i++){
			LibraryMaterialCopy lM = new LibraryMaterialCopy();
			lM = libraryMaterialsCheckedOut.get(i);
			if(lM.getTitle() == title)
				return lM;
		}
		return null;
	}
	
	public boolean checkOutLibraryMaterial (LibraryMaterialCopy libraryMaterial, LocalDate todaysDate)
	//checks out libraryMaterial and sends message to libraryMaterialCopy to check itself out too
	//returns false if libraryMaterial is already checked out
	//takes parameter that reflects the date that the checkout is happening
	{
		if (!libraryMaterial.checkOut(this))
			return false;
		libraryMaterialsCheckedOut.add(libraryMaterial);
		return true;
	}
	
	public boolean checkOutLibraryMaterial(LibraryMaterialCopy libraryMaterial)
	//default check out, uses today's date
	{
		return checkOutLibraryMaterial(libraryMaterial, LocalDate.now());
	}
	
	public boolean returnLibraryMaterial (LibraryMaterialCopy libraryMaterial, LocalDate returnDate)
	//returns libraryMaterial and sends message to libraryMaterialCopy to do the same
	//returns false if libraryMaterial is not checked out
	//takes parameter that expresses the date of return
	{
		LocalDate dueDate = libraryMaterial.getDueDate();
		if (!libraryMaterial.returnCopy())
			return false;
		if (!libraryMaterialsCheckedOut.remove(libraryMaterial))
			return false;
		long daysBetween = ChronoUnit.DAYS.between(dueDate, returnDate);
		if (daysBetween > 0) //libraryMaterial is returned late
		{
			balance += libraryMaterial.getFinePerDay() * daysBetween;
		}

		return true;
	}
	
	public boolean returnLibraryMaterial (LibraryMaterialCopy libraryMaterial)
	//default method, uses today's date as returns date
	{
		return returnLibraryMaterial(libraryMaterial, LocalDate.now());
	}
	
	public boolean renewLibraryMaterial(LibraryMaterialCopy libraryMaterial, LocalDate renewalDate)
	//renews libraryMaterial. Returns false if libraryMaterial is not checked out already
	//takes parameter that expresses date of renewal
	//returns false if librayrMaterial is not a book
	{
		if (!libraryMaterialsCheckedOut.contains(libraryMaterial))
			return false;
		if (libraryMaterial.isRenewable())
		{
			if (!((BookCopy)libraryMaterial).renew(renewalDate))
				return false;
			return true;
		}
		return false;
	}
	
	public boolean renewLibraryMaterial (LibraryMaterialCopy libraryMaterial)
	//default renewal method uses today's date as renewal date.
	{
		return renewLibraryMaterial(libraryMaterial, LocalDate.now());
	}
	
	public List<LibraryMaterialCopy> getlibraryMaterialsDueBy(LocalDate date)
	//returns an List of libraryMaterials due on or before date
	{
		List<LibraryMaterialCopy> libraryMaterialsDue = new ArrayList<LibraryMaterialCopy>();
		for (LibraryMaterialCopy libraryMaterial: libraryMaterialsCheckedOut)
		{
			if (libraryMaterial.getDueDate().isBefore(date) || libraryMaterial.getDueDate().equals(date))
			{
				libraryMaterialsDue.add(libraryMaterial);
			}
		}
		
		return libraryMaterialsDue;
	}
	
	public List<LibraryMaterialCopy>  getLibraryMaterialsOverdue (LocalDate todaysDate)
	//returns libraryMaterials overdue as of todaysDate
	//which means that they were actually due by yesterday
	{
		return getlibraryMaterialsDueBy(todaysDate.minusDays(1));
	}
	
	public List<LibraryMaterialCopy> getLibraryMaterialsOverdue()
	//default method, returns libraryMaterials overdue as of today, which means that they 
	//were due by yesterday
	{
		return getLibraryMaterialsOverdue(LocalDate.now());
	}

	public List<LibraryMaterialCopy> getLibraryMaterialsSorted()
	//returns List of libraryMaterials, sorted by due date (earliest due date first)
	//uses insertion sort 
	{
		List<LibraryMaterialCopy> libraryMaterials = new ArrayList<LibraryMaterialCopy>(libraryMaterialsCheckedOut);

		for (int i = 1; i < libraryMaterials.size(); i++)
		{
			int j = i;
			while (j > 0 && libraryMaterials.get(j-1).getDueDate().isAfter(libraryMaterials.get(j).getDueDate()))
			{
	
				
				//swap elements in positions j and j-1
				LibraryMaterialCopy temp = libraryMaterials.get(j);
				libraryMaterials.set(j, libraryMaterials.get(j-1));
				libraryMaterials.set(j-1, temp);
				
				j = j-1;
			}
		}

		return libraryMaterials;
	}
}
