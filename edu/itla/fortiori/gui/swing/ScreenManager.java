package edu.itla.fortiori.gui.swing;

import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferStrategy;

public class ScreenManager {
	private GraphicsDevice device;
	private static ScreenManager instance;
	public synchronized static ScreenManager getInstance(){
		if(instance == null){
			instance = new ScreenManager();
		}
		return instance;
	}
	private ScreenManager(){
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		device = env.getDefaultScreenDevice();
	}
	
	public DisplayMode[] getCompatibleDisplayModes(){
		return device.getDisplayModes();
	}
	
	public DisplayMode findFirstCompatibleMode(DisplayMode modes[]){
		DisplayMode goodModes[] = device.getDisplayModes();
		for(DisplayMode gMode:goodModes){
			for(DisplayMode mode:modes){
				if(gMode.equals(mode)){
					return mode;
				}
			}
		}
		return null;
	}
	
	public DisplayMode getCurrentDisplayMode(){
		return device.getDisplayMode();
	}
	
	public void setFullScreen(DisplayMode displayMode){
		//device.isDisplayChangeSupported()
		if(displayMode != null ){
			try{
				device.setDisplayMode(displayMode);
			}catch(Exception e){
				System.out.println("Error while creating Full-Screen Window");
				e.printStackTrace();
			}
		}
	}
	
	public Graphics2D getGraphics(){
		Window window = device.getFullScreenWindow();
		if(window != null){
			BufferStrategy strategy = window.getBufferStrategy();
			return (Graphics2D) strategy.getDrawGraphics();
		}
		return null;
	}
	
	public void update(){
		Window window = device.getFullScreenWindow();
		if(window != null){
			BufferStrategy strategy = window.getBufferStrategy();
			if(!strategy.contentsLost()){
				strategy.show();
			}
		}
		Toolkit.getDefaultToolkit().sync();
	}
	
	public Window getFullScreenWindow(){
		return device.getFullScreenWindow();
	}
	
	public int getWidth(){
		return getFullScreenWindow() != null?getFullScreenWindow().getWidth():-1;		
	}
	
	public int getHeight(){
		return getFullScreenWindow() != null?getFullScreenWindow().getHeight():-1;		
	}
	
	public void restoreScreen(){
		Window window = device.getFullScreenWindow();
		if (window != null){
			window.dispose();
		}
		device.setFullScreenWindow(null);
	}

	
	
}
