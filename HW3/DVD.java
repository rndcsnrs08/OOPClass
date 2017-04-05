class DVD extends LibraryMaterial {

	private String mainActor;

	public DVD (String i, String t, String mA) {
		super(i,t);
		mainActor = mA;
	}

	//accessors for subclass call accessors for superclass if necessary
	public String getIsbn () {return super.getIsbn();}
	public String getTitle() {return super.getTitle();}
	public String getMainActor() {return mainActor;}
	
	//print method, calls super first.
	public void print() {
		super.print();
		System.out.println("Main Actor: " + mainActor);
	}

}
