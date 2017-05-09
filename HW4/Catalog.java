class Catalog {

	Map <LibraryMaterial, LinkedList<LibraryMaterialCopy>> libraryContents = new HashMap<LibraryMaterial, LinkedList<LibraryMaterialCopy>>();

	//return true if able to add material, false if otherwise
	public void addLibraryMaterial(Book lM, int n){
		for(int i = 0; i < n; i++){
			BookCopy bc = new BookCopy(lM);
			libraryContents.put(lM, bc);
		}			
	}
	
	//overloaded this method for book and dvd because I could not create an instance of LibraryMaterialCopy
	public void addLibraryMaterial(Book lM, int n){
		for(int i = 0; i < n; i++){
			BookCopy bc = new BookCopy(lM);
			libraryContents.put(lM, bc);
		}			
	}
	
	public void addLibraryMaterial(DVD lM, int n){
		for(int i = 0; i < n; i++){
			DVDCopy dc = new DVDCopy(lM);
			libraryContents.put(lM, dc);
		}			
	}
	
	//returns container of LibraryMaterialCopy
	public LinkedList<LibraryMaterialCopy> lookUp(LibraryMaterial lM){
	
	}
	
	//overloading lookUp for string title
	public LibraryMaterial lookUp(String s){
	
	}

	//
	public LinkedList<LibraryMaterialCopy> getAvailableCopies(LibraryMaterial lM){
	
	
	}
	
	//returns all library materials in library
	public LinkedList<LibraryMaterial> getAllLibraryMaterial(){
	
	}
	
}
