package racingcar;

import java.util.List;

public class View {
    public static void inputCarNameView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void inputTryCountView() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void moveStartView() {
        System.out.println("실행 결과");
    }

    public static void moveView(String carName, int position) {
        System.out.println(carName + " : " + "-".repeat(position));
    }

    public static void endMove() {
        System.out.println();
    }

    public static void resultView(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
