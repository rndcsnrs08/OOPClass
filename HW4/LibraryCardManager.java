class LibraryCardManager {

	private Map <String, LibraryCard> libraryCards;
	
	public LibraryCardManager(){
		libraryCards = new HashMap<String, LibraryCard>();
	}
	
	public void addCard(LibraryCard lc){
		libraryCards.put(lc.getID, lc);
	}
		
	public LibraryCard lookUp(String id){
		return LibraryCards.get(id);
	}
}
