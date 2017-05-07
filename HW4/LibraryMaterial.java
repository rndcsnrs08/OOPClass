//Sample solution to HW1 
class LibraryMaterial 
 {
	 private String ISBN;
	 private String title;
	 
	 public LibraryMaterial (String i, String t)
	 {
		 ISBN = i;
		 title = t;
	 }
	 
	 public String getISBN () {return ISBN;}
	 public String getTitle() {return title;}
	 
	 public void print()
	 {
		 System.out.print("ISBN: " + ISBN + " title: " + title + " ");
	 }
	 
	 public boolean equalTitle(String s) {
		 if (title == s)
			 return true;
		 return false;
	 }

}