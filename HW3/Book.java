//Sample solution to HW2 
class Book extends LibraryMaterial
 {
	 private String author;
	 
	 //constructor for Book calls constructor for superclass first
	 public Book (String i, String t, String a)
	 {
		 super(i,t);
		 author = a;
	 }
	 
	 //mutators actually need to call super to access elements of superclass
	 public String getIsbn () {return super.getIsbn();}
	 public String getTitle() {return super.getTitle();}
	 public String getAuthor() {return author;}
	 
	 //print method
	 public void print() {
	 	super.print();
		System.out.println("Author: " + getAuthor());
	}

}
