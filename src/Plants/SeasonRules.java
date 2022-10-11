package Plants;

import java.util.ArrayList;

public class SeasonRules {
	private ArrayList<SeasonEffects> rainRules;
	private ArrayList<SeasonEffects> sunRules;
	
	public ArrayList<SeasonEffects> getRainRules() {
		return rainRules;
	}
	public void setRainRules(ArrayList<SeasonEffects> rainRules) {
		this.rainRules = rainRules;
	}
	public ArrayList<SeasonEffects> getSunRules() {
		return sunRules;
	}
	public void setSunRules(ArrayList<SeasonEffects> sunRules) {
		this.sunRules = sunRules;
	}
	

}
