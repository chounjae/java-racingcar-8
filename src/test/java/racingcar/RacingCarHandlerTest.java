package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarHandlerTest {
    private RacingCarHandler handler;

    @BeforeEach
    void 자동차_핸들러_생성() {
        handler = RacingCarHandler.from(Arrays.asList("pobi", "woni", "jun"));
    }

    @Test
    void 자동차_리스트_확인() {
        assertThat(handler.carList).hasSize(3);
        assertThat(handler.carList.getFirst().getName()).isEqualTo("pobi");
    }
}
