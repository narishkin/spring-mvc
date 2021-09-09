package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final List<Car> list;

    {
        Car car1 = new Car("Audi", "100", 80);
        Car car2 = new Car("Mercedes", "W202", 95);
        Car car3 = new Car("Porsche", "911", 120);
        Car car4 = new Car("BMW", "535", 110);
        Car car5 = new Car("VW", "Golf", 78);
        list = new ArrayList<>(Arrays.asList(car1, car2, car3, car4, car5));
    }

    public List<Car> getCars(Integer number) {
        return (number == null) ? list : list.stream().limit(number).limit(5).collect(Collectors.toList());
    }
}
