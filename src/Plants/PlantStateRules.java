package Plants;

import java.util.ArrayList;

public class PlantStateRules {
	private int id;
	private int minLife;
	private int maxLife;
	private String picture;
	private String name;
	private ArrayList<StateRules> stateRulesPlant;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMinLife() {
		return minLife;
	}
	public void setMinLife(int minLife) {
		this.minLife = minLife;
	}
	public int getMaxLife() {
		return maxLife;
	}
	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<StateRules> getStateRulesPlant() {
		return stateRulesPlant;
	}
	public void setStateRulesPlant(ArrayList<StateRules> stateRulesPlant) {
		this.stateRulesPlant = stateRulesPlant;
	}
}
