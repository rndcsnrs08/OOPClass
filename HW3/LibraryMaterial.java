public class LibraryMaterial {
	private String title;
	private String ISBN;
	
	//constructor for LibraryMaterial class; must use super(i,t) in sublcasses
	public LibraryMaterial(String i, String t){
		ISBN = i;
		title = t;
	}
	
	//accessors. This is the highest level and has direct access to title and ISBN
	public String getTitle() {return title;}
	public String getIsbn() {return ISBN; }
	
	//print method
	public void print(){
		System.out.println("Title: " + title + "ISBN: " + ISBN);
	}
}
	
