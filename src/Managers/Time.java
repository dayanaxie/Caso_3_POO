package Managers;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Queue;

import Interfaces.IConstants;
import Interfaces.Observable;
import Plants.Plant;
import Seasons.Season;
import VirtualGarden.Constants;
import VirtualGarden.SimulatorReport;

public class Time extends Observable implements Runnable, IConstants{	
	private LocalTime startTime;
	private int currentSeason;
	private int dayPass;
	private boolean running = false;
	private int currentRain;
	LocalDate currentDate;
	private int currentTemperature;
	Queue<Season> seasonsList;
	ArrayList<Plant> currentPlantsInGarden;
	
	public Time(Queue<Season> pSeasonsList, ArrayList<Plant> pCurrentPlantsInGarden) {
		this.seasonsList = pSeasonsList;
		this.currentPlantsInGarden = pCurrentPlantsInGarden;
	}
	
	public void run() {
		startTime = LocalTime.now();
		currentDate = LocalDate.of(2022, 01, 01);
		SeasonManager seasonManager = new SeasonManager();
		running = true;
		while (running) {
			try {

				//this.plantManager.evaluate(dayPass);				
				System.out.println("Han pasado "+dayPass+" dias");
				System.out.println("Fecha: " + currentDate.toString());
				System.out.println("Estacion Actual: " + seasonsList.peek().getName());
				
				Thread.sleep(CHECKIN_TIME);
				// estacion que afecta a las plantas
				System.out.println("evaluar");
				currentPlantsInGarden = seasonManager.evaluate(currentPlantsInGarden, seasonsList);
				System.out.println()
				
				dayPass = (int)ChronoUnit.MILLIS.between(startTime, LocalTime.now()) / DAY_IN_MILLIS;
				SimulatorReport report = new SimulatorReport();
				report.action = UPDATE_DAYS;
				report.days = dayPass;
				
				currentDate = currentDate.plusDays(dayPass);
				//if()
				
				this.notifyObservers(report);
				seasonsList.remove();
				
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	// el hilo que va recorriendo las reglas del clima, cuando genera un cambio en el clima me lo reporta por este método
	public void updateWeather(int pTemp, int pRain) {
		this.currentTemperature = pTemp;
		this.currentRain = pRain;
		
		SimulatorReport report = new SimulatorReport();
		report.action = UPDATE_WEATHER;
		report.rain = pRain;
		report.temperature = pTemp;
		report.days = dayPass;
		
		this.notifyObservers(report);
	}
	
	public void stop() {
		running = false;
	}
	


}
	
