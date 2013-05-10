package gamifiedtdd.views;

import gamifiedtdd.level.Level;
import gamifiedtdd.scoreboard.GameObserver;

import java.util.Stack;

import org.eclipse.swt.graphics.Image;

public class GameMock implements Game {

	private GameObserver observer;
	private Level level;
	private Stack<Image> moodStack = new Stack<Image>();

	@Override
	public void start() {
		pushToStack(level.getNormalMood());
		updateMood();
	}

	@Override
	public void beHappy() {
		pushToStack(level.getHappyMood());
	}

	@Override
	public void beUpset() {
		pushToStack(level.getUpsetMood());
	}

	@Override
	public void onImageSetCallback() {
		updateMood();
	}

	@Override
	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public void addObserver(GameObserver observer) {
		this.observer = observer;
	}

	private void updateMood() {
		if (moodStack.empty()) {
			pushToStack(level.getNormalMood());
		}

		observer.updateMood(moodStack.pop());
	}

	private void pushToStack(Image... images) {
		for (Image image : images) {
			moodStack.push(image);
		}
	}

}
