public class DVDCopy extends LibraryMaterialCopy {
	
	public static final int BORROWING_WEEKS = 2;
	public static final double FINE_PER_DAY = 1;
	public static final boolean IS_RENEWABLE = false;
	private DVD dvd;

	public DVDCopy(DVD d)
	{
		super();
		dvd = d;
	}
	
	@Override
	public LibraryMaterial getLibraryMaterial() {
		return dvd;
	}

	@Override
	public String getTitle() {
		return dvd.getTitle();
	}

	@Override
	public String getISBN() {
		return dvd.getISBN(); 
	}
	
	public String getMainActor()
	{
		return dvd.getMainActor();
	}

	@Override
	public int getBorrowingWeeks() {return BORROWING_WEEKS;}
	
	@Override
	public double getFinePerDay() {return FINE_PER_DAY;}
	
	@Override
	public boolean isRenewable() {return IS_RENEWABLE;}
	
	public void print()
	{
		dvd.print();
		super.print();
	}
	
	//Still implementing to pass string, but may change this to take MaterialCopy parameter
	public boolean equalTitle(String s) {
		if (dvd.getTitle() == s)
			return true;
		return false;
	}
		
	

}
