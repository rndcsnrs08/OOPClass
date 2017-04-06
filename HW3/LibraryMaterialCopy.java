import java.time.LocalDate;

public abstract class LibraryMaterialCopy {
	private LibraryCard card;
	private LocalDate dueDate;
	
	public LibraryMaterialCopy() {
		card = null;
		dueDate = null;
	}
	
	//Many abstract classes had to be added in order to replace BookCopy with LibraryMaterialCopy in the
	//LibraryCard class. This is something to note when replacing a class with an abstract class.	-Randolph Cisneros
	abstract LibraryMaterial getLibraryMaterial();
	abstract String getTitle();
	abstract String getIsbn();
	abstract LocalDate getDueDate();
	abstract boolean returnLibraryMaterial();
	abstract boolean renew();
	abstract boolean renew(LocalDate date);
	abstract boolean checkOut(LibraryCard borrower, LocalDate dateOfBorrowing);
	abstract boolean checkOut (LibraryCard borrower);

	//accessors for 2 different static final values of the subclasses; allows for polymorphism	-Randolph Cisneros
	abstract double getFinePerDay();
	abstract int getBorrowingPeriod();
	
	abstract void print();
}
