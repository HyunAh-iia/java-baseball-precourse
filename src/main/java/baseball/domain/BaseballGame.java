package baseball.domain;

import java.util.List;

import baseball.view.Computer;
import baseball.view.Player;

public class BaseballGame {
	private List<Ball> answer;

	public BaseballGame() {
		start();
	}

	public void play() {
		boolean isCorrect = false;
		while (!isCorrect) {
			String playerInput = Player.write();
			List<Ball> playerBalls = BallsFactory.convertBalls(playerInput);
			Board board = new Board(answer, playerBalls);
			Computer.printResult(board.isCorrect(), board.getStrike(), board.getBall());
			isCorrect = board.isCorrect();
		}
		finish(Player.hopeToReplay());
	}

	public void finish(boolean replay) {
		if (replay) {
			start();
		}
	}

	private void start() {
		this.answer = BallsFactory.makeAnswer();

		try {
			play();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			play();
		}
	}
}
