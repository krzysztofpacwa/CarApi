package pl.pacwa.car_t3.service;

import org.springframework.stereotype.Service;
import pl.pacwa.car_t3.model.Car;
import pl.pacwa.car_t3.model.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarLogic implements CarService {

    private List<Car> carList;

    public CarLogic() {
        carList = new ArrayList<>();
        carList.add(new Car(1L, "Mazda", "323F", Color.BLACK));
        carList.add(new Car(2L, "Ford", "Fiesta", Color.GOLDEN));
        carList.add(new Car(3L, "Ford", "Mustang", Color.BLACK));
        carList.add(new Car(4L, "Skoda", "Superb", Color.WHITE));
        carList.add(new Car(5L, "Alfa", "Stevio", Color.RED));
        carList.add(new Car(6L, "Nisan", "Quskai", Color.WHITE));
        carList.add(new Car(7L, "Opel", "Corsa", Color.GRIN));


    }

    @Override
    public List<Car> getCarsAll() {
        return carList;
    }

    @Override
    public Optional<Car> getCarId(long id) {
        return carList.stream().filter(car -> car.getId() == id)
                .findFirst();
    }

    @Override
    public List<Car> getCarColor(String color) {
        return carList.stream().filter(car -> color.equalsIgnoreCase(car.getColor().name()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean addCar(Car car) {
        carList.add(car);
        return true;
    }

    @Override
    public boolean updateAllCar(Car updateCar) {
        Optional<Car> update = carList.stream().filter(car -> car.getId() == updateCar.getId())
                .findFirst();
        if (!update.isPresent()) {
            return false;
        }
        carList.remove(update.get());
        carList.add(updateCar);
        return true;
    }

    @Override
    public boolean modyfyCars(long id, Car modyfiCars) {
        Optional<Car> modyfy = carList.stream().filter(car -> car.getId() == id)
                .findFirst();
        if (!modyfy.isPresent()) {
            return false;
        }
        modyfy.get().setMark(modyfiCars.getMark());
        modyfy.get().setModel(modyfiCars.getModel());
        modyfy.get().setColor(modyfiCars.getColor());
        return true;
    }

    @Override
    public boolean deleteCar(long id) {
        Optional<Car> delete = carList.stream().filter(car -> car.getId() == id)
                .findFirst();
        if (!delete.isPresent()) {
            return false;
        }
        carList.remove(delete.get());
        return true;
    }
}
