package Seasons;

public enum SeasonsOfTheYear {
	VEARNO(0), PRIMAVERA(1), OTOÑO(2), INVIERNO(3);
	private int id;
	
	SeasonsOfTheYear(int pId) {
		this.id = pId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
