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
}
