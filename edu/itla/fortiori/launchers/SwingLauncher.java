package edu.itla.fortiori.launchers;

import javax.swing.SwingUtilities;

import edu.itla.fortiori.gui.swing.SwingInterface;

/*
 * @author Raydelto Hernández
 * Launcher class for Swing User Interface
 */
public class SwingLauncher {
	public static void main(String[] args) throws Exception{
		SwingInterface swing = new SwingInterface();
		swing.start();
		
	}
}
