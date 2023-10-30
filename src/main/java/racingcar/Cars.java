package racingcar;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> carNames) {

        List<Car> cars = carNames.stream()
                .map(name -> new Car(new CarName(name)))
                .toList();

        validateDuplication(cars);
        validateExist(cars);

        return new Cars(cars);
    }

    private static void validateExist(List<Car> cars) {
        if (cars.size() == 0) {
            throw new IllegalArgumentException("자동차가 존재하지 않습니다");
        }
    }

    private static void validateDuplication(List<Car> cars) {
        Set<Car> removeDuplicatedCars = Set.copyOf(cars);

        if (removeDuplicatedCars.size() != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다");
        }
    }


    public void goForward(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            cars.forEach(car -> {
                car.goForward();
                System.out.println(car.getStatusMessage());
            });
            System.out.println();
        }
    }

    public List<String> getWinningCarNames() {
        Car winnerCar = cars.stream().max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("우승 차가 존재하지 않습니다"));

        return cars.stream()
                .filter(car -> car.isEqualPosition(winnerCar))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
