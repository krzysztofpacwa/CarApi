package pl.pacwa.car_t3.service;

import pl.pacwa.car_t3.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getCarsAll();

    Optional<Car> getCarId(long id);

    List<Car> getCarColor(String color);

    boolean addCar(Car car);

    boolean updateAllCar(Car updateCar);

    boolean modyfyCars(long id, Car modyfiCars);

    boolean deleteCar(long id);

}
