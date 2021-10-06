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

public class BoardTest extends NSTest {
	@BeforeEach
	void beforeEach() {
		super.setUp();
	}

	@DisplayName("결과 검증")
	@Test
	void testValidateResult() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 2, 3);
			run("541", "132", "178", "123", "2");
			verify("1볼", "1스트라이크 2볼", "1스트라이크", "3스트라이크");
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
