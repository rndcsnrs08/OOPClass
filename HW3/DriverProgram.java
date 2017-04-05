import java.util.*;
import java.time.*;

public class DriverProgram {
	public static void main (String[] args) {

		Book catHat = new Book("001","Cat hat", "Seuss");
		Book lionWitch = new Book("002","Lion Witch", "Lewis");
		Book gatsby = new Book("003","Gatsby", "Fitzgerald");
		Book wonka = new Book("004","Wonka", "Dahl");

		DVD catInHat = new DVD("005","Cat hat", "Meyers");
		DVD batMan = new DVD("006","Batman", "Ledger");
		DVD rickMorty = new DVD("007","Rick and Morty", "Harmon");
		DVD imitationGame = new DVD("008","The Imitation Game", "Cumberbatch");


		BookCopy lW= new BookCopy(lionWitch);
		BookCopy gat= new BookCopy(gatsby);
		BookCopy won = new BookCopy(wonka);
		BookCopy cH = new BookCopy(catHat);

		DVDCopy cIH = new DVDCopy(catInHat);
		DVDCopy bM = new DVDCopy(batMan);
		DVDCopy rM = new DVDCopy(rickMorty);
		DVDCopy iG = new DVDCopy(imitationGame);

		LibraryCard bobSmith = new LibraryCard("01","Bob Smith");
		LibraryCard janeDoe = new LibraryCard("02","Jane Doe");
		LibraryCard johnDoe = new LibraryCard("03","John Doe");

		LocalDate today = LocalDate.now();
		LocalDate earlyDueDate = today.minusWeeks(5);

		janeDoe.checkOutLibraryMaterial(gat, today);
		janeDoe.checkOutLibraryMaterial(lW, earlyDueDate);
		janeDoe.checkOutLibraryMaterial(won, earlyDueDate);
		janeDoe.checkOutLibraryMaterial(cH, earlyDueDate);
		janeDoe.checkOutLibraryMaterial(cIH, today);
		janeDoe.checkOutLibraryMaterial(iG, earlyDueDate);


		janeDoe.renewLibraryMaterial(gat);
		janeDoe.renewLibraryMaterial(iG);

		janeDoe.returnLibraryMaterial(gat);
		janeDoe.returnLibraryMaterial(lW);
		
	}

}

