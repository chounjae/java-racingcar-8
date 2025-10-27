package racingcar;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingController {
    private RacingCarHandler carsHandler;

    public void run() {
        setUpCars();

        racing();

        showResult();
    }

    public void setUpCars() {
        View.inputCarNameView();

        List<String> racingCarList = Arrays.asList(readLine().split(","));

        for (String name : racingCarList) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        carsHandler = RacingCarHandler.from(racingCarList);
    }

    public void racing() {
        View.inputTryCountView();
        try {
            int count = Integer.parseInt(readLine());
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }

            View.moveStartView();
            for (int i = 0; i < count; i++) {
                carsHandler.moveAll();
                carsHandler.showPositionAll();
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수에 숫자를 입력해주세요.");
        }
    }

    public void showResult() {
        View.resultView(carsHandler.getWinnersName());
    }
}
