package baseball.domain;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import baseball.Application;
import nextstep.test.NSTest;
import nextstep.utils.Randoms;

public class BaseballGameTest extends NSTest {
	@BeforeEach
	void beforeEach() {
		super.setUp();
	}

	@DisplayName("정답 후 재시작 테스트") //todo 내 방식으로 변경
	@Test
	void testValidateResult() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 2, 3)
				.thenReturn(5, 8, 9);
			run("123", "1", "597", "589", "2");
			verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
		}
	}

	@AfterEach
	void tearDown() {
		outputStandard();
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}
}
