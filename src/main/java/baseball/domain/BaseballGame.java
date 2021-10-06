package baseball.domain;

import java.util.List;

import baseball.view.Player;

public class BaseballGame {
	private List<Ball> answer;

	public BaseballGame() {
		this.answer = BallsFactory.makeAnswer();
		play();
	}

	public void play() {
		String playerBalls = Player.write();
		try {
			List<Ball> balls = BallsFactory.convertBalls(playerBalls);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			play();
		}
	}
}
