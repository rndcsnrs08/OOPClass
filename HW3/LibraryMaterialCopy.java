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
	abstract String getIsbn();
	abstract LocalDate getDueDate();
	abstract boolean returnLibraryMaterial();
	abstract boolean renew();
	abstract boolean renew(LocalDate date);

	//abstract helper methods for polymorphism
	abstract double getFinePerDay();
	abstract int getBorrowingPeriod();
	
	//taken straight from BookCopy; may need to set to an empty code block.
	abstract boolean checkOut(LibraryCard borrower, LocalDate dateOfBorrowing)
;
	abstract boolean checkOut (LibraryCard borrower)
;
}
