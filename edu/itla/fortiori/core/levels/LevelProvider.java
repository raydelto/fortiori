package edu.itla.fortiori.core.levels;

import java.util.List;


public interface LevelProvider {
	
	public List<Level> getLevels();
	public Level getFirstLevel();
	
}
