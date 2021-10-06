package baseball.domain;

import java.util.List;

public class Board {
	private int strike = 0;
	private int ball = 0;
	private boolean isCorrect = false;

	public Board(List<Ball> computerBalls, List<Ball> playerBalls) {
		for (int i = 0; i < computerBalls.size(); i++) {
			this.strike += isStrike(computerBalls.get(i), playerBalls.get(i)) ? 1 : 0;
			this.ball += isBall(computerBalls, playerBalls.get(i)) ? 1 : 0;
		}
		this.ball -= this.strike;
		this.isCorrect = this.strike == computerBalls.size();
	}

	public boolean isCorrect() {
		return this.isCorrect;
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	private static boolean isStrike(Ball computerBall, Ball playerBall) {
		if (computerBall.equals(playerBall)) {
			return true;
		}
		return false;
	}

	private static boolean isBall(List<Ball> computerBalls, Ball playerBall) {
		if (computerBalls.contains(playerBall)) {
			return true;
		}
		return false;
	}
}
