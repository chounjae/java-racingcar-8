package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import camp.nextstep.edu.missionutils.Console;

class RacingControllerTest {

    private final InputStream originalIn = System.in;

    @AfterEach
    void restoreSystemIn() {
        System.setIn(originalIn); // 1. System.in을 원래대로 복원
        Console.close();        // 2. Console의 static Scanner를 닫아서 리셋
    }

    private void simulateInput(String input) {
        ByteArrayInputStream testIn = new ByteArrayInputStream((input + "\n").getBytes());
        System.setIn(testIn);
    }

    @Test
    void 차_이름_글자수_제한_예외() {
        String invalidInput = "pobi,woni,longname";
        simulateInput(invalidInput);

        RacingController controller = new RacingController();

        assertThrows(
                IllegalArgumentException.class,
                controller::setUpCars
        );
    }

    @Test
    void 시도횟수_음수_예외() {
        String invalidInput = "-1";
        simulateInput(invalidInput);

        RacingController controller = new RacingController();

        assertThrows(
                IllegalArgumentException.class,
                controller::racing
        );
    }

    @Test
    void 시도횟수_문자_예외() {
        String invalidInput = "not_number";
        simulateInput(invalidInput);

        RacingController controller = new RacingController();

        assertThrows(
                IllegalArgumentException.class,
                controller::racing
        );
    }
}
