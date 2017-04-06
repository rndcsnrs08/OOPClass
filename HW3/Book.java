//Sample solution to HW2 
class Book extends LibraryMaterial
 {
	 private String author;
	 
	 //constructor for Book calls constructor for superclass first	-Randolph Cisneros
	 public Book (String i, String t, String a)
	 {
		 super(i,t);
		 author = a;
	 }
	 
	 //mutators actually need to call super to access elements of superclass	-Randolph Cisneros
	 public String getIsbn () {return super.getIsbn();}
	 public String getTitle() {return super.getTitle();}
	 public String getAuthor() {return author;}
	 
	 //print method	-Randolph Cisneros
	 public void print() {
	 	super.print();
		System.out.println("Author: " + getAuthor());
	}

}
