class DVD extends LibraryMaterial {

	private String mainActor;

	public DVD (String i, String t, String mA) {
		super(i,t);
		mainActor = mA;
	}

	public String getIsbn () {return isbn;}
	public String getTitle() {return title;}
	public String getMainActor() {return mainActor;}

}