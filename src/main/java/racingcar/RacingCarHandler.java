package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarHandler {
    List<Car> carList = new ArrayList<>();

    private RacingCarHandler(List<String> cars) {
        for(String carName : cars) {
            carList.add(Car.of(carName));
        }
    }

    public void moveAll() {
        for(Car car : carList) {
            car.move();
        }
    }

    public void showPositionAll() {
        for(Car car : carList) {
            View.moveView(car.getName(), car.getPosition());
        }

        View.endMove();
    }

    public List<String> getWinnersName() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public static RacingCarHandler from(List<String> cars) {
        return new RacingCarHandler(cars);
    }
}
