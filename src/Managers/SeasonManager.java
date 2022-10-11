package Managers;

import java.util.ArrayList;
import java.util.Queue;

import Plants.Plant;
import Seasons.Season;

public class SeasonManager {
	public void plantPhotoSeasonEffect(ArrayList<Plant> pCurrentPlantsInGarden) {
		for(Plant plant : pCurrentPlantsInGarden) {
			plant.getStatesRules().get(0).getPicture()
		}
	}
	
	public ArrayList<Plant> evaluate(ArrayList<Plant> pCurrentPlantsInGarden, Queue<Season> pSeasonsList) {

		// afectar las platantas como estacion
		for(int eachPlant = 0; eachPlant < pCurrentPlantsInGarden.size(); ++eachPlant) {
			System.out.println("Cantidad de agua de: " + pCurrentPlantsInGarden.get(eachPlant).getName() + " : " + pCurrentPlantsInGarden.get(eachPlant).getWater());
			System.out.println("Cantidad de abono de: " + pCurrentPlantsInGarden.get(eachPlant).getName() + " : " + pCurrentPlantsInGarden.get(eachPlant).getAbono());

			int abonoEfect = pSeasonsList.peek().getEffects().get(0).getAbonoEffect();
			int watterEfect = pSeasonsList.peek().getEffects().get(0).getWatterEfect();
			pCurrentPlantsInGarden.get(eachPlant).affect(watterEfect, abonoEfect);
			System.out.println("Cantidad de agua de: " + pCurrentPlantsInGarden.get(eachPlant).getName() + " : " + pCurrentPlantsInGarden.get(eachPlant).getWater());
			System.out.println("Cantidad de abono de: " + pCurrentPlantsInGarden.get(eachPlant).getName() + " : " + pCurrentPlantsInGarden.get(eachPlant).getAbono());

			
		}
		return pCurrentPlantsInGarden;
	}

}
