package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BallsFactory {
	private static final int DEFAULT_LENGTH = 3;

	public static List<Ball> makeAnswer() {
		Set<Ball> balls = new LinkedHashSet<>();
		while (balls.size() != DEFAULT_LENGTH) {
			balls.add(new Ball());
		}
		return new ArrayList<>(balls);
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
