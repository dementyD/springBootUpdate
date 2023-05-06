package spring.service;

import spring.model.Car;
import java.util.List;

public interface CarService {

    List<Car> findCars(String count, String sortBy);
}
