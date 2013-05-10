package gamifiedtdd.scoreboard;

import org.eclipse.swt.graphics.Image;

public interface MoodManager {

	enum Level {
		Default
	}

	Image[] getNormalMoodForLevel(Level level);

	Image[] getHappyMoodForLevel(Level level);

	Image[] getUpsetMoodForLevel(Level level);

	Image getHealthForLevel(Level level);
}
