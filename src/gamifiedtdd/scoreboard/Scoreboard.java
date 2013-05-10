package gamifiedtdd.scoreboard;

import gamifiedtdd.subscriber.JUnitTestSubscriber;
import gamifiedtdd.subscriber.RefactoringSubscriber;
import gamifiedtdd.subscriber.TestSubscriber;
import gamifiedtdd.subscriber.TinyRefactoringSubscriber;
import gamifiedtdd.views.Game;
import gamifiedtdd.views.GameMock;
import gamifiedtdd.views.View;

import org.eclipse.swt.graphics.Image;

public class Scoreboard implements TestObserver, RefactoringObserver, GameObserver {

	private final View view;
	private final TestSubscriber testSubscriber;
	private final RefactoringSubscriber refactoringSubscriber;
	private final Game game;
	private final LevelManager levels;

	private TestRun previousTestRun;
	private int score;

	private enum TestRun {
		PASS, FAIL
	}

	public Scoreboard(View view) {
		this(view, new GameMock(), new JUnitTestSubscriber(), new TinyRefactoringSubscriber(), new TinyLevelManager());
	}

	public Scoreboard(View view, Game game, TestSubscriber testSubscriber,
			RefactoringSubscriber refactoringSubscriber, LevelManager levels) {
		this.view = view;
		this.game = game;
		this.testSubscriber = testSubscriber;
		this.refactoringSubscriber = refactoringSubscriber;
		this.levels = levels;

		subscribeToJUnitEvents();
		subscribeToRefactoringEvents();
		startGame(game);
	}

	@Override
	public void onPassingTest() {
		if (TestRun.FAIL.equals(previousTestRun)) {
			game.beHappy();
			updateScoreWith(1);
		}
		previousTestRun = TestRun.PASS;
	}

	@Override
	public void onFailingTest() {
		if (TestRun.FAIL.equals(previousTestRun)) {
			game.beUpset();
			updateScoreWith(-5);
		}
		previousTestRun = TestRun.FAIL;
	}

	@Override
	public void onRefactoring() {
		game.beHappy();
		updateScoreWith(1);
	}

	@Override
	public void updateMood(Image image) {
		view.setImage(image);
	}

	private void updateScoreWith(int points) {
		score += points;

		view.updateScore(score);
		updateTamagoshiAndHealthLevel();
	}

	private void updateTamagoshiAndHealthLevel() {
			game.setLevel(levels.getDefault());
			view.updateHealth(levels.getDefaultHealth());
			return;
	}

	private void startGame(Game game) {
		game.setLevel(levels.getDefault());
		game.addObserver(this);
		game.start();
	}

	private void subscribeToJUnitEvents() {
		testSubscriber.subscribe(this);
	}

	private void subscribeToRefactoringEvents() {
		refactoringSubscriber.subscribe(this);
	}

	public void onImageSetCallback() {
		game.onImageSetCallback();
	}

	public Image getDefaultHealth() {
		return levels.getDefaultHealth();
	}

}
