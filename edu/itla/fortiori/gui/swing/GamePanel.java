package edu.itla.fortiori.gui.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.itla.fortiori.config.PropertyConfigurationManager;
import edu.itla.fortiori.config.base.ConfigurationManager;

public class GamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GamePanel instance;

	public ConfigurationManager getConfig() {
		return config;
	}


	private ImageIcon background;
	private ConfigurationManager config;
	private WordManager word;

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
		setVisible(true);
	}

	public void init() {
		if (getGraphics() != null) {

			word = WordManager.getInstance();
			word.setGraphic(getGraphics());
			//SwingUtilities.invokeLater(word);
			word.start();
		} else {
			System.err
					.println("Cannot access to the Graphics Object from the Game Panel");
		}

	}


	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);
	}

}
