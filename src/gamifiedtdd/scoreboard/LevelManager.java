package gamifiedtdd.scoreboard;

import gamifiedtdd.level.Level;

import org.eclipse.swt.graphics.Image;

public interface LevelManager {

	Level getDefault();

	Image getDefaultHealth();

}
