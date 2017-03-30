//Sample solution to HW2 
class Book extends LibraryMaterial
 {
	 private String author;
	 
	 //Have to change constructor; send isbn and title to super
	 public Book (String i, String t, String a)
	 {
		 super(i,t);
		 author = a;
	 }
	 
	 public String getIsbn () {return isbn;}
	 public String getTitle() {return title;}
	 public String getAuthor() {return author;}

}
