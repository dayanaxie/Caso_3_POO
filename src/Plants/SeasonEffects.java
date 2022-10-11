package Plants;

import java.util.ArrayList;

import Managers.Rules;

public class SeasonEffects{
	private String name;
	private int id;
	private int effect;
	private ArrayList<Rules> waterRules;
	private ArrayList<Rules> abonoRules;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEffect() {
		return effect;
	}
	public void setEffect(int effect) {
		this.effect = effect;
	}
	public ArrayList<Rules> getWaterRules() {
		return waterRules;
	}
	public void setWaterRules(ArrayList<Rules> waterRules) {
		this.waterRules = waterRules;
	}
	public ArrayList<Rules> getAbonoRules() {
		return abonoRules;
	}
	public void setAbonoRules(ArrayList<Rules> abonoRules) {
		this.abonoRules = abonoRules;
	}
	
	

}
