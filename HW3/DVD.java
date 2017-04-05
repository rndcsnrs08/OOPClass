class DVD extends LibraryMaterial {

	private String mainActor;

	public DVD (String i, String t, String mA) {
		super(i,t);
		mainActor = mA;
	}

	public String getIsbn () {return super.getIsbn();}
	public String getTitle() {return super.getTitle();}
	public String getMainActor() {return mainActor;}
	
	public void print() {
		super.print();
		System.out.println("Main Actor: " + mainActor);
	}

}
