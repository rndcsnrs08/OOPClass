
public class DVD extends LibraryMaterial {
	private String mainActor;
	
	public DVD (String i, String t, String mA)
	{
		super(i, t);
		mainActor = mA;
	}
	public String getMainActor(){return mainActor;}
	public void print()
	{
		super.print();
		System.out.println("Main actor: " + mainActor);
	}
}
