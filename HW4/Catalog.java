class Catalog {

	private Map <LibraryMaterial, LinkedList<LibraryMaterialCopy>> libraryContents;

	public Catalog(){
		libraryContents = new HashMap<LibraryMaterial, LinkedList<LibraryMaterialCopy>>();
	}
		
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
			//add to linked listlibraryContents.put(lM, dc);
		}			
	}
	
	//returns container of LibraryMaterialCopy
	public LinkedList<LibraryMaterialCopy> lookUp(LibraryMaterial lM){
		if(libraryContents.containsKey(lM)){
			return libraryContents.get(lM);
		}
		else
			return null;
	}
	
	//overloading lookUp for string title
	public LibraryMaterial lookUp(String title){
		for(LibraryMaterial lM : libraryContents.keySet()){
			if(title == lM.getTitle())
				return lM;
		}
		return null;
	}

	//Have to change because LibraryMaterialCopy is abstract
	public LinkedList<LibraryMaterialCopy> getAvailableCopies(LibraryMaterial lM){
		List<LibraryMaterialCopy> availableCopies = new LinkedList<LibraryMaterialCopy>();
		List<LibraryMaterialCopy> allCopies = new LinkedList<LibraryMaterialCopy>();
		
		if(!libraryContents.containsKey(lM){return null;}
		allCopies = libraryContents.get(lM);
		   for(int i = 0; i < allCopies.size(); i++){
			   LibraryMaterialCopy current = new LibraryMaterialCopy();
			   current = allCopies.get(i);
			   if(current.getCard() == null){
				   availableCopies.add(current);
			   }
		   }
		   return availableCopies;	
	}
	
	//returns all library materials in library
	public LinkedList<LibraryMaterial> getAllLibraryMaterial(){
		List<LibraryMaterial> allLibraryContent = new LinkedList<LibraryMaterial>();
		for(LibraryMaterial lM : libraryContents.keySet()){
			allLibraryContent.add(lM);
		}
		return allLibraryContent;
	}
	
}
