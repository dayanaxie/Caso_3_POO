package Managers;

import java.util.Queue;

import Seasons.Season;
import VirtualGarden.Constants;

class Time extends Thread{
	private int startDay = 1;
	private int currentMonth = 1;
	
	public void run(Queue<Season> seasonsList) {
		try {
			System.out.print("Fecha: " + startDay + "/" + currentMonth + "/2022");
			System.out.print("Estacion Actual: " + seasonsList.peek().getName());

			for(int second = 0; second <= Constants.anioEnSegundos; ++second) {
				
				if(second == Constants.diaEnSegundos) {
					this.startDay += 1;
					System.out.print("Fecha: " + startDay + "/" + currentMonth + "/2022");
					
					// revisar el las reglas de abono y agua de las plantas
					// revisar las reglas del season
				}
				if(second == Constants.mesEnSegundos) {
					startDay = 0;
					currentMonth += 1;
					System.out.print("Fecha: " + startDay + "/" + currentMonth + "/2022");
					Season lastSeason = seasonsList.remove();
					System.out.print("Estacion Actual: " + seasonsList.peek().getName());
					seasonsList.add(lastSeason);
					// revisar las reglas de las estaciones
					
					
				}
				
			
			}
		}
		catch (Exception expn) {
			System.out.println(expn);  
		}
		
	}

}
	
