package gamifiedtdd.scoreboard;

import gamifiedtdd.level.DefaultLevel;
import gamifiedtdd.level.Level;

import org.eclipse.swt.graphics.Image;


public class TinyLevelManager implements LevelManager {

	private final Level defaultLevel;

	public TinyLevelManager() {
		this(new DefaultLevel());
	}

	public TinyLevelManager(Level defaultLevel) {
		this.defaultLevel = defaultLevel;
	}

	@Override
	public Level getDefault() {
		return defaultLevel;
	}

	@Override
	public Image getDefaultHealth() {
		return defaultLevel.getHealth();
	}

}
