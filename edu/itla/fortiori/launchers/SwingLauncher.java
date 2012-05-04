package edu.itla.fortiori.launchers;

import edu.itla.fortiori.core.levels.RawLevelProvider;
import edu.itla.fortiori.gui.swing.SwingInterface;
import edu.itla.fortiori.gui.swing.WordManager;

/*
 * @author Raydelto Hernández
 * Launcher class for Swing User Interface
 */
public class SwingLauncher {
	public static void main(String[] args) throws Exception{
		SwingInterface swing = SwingInterface.getInstance();
		WordManager.getInstance().setLevel(new RawLevelProvider().getFirstLevel());
		//ScreenManager.getInstance().setFullScreen(new DisplayMode(800, 600, 32, 0));
		swing.start();
		
		
	}
}
