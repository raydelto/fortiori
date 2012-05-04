package edu.itla.fortiori.core.levels;

import java.util.ArrayList;
import java.util.List;

import edu.itla.fortiori.gui.swing.Word;

public class RawLevelProvider implements LevelProvider{
	private List<Level> levels;
	
	public RawLevelProvider(){
		ArrayList<Word> words = new ArrayList<Word>();
		words.add(new Word("Carro",10,-40,4,true));
		words.add(new Word("Yamar",230,-40,7,false));
		words.add(new Word("Hayga",530,-40,8,false));	
		words.add(new Word("Introdusca",100,-40,4,false));
		words.add(new Word("Selular",330,-40,7,false));
		words.add(new Word("Baca",630,-40,8,false));
		
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
