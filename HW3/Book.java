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
	 
	 public String getIsbn () {return isbn;}
	 public String getTitle() {return title;}
	 public String getAuthor() {return author;}

}
