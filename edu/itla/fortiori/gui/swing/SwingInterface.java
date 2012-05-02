package edu.itla.fortiori.gui.swing;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import edu.itla.fortiori.config.PropertyConfigurationManager;
import edu.itla.fortiori.gui.base.GraphicInterface;

public class SwingInterface implements GraphicInterface {
	private JFrame window;
	private PropertyConfigurationManager config;

	public SwingInterface() {
		config = PropertyConfigurationManager.getInstance();
	}

	@Override
	public void start(Object... initParams) {
		window = new JFrame("Gestor Ortográfico Fortiori");

		window.add(GamePanel.getInstance());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(10, 10, Integer.parseInt(config.getConfig("width")),
				Integer.parseInt(config.getConfig("height")));
		window.setVisible(true);
		GamePanel.getInstance().init();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
