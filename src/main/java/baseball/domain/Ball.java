package baseball.domain;

import java.util.Objects;

import nextstep.utils.Randoms;

public class Ball {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private int number;

	public Ball() {
		this.number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}

	public Ball(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 유효한 숫자는 1과 9 사이입니다.");
		}
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return number == ball.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
