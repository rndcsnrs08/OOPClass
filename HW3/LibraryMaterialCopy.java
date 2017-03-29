public abstract class LibraryMaterialCopy {
	private LibraryCard userCard;
	private DueDate userDate;
	
	Book getLibraryMaterial(){
		return userCard.getBook();
	}
	
	DVD getLibraryMaterial(){
		return userCard.getDVD();
	}
}