package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    public CarService() {
    }

    public List<Car> getCars() {
        List<Car> listCars = new ArrayList<>();
        listCars.add(new Car("BMW", 544, 100000));
        listCars.add(new Car("Mercedes", 767, 1500000));
        listCars.add((new Car("Audi", 598, 1700000)));
        return listCars;
    }
}
