//Sample solution to HW2 
class Book 
 {
	 private String isbn;
	 private String title;
	 private String author;
	 
	 public Book (String i, String t, String a)
	 {
		 isbn = i;
		 title = t;
		 author = a;
	 }
	 
	 public String getIsbn () {return isbn;}
	 public String getTitle() {return title;}
	 public String getAuthor() {return author;}

}