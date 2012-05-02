package edu.itla.fortiori.gui.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

import edu.itla.fortiori.core.levels.Level;

public class WordManager extends Thread {
	private Graphics g;
	private int y;
	private static WordManager instance;
	private int score;
	private JLabel scoreLabel = new JLabel("Puntuación: " + score);	
	private Level level;
	
	public static synchronized WordManager getInstance(){
		if(instance == null){
			instance = new WordManager();
		}
		return instance;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public Graphics getGraphic() {
		return g;
	}

	public void setGraphic(Graphics graphic) {
		this.g = graphic;
	}

	private ScreenManager screen;

	private WordManager() {
		screen = ScreenManager.getInstance();
		//SwingUtilities.invokeLater(francais);
		
		
		scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
		scoreLabel.setForeground(new Color(244, 164, 96));				

	}

	@Override
	public void run() {		
		
		/*new Thread(yeah).start();
		new Thread(francais).start();
		new Thread(palma).start();*/
		scoreLabel.setLocation(0, 0);
		GamePanel.getInstance().add(scoreLabel);
		
		for(Word word: level.getWords()){
			GamePanel.getInstance().add(word);
			new Thread(word).start();
		}

/*		Word yeah = new Word("Yeah",10,-40,4,true);
		Word francais = new Word("Francais",230,-40,7,false);
		Word palma = new Word("Palma",530,-40,8,true);

		
		GamePanel.getInstance().add(yeah);
		GamePanel.getInstance().add(francais);
		GamePanel.getInstance().add(palma);
		
		
		//SwingUtilities.invokeLater(yeah);
		//SwingUtilities.invokeLater(palma);
		new Thread(yeah).start();
		new Thread(francais).start();
		new Thread(palma).start();*/
		
		
		
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score){
		this.score = score;
		scoreLabel.setText("Puntuación: " + score);
	}
	
}
