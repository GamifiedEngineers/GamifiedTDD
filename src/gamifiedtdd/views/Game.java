package gamifiedtdd.views;

import gamifiedtdd.level.Level;
import gamifiedtdd.scoreboard.GameObserver;

public interface Game {

	void beHappy();

	void beUpset();

	void onImageSetCallback();

	void setLevel(Level level);

	void addObserver(GameObserver observer);

	void start();

}
