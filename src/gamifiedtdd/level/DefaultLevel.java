package gamifiedtdd.level;

import gamifiedtdd.scoreboard.MoodManager;

import org.eclipse.swt.graphics.Image;

public class DefaultLevel implements Level {

	private final MoodManager moodManager;

	public DefaultLevel() {
		this(new TinyMoodManager());
	}

	public DefaultLevel(MoodManager moodManager) {
		this.moodManager = moodManager;
	}

	@Override
	public Image[] getNormalMood() {
		return moodManager.getNormalMoodForLevel(MoodManager.Level.Default);
	}

	@Override
	public Image[] getHappyMood() {
		return moodManager.getHappyMoodForLevel(MoodManager.Level.Default);
	}

	@Override
	public Image[] getUpsetMood() {
		return moodManager.getUpsetMoodForLevel(MoodManager.Level.Default);
	}

	@Override
	public Image getHealth() {
		return moodManager.getHealthForLevel(MoodManager.Level.Default);
	}

}
