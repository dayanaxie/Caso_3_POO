package Plants;

import java.util.ArrayList;

public class PlantSeasonRules {
	private String name;
	private int effect;
	private ArrayList<SeasonEffects> seasonRules;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEffect() {
		return effect;
	}
	public void setEffect(int effect) {
		this.effect = effect;
	}
	public ArrayList<SeasonEffects> getSeasonRules() {
		return seasonRules;
	}
	public void setSeasonRules(ArrayList<SeasonEffects> seasonRules) {
		this.seasonRules = seasonRules;
	}
	
	

}
