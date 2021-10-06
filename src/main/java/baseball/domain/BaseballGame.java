package baseball.domain;

import java.util.List;

public class BaseballGame {
	private List<Ball> answer;

	public BaseballGame() {
		this.answer = BallsFactory.makeAnswer();
	}
}
