import java.util.*;
import java.time.*;

public class DriverProgram {
	public static void main (String[] args) {
		
		//assign values to the LibraryMaterial subclasses	-Randolph Cisneros
		Book catHat = new Book("001","Cat hat", "Seuss");
		Book lionWitch = new Book("002","Lion Witch", "Lewis");
		Book gatsby = new Book("003","Gatsby", "Fitzgerald");
		Book wonka = new Book("004","Wonka", "Dahl");

		DVD catInHat = new DVD("005","Cat hat", "Meyers");
		DVD batMan = new DVD("006","Batman", "Ledger");
		DVD rickMorty = new DVD("007","Rick and Morty", "Harmon");
		DVD imitationGame = new DVD("008","The Imitation Game", "Cumberbatch");

		//assign LibraryMaterial to the LibraryMaterialCopy subclasses	-Randolph Cisneros
		BookCopy lW= new BookCopy(lionWitch);
		BookCopy gat= new BookCopy(gatsby);
		BookCopy won = new BookCopy(wonka);
		BookCopy cH = new BookCopy(catHat);

		DVDCopy cIH = new DVDCopy(catInHat);
		DVDCopy bM = new DVDCopy(batMan);
		DVDCopy rM = new DVDCopy(rickMorty);
		DVDCopy iG = new DVDCopy(imitationGame);

		//assign cardholders. Really can just do with one.	-Randolph Cisneros
		LibraryCard bobSmith = new LibraryCard("01","Bob Smith");
		LibraryCard janeDoe = new LibraryCard("02","Jane Doe");
		LibraryCard johnDoe = new LibraryCard("03","John Doe");

		//testerDates	-Randolph Cisneros
		LocalDate today = LocalDate.now();
		LocalDate earlyDueDate = today.minusWeeks(5);

		//some material is given early checkout dates to test the late return methods	-Randolph Cisneros
		janeDoe.checkOutLibraryMaterial(gat, today);
		janeDoe.checkOutLibraryMaterial(lW, earlyDueDate);
		janeDoe.checkOutLibraryMaterial(won, earlyDueDate);
		janeDoe.checkOutLibraryMaterial(cH, earlyDueDate);
		janeDoe.checkOutLibraryMaterial(cIH, today);
		janeDoe.checkOutLibraryMaterial(iG, earlyDueDate);

		//this block tests a dvd for renewal; it should print a message	-Randolph Cisneros
		janeDoe.renewLibraryMaterial(gat);
		janeDoe.renewLibraryMaterial(iG);

		//checks these in to system	-Randolph Cisneros
		janeDoe.returnLibraryMaterial(gat);
		janeDoe.returnLibraryMaterial(lW);
		
		//tests list sort	-Randolph Cisneros
		ArrayList<LibraryMaterialCopy> mainSortedList = janeDoe.getLibraryMaterialSorted();
		traverseAndPrintDate(mainSortedList);

		//tests the method to get overdue material	-Randolph Cisneros
		ArrayList<LibraryMaterialCopy> lateLibraryMaterial = janeDoe.getLibraryMaterialOverdue();
		traverseAndPrintDate(lateLibraryMaterial);
		
	}

	//Simple traverse and print method. Makes use of print methods in the classes	-Randolph Cisneros
	public static void traverseAndPrintDate(ArrayList<LibraryMaterialCopy> libraryMaterialList){
		for (int i = 0; i < libraryMaterialList.size(); i++){
			LibraryMaterialCopy itLibraryMaterialCopy = libraryMaterialList.get(i);
			LibraryMaterial itLibraryMaterial = itLibraryMaterialCopy.getLibraryMaterial();
			itLibraryMaterial.print();
			itLibraryMaterialCopy.print();
		}
	}

}

