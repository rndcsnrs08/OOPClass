public class Book extends LibraryMaterial
{
	private String author;
	
	public Book(String i, String t, String a)
	{
		super(i, t);
		author = a;
	}
	
	public String getAuthor(){return author;}
	
	public void print()
	{
		super.print();
		System.out.println("author: " + author);
	}
}
