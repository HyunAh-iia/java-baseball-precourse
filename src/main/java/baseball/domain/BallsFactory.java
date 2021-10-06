package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallsFactory {
	private static final int DEFAULT_LENGTH = 3;

	public static List<Ball> makeAnswer() {
		Set<Ball> answer = new HashSet<>();
		while (answer.size() != DEFAULT_LENGTH) {
			answer.add(new Ball());
		}
		return new ArrayList<>(answer);
	}

	public static List<Ball> convertBalls(String input) {
		List<Ball> balls = new ArrayList<>();
		input.chars().forEach(ball -> balls.add(new Ball(Character.getNumericValue(ball))));
		if (new HashSet<>(balls).size() != DEFAULT_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 중복되지 않은 3개의 숫자를 입력해주세요.");
		}
		return balls;
	}
}
