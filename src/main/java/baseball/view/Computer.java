package baseball.view;

public class Computer {
	private static String STRIKE_MESSAGE = "%d스트라이크\n";
	private static String STRIKE_AND_BALL_MESSAGE = "%d스트라이크 %d볼\n";
	private static String BALL_MESSAGE = "%d볼\n";
	private static String NOTHING_MESSAGE = "낫싱\n";
	private static String ANSWER_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 끝\n";

	//todo 메소드 길이
	public static void printResult(boolean isCorrect, int strike, int ball) {
		if (isCorrect) {
			System.out.printf(STRIKE_MESSAGE, strike);
			System.out.printf(ANSWER_MESSAGE, strike);
			return;
		}

		if (strike > 0 && ball > 0) {
			System.out.printf(STRIKE_AND_BALL_MESSAGE, strike, ball);
			return;
		}

		if (ball == 0) {
			System.out.println(NOTHING_MESSAGE);
			return;
		}

		if (strike > 0) {
			System.out.printf(STRIKE_MESSAGE, strike);
			return;
		}

		if (ball > 0) {
			System.out.printf(BALL_MESSAGE, ball);
			return;
		}
	}
}
