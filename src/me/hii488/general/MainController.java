package me.hii488.general;

import me.hii488.simulator.Circuit;
import me.hii488.window.Listener;
import me.hii488.window.Window;

public class MainController {
	
	public static void main(String[] args){
		startProgram();
	}
	
	
	public static Listener inputListener = new Listener();
	public static Window mainWindow;
	public static Circuit mainCircuit = new Circuit();
	public static boolean running = true;
	
	public static void startProgram(){
		running = true;
		mainWindow = new Window("Logic Gate Simulator", 1200, 750);
		
		Circuit.newCircuit();
		
		mainWindow.start();
	}
	
	public static void endProgram(){
		running = false;
	}
	
}
