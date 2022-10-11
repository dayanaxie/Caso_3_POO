package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;


import Managers.GardenMainFrameController;
import Plants.Plant;
import VirtualGarden.VirtualGardenController;

public class VirtualGardenMainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private boolean simulationStarted = false;

	// se guarda quien es el controlador
	private GardenMainFrameController controller;
//, ArrayList<Plant> pPlantsList
	public VirtualGardenMainFrame(String pTitle, GardenMainFrameController pController) {
		super(pTitle);
		controller = pController;
		controller.setWindow(this);
		// que hace el boton de x
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// cambiar de tamano
		this.setResizable(true);
		// origen donde aparece y el tamanio
		this.setBounds(0,0,1200,500);
		
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setBackground(Color.white);
		this.initComponents(pController); //pPlantsList
		this.setVisible(true);
	}
	
	private void initComponents(GardenMainFrameController pController) {
		VirtualGardenController gardenController = new VirtualGardenController();
		JLabel instructions = new JLabel("Agregar tipo de planta:");
		instructions.setBounds(1000, 20, 160,20);
		this.add(instructions);
		
		JButton btnManzano = new JButton("Manzano");
		btnManzano.setBounds(1000, 60, 160, 20);
		btnManzano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gardenController.informPlantManager(0);
				if(simulationStarted == false) {
					simulationStarted = true;
					gardenController.startSimulation();
					
				}
				else {
					JButton btnRegarManzano = new JButton("Regar");
					btnRegarManzano.setBounds(1000, 60, 160, 20);
				}
				
				
			}
			
		});
		this.add(btnManzano);
		
		JButton btnCactus = new JButton("Cactus");
		btnCactus.setBounds(1000, 80, 160, 20);
		btnCactus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startSimulation(pController);
				gardenController.informPlantManager(1);
				if(simulationStarted == false) {
					simulationStarted = true;
					
				}
				
			}
			
		});
		this.add(btnCactus);
		
		JButton btnCulantro = new JButton("Culantro");
		btnCulantro.setBounds(1000, 100, 160, 20);
		btnCulantro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gardenController.informPlantManager(2);
				if(simulationStarted == false) {
					simulationStarted = true;
					
				}
				
			}
			
		});
		this.add(btnCulantro);
	}
	
	
	public void startSimulation(GardenMainFrameController pController) {
		JLabel station = new JLabel("Estacion Actual");
		station.setBounds(100, 20, 160,20);
		this.add(station);

	}

}
