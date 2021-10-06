package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
