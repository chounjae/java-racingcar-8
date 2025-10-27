package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final int STOP = 3;
    private static final int MOVING_RANDOM1 = 4;
    private static final int MOVING_RANDOM2 = 9;

    @Test
    void 자동차_생성() {
        Car car = Car.of("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
