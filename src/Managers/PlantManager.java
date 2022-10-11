package Managers;

import java.util.ArrayList;

import Interfaces.IConstants;
import Plants.Plant;

public class PlantManager implements IConstants{
	
	
	
	public static ArrayList<Plant> addPlant(int pPlantSelected, ArrayList<Plant> pCurrentPlantsInGarden, ArrayList<Plant> pPlantsList) {
		pCurrentPlantsInGarden.add(pPlantsList.get(pPlantSelected));
		System.out.println("Se agrego la planta: " + pPlantsList.get(pPlantSelected).getName());
		return pCurrentPlantsInGarden;
	}
	
	public Plant regar(Plant pPlant) {
		pPlant.setWater(pPlant.getWater()+ WATER_PORTION);
		return pPlant;
		
	}
	
	public Plant abonar(Plant pPlant) {
		pPlant.setAbono(pPlant.getAbono() + ABONO_PORTION);
		return pPlant;
	}

}
