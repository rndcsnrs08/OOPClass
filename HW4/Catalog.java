class Catalog {

	Map <LibraryMaterial, LinkedList<LibraryMaterialCopy>> libraryContents = new HashMap<LibraryMaterial, LinkedList<LibraryMaterialCopy>>();

	//return true if able to add material, false if otherwise
	public boolean addLibraryMaterial(LibraryMaterial lM, int n){
	
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