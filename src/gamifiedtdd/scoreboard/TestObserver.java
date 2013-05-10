package gamifiedtdd.scoreboard;

public interface TestObserver {
	void onPassingTest();

	void onFailingTest();
}
