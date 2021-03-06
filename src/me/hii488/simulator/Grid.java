package me.hii488.simulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;

import me.hii488.general.MainController;
import me.hii488.general.Settings;
import me.hii488.logicGates.LogicGate;
import me.hii488.window.GuiInternalsBridge;

public class Grid {
	
	// This is purely for aesthetics, GateMap will have circuit handling things.
	
	private int width, height; // Private to force use of setDimensions();
	
	private HashMap<Point, LogicGate> grid = new HashMap<Point, LogicGate>();
	
	public void addLogicGate(LogicGate l, Point p){
		if(!grid.containsKey(p)){
			grid.put(p, l);
			if(Settings.DEBUG) System.out.println("Logic Gate \"" + l.getName() + "\" added to point: " + p.toString()); 
		}
	}
	
	public void removeLogicGate(Point p){
		
		boolean found = false;
		for(int i = 0; i <=1 && !found; i++)
			for(int j = 0; j <=1 && !found; j++){
				if(grid.containsKey(new Point(p.x+ i, p.y + j))){
					grid.remove(new Point(p.x+ i, p.y + j));
					found = true;
				}
			}
	}
	
	public boolean setDimensions(int newWidth, int newHeight){
		for(Point p : grid.keySet()){
			if(p.x > newWidth || p.y > newHeight){
				return false;
			}
		}
		
		this.width = newWidth;
		this.height = newHeight;
		
		return true;
	}
	
	public int getWidth(){return width;}
	public int getHeight(){return height;}
	
	public void render(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.GRAY);
		
		for(int i = 0; i < MainController.mainWindow.gridFrame.getWidth()/20; i++){
			g.drawLine(i*20, 0, i*20, MainController.mainWindow.gridFrame.getHeight());
		}
		
		g.setColor(Color.GRAY);
		
		for(int i = 0; i < MainController.mainWindow.gridFrame.getHeight()/20; i++){
			g.drawLine(0, i*20, MainController.mainWindow.gridFrame.getWidth(), i*20);
		}
		g.setColor(c);
		
		for(Point p : grid.keySet()){
			if(grid.get(p).gateType.iconXPos > 0){
				g.drawImage(GuiInternalsBridge.gates, p.x*20-18, p.y*20-18, p.x*20+22, p.y*20+22, grid.get(p).gateType.iconXPos, 000, grid.get(p).gateType.iconXPos + 320, 300, null);
			}
		}
		
		
	}
	
}
