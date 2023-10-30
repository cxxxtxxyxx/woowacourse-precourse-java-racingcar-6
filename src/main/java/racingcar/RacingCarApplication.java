package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RacingCarApplication {

    public RacingCarApplication() {
    }

    public void run() {

        // 중복 체크, 이름에 공백 체크, 5자 이하 체크, 시작 및 끝이 ,로 끝나면 체크 등
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        List<Car> cars = new ArrayList<>(Arrays.stream(inputCarNames.split(","))
                .map(Car::new)
                .toList());

        System.out.println("시도할 회수는 몇회인가요?");
        int attemptCount = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");

        for (int i = 0; i < attemptCount; i++) {
            cars.forEach(car -> {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.goForward();
                }

                System.out.println(car.getStatusMessage());
            });
            System.out.println();
        }
    }
}
