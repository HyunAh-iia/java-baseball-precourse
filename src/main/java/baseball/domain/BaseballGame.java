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
		this.answer = BallsFactory.makeAnswer();
		getAnswer();
		play();
	}

	public void getAnswer() {
		System.out.print(answer.toString());
	}

	public void play() {
		//todo 메소드 길이
		boolean isCorrect = false;
		try {
			//todo 뎁스
			while (!isCorrect) {
				String playerInput = Player.write();
				List<Ball> playerBalls = BallsFactory.convertBalls(playerInput);
				Board board = new Board(answer, playerBalls);
				Computer.printResult(board.isCorrect(), board.getStrike(), board.getBall());
				isCorrect = board.isCorrect();
			}
			finish(Player.end());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			play();
		}
	}

	public void finish(String replayOrEnd) {
		if (replayOrEnd.equals(REPLAY)) {
			replay();
		}
	}

	//todo 중복제거
	private void replay() {
		this.answer = BallsFactory.makeAnswer();
		getAnswer();
		play();
	}
}
