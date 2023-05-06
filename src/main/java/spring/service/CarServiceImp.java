package spring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageRequest;
import spring.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.repositories.CarRepository;

import java.util.List;

@Service
@PropertySource("maxCar.properties")
@ConfigurationProperties
public class CarServiceImp implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Value("${maxCar}")
    private int maxCar;

    @Override
    public List<Car> findCars(String count, String sortBy) {
        List<Car> result;
        if (count == null & sortBy == null) {
            result = carRepository.findAll();
            return result;
        }
        if (sortBy == null) {
            int countInt = Integer.parseInt(count);
            result = carRepository.getCarLimit(countInt);
            return result;
        }
        int countInt = Integer.parseInt(count);
        Page<Car> resultPage = carRepository.findAll(PageRequest.of(0, countInt, Sort.by(sortBy)));
        return resultPage.getContent();
    }
}

