package recingcar.view;

import recingcar.controller.Movement;
import recingcar.controller.Winner;
import recingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void showRacingResult(List<Car> cars) {
        cars.stream().map(car -> car.getName() + " : " + Movement.trackingMovement(car, "-"))
                .forEach(System.out::println);
        System.out.println();
    }

    public static void showWinnerName(List<Car> cars) {
        Winner win = new Winner();
        win.decideWinner(cars);

        System.out.println(
                win.nameOfWinner.stream().map(Car::getName).collect(Collectors.joining(", "))
                + "가 최종 우승했습니다.");
    }

}
