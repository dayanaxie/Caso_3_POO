package Seasons;

public enum ClimaticStations {
	POCA_LLUVIA(0), MUCHA_LLUVIA(1), POCO_SOL(2), MUCHO_SOL(3);
	private int id;

	ClimaticStations(int pId) {
		this.id = pId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
