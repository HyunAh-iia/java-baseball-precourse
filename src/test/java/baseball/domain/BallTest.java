package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallTest {
	@DisplayName("볼 생성")
	@Test
	public void testCreateBall() {
		//given
		int minNumber = 1;
		int maxNumber = 9;

		//when
		Ball ball = new Ball();

		//then
		assertThat(ball.getNumber()).isGreaterThanOrEqualTo(minNumber);
		assertThat(ball.getNumber()).isLessThanOrEqualTo(maxNumber);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 99})
	@DisplayName("유효하지 않은 볼 입력")
	public void testIllegalBall(int input) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Ball(input);
		});
	}
}
