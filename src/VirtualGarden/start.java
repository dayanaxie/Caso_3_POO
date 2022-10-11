package VirtualGarden;

import java.util.ArrayList;
import java.util.Queue;

import Managers.GardenMainFrameController;
import Managers.Time;
import Plants.Plant;
import Seasons.Season;
import UI.VirtualGardenMainFrame;

public class start {
	public static void main(String[] args) {
		GardenMainFrameController controller = new GardenMainFrameController();
		
		VirtualGardenMainFrame ui = new VirtualGardenMainFrame("Virtual Garden", controller);
		
		
	}
	

}
