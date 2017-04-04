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
	
	//abstract helper methods for polymorphism
	abstract double getFinePerDay();
	abstract int getBorrowingPeriod();
}
