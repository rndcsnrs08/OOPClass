class LibraryCardManager {

	private Map <String, LibraryCard> LibraryCards;
	
	public void addCard(LibraryCard lc){
		libraryCards.put(lc.getID, lc);
	}
		
	public LibraryCard lookUp(String id){
		return LibraryCards.get(id);
	}
}