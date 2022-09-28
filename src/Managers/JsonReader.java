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
		//String currentDir = new File(".").getAbsolutePath();

		try (FileReader seasonsReader = new FileReader("../Caso_3/src/Json/seasons.json")) {
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
				//System.out.println(season.getMinSun() + 1);
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

	public static void loadPlants() {
		JSONParser parser = new JSONParser();
		//String currentDir = new File(".").getAbsolutePath();
		//try (FileReader plantsReader = new FileReader(currentDir + "file/plants.json"))
		try (FileReader plantsReader = new FileReader("../Caso_3/src/Json/plants.json")){
			Object plants = parser.parse(plantsReader);
			JSONObject plantsObject = (JSONObject) plants;
			JSONArray plansJsonList = (JSONArray)plantsObject.get("plants");
			for(int index = 0; index<plansJsonList.size(); index++) {
				ArrayList<Integer> estados = new ArrayList<Integer>();
				Object eachSeason = seasonsJsonList.get(index);
				JSONObject currentSeason = (JSONObject) eachSeason;
				Season season = new Season();

				
				
				
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
