public class LibraryMaterial {
	private String title;
	private String ISBN;
	
	//constructor for LibraryMaterial class; must use super(i,t) in sublcasses
	public LibraryMaterial(String i, String t){
		ISBN = i;
		title = t;
	}
	
	public void print(){
		System.out.println("Title: " + title + "ISBN: " + ISBN);
	}
}
	
