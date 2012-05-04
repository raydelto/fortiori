package edu.itla.fortiori.gui.swing;

import javax.swing.JFrame;

import edu.itla.fortiori.config.PropertyConfigurationManager;
import edu.itla.fortiori.gui.base.GraphicInterface;

public class SwingInterface implements GraphicInterface {
	private JFrame window;
	private PropertyConfigurationManager config;
	private static SwingInterface instance;
	
	public static synchronized SwingInterface getInstance(){
		if(instance == null){
			instance = new SwingInterface();
		}
		return instance;
	}

	private SwingInterface() {
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
	
	public void end(String result){
		window.remove(GamePanel.getInstance());
		window.add(ResultPanel.getInstance());
		if("win".equalsIgnoreCase(result)){
			ResultPanel.getInstance().win();
		}else{
			ResultPanel.getInstance().loose();
		}
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
