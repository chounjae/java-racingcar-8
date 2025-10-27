package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public void move() {
        position += rollDice();
    }

    private int rollDice() {
        int rand = Randoms.pickNumberInRange(0,9);

        if(rand >= 4) {
            return (rand - 3);
        }

        return 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static Car of(String name) {
        return new Car(name);
    }
}
