package baseball.view;

import nextstep.utils.Console;

public class Player {
	private static String requireInput = "숫자를 입력해주세요 : ";
	private static String errorStringInput = "[ERROR] 숫자만 입력할 수 있습니다.";

	public static String write() {
		try {
			System.out.print(requireInput);
			String balls = Console.readLine();
			return validateBalls(balls);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return write();
		}
	}

	private static String validateBalls(String balls) {
		try {
			Integer.parseInt(balls);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(errorStringInput);
		}
		return balls;
	}
}
