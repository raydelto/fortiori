package edu.itla.fortiori.gui.swing;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import edu.itla.fortiori.config.PropertyConfigurationManager;

public class GamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GamePanel instance;
	private ImageIcon background;
	private PropertyConfigurationManager config;

	public static synchronized GamePanel getInstance() {
		if (instance == null) {
			instance = new GamePanel();
		}
		return instance;
	}

	private GamePanel() {
		setOpaque(false);
		config = PropertyConfigurationManager.getInstance();
		background = new ImageIcon(config.getConfig("background"));

	}

	/*
	 * @Override public void paintComponent(Graphics g) {
	 * super.paintComponent(g); drawBackground(g);
	 * 
	 * 
	 * }
	 * 
	 * private void drawBackground(Graphics g) { g.drawImage(background, 0, 0,
	 * this.getWidth(), this.getHeight(), null); }
	 */

	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);
	}

}
