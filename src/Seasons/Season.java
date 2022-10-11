package Seasons;

import java.util.ArrayList;
public class Season {
	private String startDate;
	private String endDate;
	private String name;
	private String condition;
	private int minSun;
	private int maxSun;
	private int minRain;
	private int maxRain;
	private ArrayList<SeasonEffect> effects;
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getMinSun() {
		return minSun;
	}
	public void setMinSun(int minSun) {
		this.minSun = minSun;
	}
	public int getMaxSun() {
		return maxSun;
	}
	public void setMaxSun(int maxSun) {
		this.maxSun = maxSun;
	}
	public int getMinRain() {
		return minRain;
	}
	public void setMinRain(int minRain) {
		this.minRain = minRain;
	}
	public int getMaxRain() {
		return maxRain;
	}
	public void setMaxRain(int maxRain) {
		this.maxRain = maxRain;
	}
	public ArrayList<SeasonEffect> getEffects() {
		return effects;
	}
	public void setEffects(ArrayList<SeasonEffect> effects) {
		this.effects = effects;
	}
	
	
	

}
