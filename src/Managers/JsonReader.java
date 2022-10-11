package Managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Plants.Plant;
import Plants.PlantSeasonRules;
import Plants.PlantStateRules;
import Plants.SeasonEffects;
import Plants.StateRules;
import Seasons.Season;
import Seasons.SeasonEffect;

import java.util.ArrayList;
import java.util.Queue;


public class JsonReader {
	private Queue<Season> seasonsList;
	private ArrayList<Plant> plantsList;
	
	public JsonReader() {
		seasonsList = new LinkedList<>();
		plantsList = new ArrayList<Plant>();
		
	}

	public void loadSeasons() {
		JSONParser parser = new JSONParser();
		try (FileReader seasonsReader = new FileReader("../Caso_3_POO/src/Json/seasons.json")) {
			Object seasonsInfo = parser.parse(seasonsReader);
			JSONObject seasonsObject = (JSONObject) seasonsInfo;
			JSONArray seasonsJsonList = (JSONArray) seasonsObject.get("seasons");
			for(int index = 0; index<seasonsJsonList.size(); index++) {
				ArrayList<SeasonEffect> effects = new ArrayList<SeasonEffect>();
				Object eachSeason = seasonsJsonList.get(index);
				JSONObject currentSeason = (JSONObject) eachSeason;
				Season season = new Season();
				season.setStartDate((String) currentSeason.get("startDate"));
				//System.out.println(season.getStartDate());
				season.setEndDate((String) currentSeason.get("endDate"));
				season.setName((String) currentSeason.get("name"));
				//System.out.println(season.getName());
				season.setCondition((String) currentSeason.get("condition"));
				//System.out.println(season.getCondition());
				season.setMinSun(((Number) currentSeason.get("minSun")).intValue());  
				//System.out.println(season.getMinSun());
				season.setMaxSun(((Number) currentSeason.get("maxSun")).intValue());
				season.setMinRain(((Number) currentSeason.get("minRain")).intValue());
				season.setMaxRain(((Number) currentSeason.get("maxRain")).intValue());
				JSONArray effectsList = (JSONArray) currentSeason.get("effects");
				//System.out.println(effectsList.size());
				for(int counter = 0; counter < effectsList.size(); counter ++) {
					Object eachEffect = effectsList.get(counter);
					JSONObject currentEffect = (JSONObject) eachEffect;
					SeasonEffect actualEffect = new SeasonEffect();
					actualEffect.setAbonoEffect(((Number)currentEffect.get("abono")).intValue());
					actualEffect.setWatterEfect(((Number)currentEffect.get("water")).intValue());
					effects.add(actualEffect);
				}
				season.setEffects(effects);
				//System.out.println(effects.size());
				seasonsList.add(season);
			}
			
		} catch (FileNotFoundException e) {		// por si el archivo no se encuentra
			e.printStackTrace();
		} catch (IOException e) {		// por si no se puede leer
			e.printStackTrace();
		} catch (ParseException e) {	// error de parse
			e.printStackTrace();
		}

	}
	public static SeasonEffects loadPlantsSeasonRules(SeasonEffects pSeasonEffect, JSONArray pWaterRules, JSONArray pAbonoRules) {
		ArrayList<Rules> plantWaterRule = new ArrayList<Rules>();
		ArrayList<Rules> plantAbonoRule = new ArrayList<Rules>();
		for(int index = 0; index < pWaterRules.size() ; ++index) {
			Object acturalWaterRule = pWaterRules.get(index);
			JSONObject currentWaterRule = (JSONObject) acturalWaterRule;
			Rules waterRule = new Rules();
			waterRule.setEffect(((Number)currentWaterRule.get("efecto")).intValue());
			waterRule.setMinAmount(((Number)currentWaterRule.get("minWater")).intValue());
			waterRule.setMaxAmount(((Number)currentWaterRule.get("maxWater")).intValue());
			waterRule.setTime(((Number)currentWaterRule.get("Tiempo")).intValue());
			//System.out.println("efecto del agua " + waterRule.getEffect());
			plantWaterRule.add(waterRule);
			pSeasonEffect.setWaterRules(plantWaterRule);
		}						
		for(int counter = 0;  counter< pAbonoRules.size() ; ++counter) {
			Object actualAbonoRule = pAbonoRules.get(counter);
			JSONObject currentAbonoRule = (JSONObject) actualAbonoRule;
			Rules abonoRule = new Rules();
			abonoRule.setEffect(((Number)currentAbonoRule.get("efecto")).intValue());
			abonoRule.setMinAmount(((Number)currentAbonoRule.get("minAbono")).intValue());
			abonoRule.setMaxAmount(((Number)currentAbonoRule.get("maxAbono")).intValue());
			abonoRule.setTime(((Number)currentAbonoRule.get("Tiempo")).intValue());
			//System.out.println("efecto del abono " + abonoRule.getEffect());
			plantAbonoRule.add(abonoRule);
			pSeasonEffect.setAbonoRules(plantAbonoRule);

		}
		return pSeasonEffect;
		
	}
	
	public static ArrayList<PlantSeasonRules> loadPlantsSeasons(JSONObject pCurrentPlant) {
		ArrayList<PlantSeasonRules> seasonsPlantRules = new ArrayList<PlantSeasonRules>();
		JSONArray seasonsRules = (JSONArray) pCurrentPlant.get("seasons");
		// se recorre cada estacion del a;o
		for(int climaticStation = 0; climaticStation < seasonsRules.size(); ++climaticStation) {
			Object eachClimaticStation = seasonsRules.get(climaticStation);
			JSONObject currentClimaticStation = (JSONObject) eachClimaticStation;
			PlantSeasonRules seasonRules = new PlantSeasonRules();
			seasonRules.setName((String)currentClimaticStation.get("name"));
			seasonRules.setEffect(((Number)currentClimaticStation.get("efecto")).intValue());
			JSONArray currentSeasonRules = (JSONArray) currentClimaticStation.get("rules");
			for (int index = 0; index < currentSeasonRules.size(); ++index) {
				Object currentSPRule = currentSeasonRules.get(index);
				JSONObject currentSeasonRule = (JSONObject) currentSPRule;
				SeasonEffects seasonEffect = new SeasonEffects();
				seasonEffect.setId(((Number)currentSeasonRule.get("id")).intValue());
				//System.out.println(" id de la estacion " + seasonEffect.getId());
				
				seasonEffect.setEffect(((Number)currentSeasonRule.get("efecto")).intValue());
				JSONArray waterRules = (JSONArray) currentSeasonRule.get("water");
				JSONArray abonoRules = (JSONArray) currentSeasonRule.get("abono");
				// recorrer reglas de comportamiento agua
				ArrayList<SeasonEffects> plantSeasonsRules = new ArrayList<SeasonEffects>();
				plantSeasonsRules.add(loadPlantsSeasonRules(seasonEffect, waterRules, abonoRules));

				seasonRules.setSeasonRules(plantSeasonsRules);
				seasonsPlantRules.add(seasonRules);
			}
		}
		return seasonsPlantRules;
		
	}
	
	public void loadPlants() {
		JSONParser parser = new JSONParser();
		try (FileReader plantsReader = new FileReader("../Caso_3_POO/src/Json/plants.json")){
			Object plants = parser.parse(plantsReader);
			JSONObject plantsObject = (JSONObject) plants;
			JSONArray plantsJsonList = (JSONArray)plantsObject.get("plantas");
			// se recorre cada planta en el archivo
			for(int index = 0; index<plantsJsonList.size(); index++) {
				ArrayList <PlantStateRules> stateRules =  new ArrayList <PlantStateRules>();  
				ArrayList<StateRules> stateRulesPlant = new ArrayList<StateRules>();
				Object eachPlant = plantsJsonList.get(index);
				JSONObject currentPlant = (JSONObject) eachPlant;
				Plant plant = new Plant();
				plant.setName((String) currentPlant.get("nombre"));
				//System.out.println(plant.getName());
				JSONArray statesList = (JSONArray) currentPlant.get("seasons");
				//System.out.println("tamanioooo: " + statesList.size());
				//JSONArray seasonsRules = (JSONArray) currentPlant.get("seasons");
				// se inicializa la info de los estados de la planta
				plant.setStatesRules(loadPlantsStates(currentPlant, plantsJsonList, stateRulesPlant, stateRules));
				plant.setSeasonsRules(loadPlantsSeasons(currentPlant));
				plantsList.add(plant);
			}
			//System.out.println(" cantidad de plantas " + plantsList.size());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	public static ArrayList <PlantStateRules> loadPlantsStates(JSONObject pCurrentPlant, JSONArray pPlantsJsonList, ArrayList<StateRules> pStateRulesPlant, ArrayList <PlantStateRules> pStateRules) {
		//System.out.println(pCurrentPlant.get("nombre"));

		JSONArray statesList = (JSONArray) pCurrentPlant.get("states");
		//System.out.println(" tamano " + statesList.size());

		for(int counter = 0; counter < statesList.size(); ++counter) {
			Object eachState = statesList.get(counter);
			JSONObject currentState = (JSONObject) eachState;
			PlantStateRules ActualState = new PlantStateRules();
			ActualState.setId(((Number)currentState.get("id")).intValue());
			ActualState.setMinLife(((Number)currentState.get("minLife")).intValue());
			ActualState.setMaxLife(((Number)currentState.get("maxLife")).intValue());
			ActualState.setName((String)currentState.get("name"));
			ActualState.setName((String)currentState.get("foto"));
			ActualState.setMaxLife(((Number)currentState.get("maxLife")).intValue());					
			JSONArray currentStateRules = (JSONArray) currentState.get("rules");
			for(int rule = 0; rule < currentStateRules.size() ; ++rule) {
				StateRules plantStateRules = new StateRules();
				Object eachRule = currentStateRules.get(rule);
				JSONObject currentRule = (JSONObject) eachRule;
				plantStateRules.setTime(((Number)currentRule.get("tiempo")).intValue());
				plantStateRules.setMinWater(((Number)currentRule.get("minWater")).intValue());
				plantStateRules.setMaxWater(((Number)currentRule.get("maxWater")).intValue());
				plantStateRules.setMinAbono(((Number)currentRule.get("minAbono")).intValue());
				plantStateRules.setMaxAbono(((Number)currentRule.get("maxAbono")).intValue());
				plantStateRules.setEffect(((Number)currentRule.get("efecto")).intValue());
				pStateRulesPlant.add(plantStateRules);
			}
			
			ActualState.setStateRulesPlant(pStateRulesPlant);
			pStateRules.add(ActualState);
		}
		return pStateRules;
		
	}

	public Queue<Season> getSeasonsList() {
		return seasonsList;
	}

	public void setSeasonsList(Queue<Season> seasonsList) {
		this.seasonsList = seasonsList;
	}

	public ArrayList<Plant> getPlantsList() {
		return plantsList;
	}

	public void setPlantsList(ArrayList<Plant> plantsList) {
		this.plantsList = plantsList;
	}
}
