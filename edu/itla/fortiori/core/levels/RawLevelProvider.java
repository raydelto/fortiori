package edu.itla.fortiori.core.levels;

import java.util.ArrayList;
import java.util.List;

import edu.itla.fortiori.gui.swing.Word;

public class RawLevelProvider implements LevelProvider{
	private List<Level> levels;
	
	public RawLevelProvider(){
		Word yeah = new Word("Yeah",10,-40,4,true);
		Word francais = new Word("Francais",230,-40,7,false);
		Word palma = new Word("Palma",530,-40,8,true);
		ArrayList<Word> words = new ArrayList<Word>();
		words.add(yeah);
		words.add(francais);
		words.add(palma);
		Level test = new Level("Nivel de prueba","clouds.png",3,words);
		levels = new ArrayList<Level>();
		levels.add(test);
	}

	@Override
	public List<Level> getLevels() {

		return levels ;
	}

	@Override
	public Level getFirstLevel() {
		// TODO Auto-generated method stub
		return levels.get(0);
	}

}
