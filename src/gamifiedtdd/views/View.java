package gamifiedtdd.views;

import org.eclipse.swt.graphics.Image;

public interface View {

	void setImage(Image image);

	void updateScore(int points);

	void updateHealth(Image health);

}
