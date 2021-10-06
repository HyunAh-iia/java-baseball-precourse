package baseball.view;

import nextstep.utils.Console;

public class Player {
	private static String REPLAY = "1"; //TODO enum
	private static String END = "2";
	private static String REQUIRE_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static String INPUT_ERROR_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다.";
	private static String END_MESSAGE = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";
	private static String END_ERROR_MESSAGE = "[ERROR] " + END_MESSAGE;

	public static String write() {
		try {
			System.out.print(REQUIRE_INPUT_MESSAGE);
			String balls = Console.readLine();
			return validateBalls(balls);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return write();
		}
	}

	public static String end() {
		try {
			System.out.printf(END_MESSAGE, REPLAY, END);
			String afterEnd = Console.readLine();
			return validateEnd(afterEnd);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return end();
		}
	}

	private static String validateBalls(String balls) {
		try {
			Integer.parseInt(balls);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
		}
		return balls;
	}

	private static String validateEnd(String afterEnd) {
		if (!afterEnd.equals(REPLAY) && !afterEnd.equals(END)) {
			throw new IllegalArgumentException(END_ERROR_MESSAGE);
		}
		return afterEnd;
	}
}
