package edu.itla.fortiori.core.levels;

import java.util.List;

import edu.itla.fortiori.gui.swing.Word;

public class Level {
	private String name;
	private String background;
	private int minSpeed;

	public Level() {
	}

	public Level(String name, String background, int minSpeed, List<Word> words) {
		super();
		this.name = name;
		this.background = background;
		this.minSpeed = minSpeed;
		this.words = words;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public int getMinSpeed() {
		return minSpeed;
	}

	public void setMinSpeed(int minSpeed) {
		this.minSpeed = minSpeed;
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	private List<Word> words;

}
