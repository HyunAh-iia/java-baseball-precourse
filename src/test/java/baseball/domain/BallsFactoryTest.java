package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallsFactoryTest {
	@DisplayName("정답 생성")
	@Test
	public void testCreateAnswer() {
		//given
		int defaultLength = 3;

		//when
		List<Ball> answer = BallsFactory.makeAnswer();

		//then
		assertThat(answer.size()).isEqualTo(defaultLength);
		assertThat(new HashSet<>(answer).size()).isEqualTo(defaultLength);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "012", "112", "67890"})
	@DisplayName("사용자의 올바르지 않은 입력값 검증")
	public void testValidateWrongBalls(String input) {
		assertThatIllegalArgumentException().isThrownBy(() ->
			BallsFactory.convertBalls(input)
		);
	}

	@DisplayName("사용자의 올바른 입력값 검증")
	@Test
	public void testValidateBalls() {
		//given
		String validatedValue = "123";
		int defaultLength = 3;

		//when
		List<Ball> balls = BallsFactory.convertBalls(validatedValue);

		//then
		assertThat(balls.size()).isEqualTo(defaultLength);
		for (int i = 0; i < defaultLength; i++) {
			assertThat(balls.get(i).getNumber()).isEqualTo(Character.getNumericValue(validatedValue.charAt(i)));
		}
	}
}
