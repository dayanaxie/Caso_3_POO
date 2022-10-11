package Plants;

import java.util.ArrayList;

public class Plant {
	private String name;
	private int life;
	private int water;
	private int abono;
	private ArrayList<PlantStateRules> statesRules;
	private ArrayList<PlantSeasonRules> seasonsRules;
	
	public Plant() {
		life = 100;
		water = 0;
		abono = 0;
	}
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public int getAbono() {
		return abono;
	}

	public void setAbono(int abono) {
		this.abono = abono;
	}

	public void affect(int pWaterAmount, int pAbonoAmount) {
		water -= pWaterAmount;
		abono -= pAbonoAmount;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<PlantStateRules> getStatesRules() {
		return statesRules;
	}
	public void setStatesRules(ArrayList<PlantStateRules> statesRules) {
		this.statesRules = statesRules;
	}
	public ArrayList<PlantSeasonRules> getSeasonsRules() {
		return seasonsRules;
	}
	public void setSeasonsRules(ArrayList<PlantSeasonRules> seasonsRules) {
		this.seasonsRules = seasonsRules;
	}
	
}
