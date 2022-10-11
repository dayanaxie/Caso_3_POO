package VirtualGarden;

import java.util.ArrayList;
import java.util.Queue;

import Managers.GardenMainFrameController;
import Managers.JsonReader;
import Managers.PlantManager;
import Plants.Plant;
import Seasons.Season;
import UI.VirtualGardenMainFrame;
import Managers.Time;

public class VirtualGardenController {
	ArrayList<Plant> currentPlantsInGarden;
	private ArrayList<Plant> plantsList;
	private Queue<Season> seasonsList; 
	
	public VirtualGardenController(){
		JsonReader lector = new JsonReader();
		currentPlantsInGarden = new ArrayList<Plant>();
		lector.loadSeasons();
		lector.loadPlants();
		plantsList = lector.getPlantsList();
		seasonsList = lector.getSeasonsList();
	}
	
	
	public void startSimulation() {
		Time timeSimulator = new Time(seasonsList, currentPlantsInGarden);
		timeSimulator.run();
	}
	
	
	public void informPlantManager(int pId) {
		PlantManager plantManager = new PlantManager();
		this.plantsList = plantManager.addPlant(pId, currentPlantsInGarden, plantsList);
		
	}
	public ArrayList<Plant> getCurrentPlantsInGarden() {
		return currentPlantsInGarden;
	}
	public void setCurrentPlantsInGarden(ArrayList<Plant> currentPlantsInGarden) {
		this.currentPlantsInGarden = currentPlantsInGarden;
	}
	public ArrayList<Plant> getPlantsList() {
		return plantsList;
	}
	public void setPlantsList(ArrayList<Plant> plantsList) {
		this.plantsList = plantsList;
	}
	public Queue<Season> getSeasonsList() {
		return seasonsList;
	}
	public void setSeasonsList(Queue<Season> seasonsList) {
		this.seasonsList = seasonsList;
	}
	
	


}
