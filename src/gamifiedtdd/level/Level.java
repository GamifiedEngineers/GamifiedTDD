package gamifiedtdd.level;

import org.eclipse.swt.graphics.Image;

public interface Level {

	Image[] getNormalMood();

	Image[] getHappyMood();

	Image[] getUpsetMood();

	Image getHealth();

}
