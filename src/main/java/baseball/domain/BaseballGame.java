package baseball.domain;

import java.util.List;

import baseball.view.Computer;
import baseball.view.Player;

//todo 컨트롤러로 분리
public class BaseballGame {
	private static String REPLAY = "1";
	private static String END = "2";

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
		finish(Player.end());
	}

	public void finish(String replayOrEnd) {
		if (replayOrEnd.equals(REPLAY)) {
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
