package home.application.thymeleaftraining;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<Car> carList;

    public CarService() {
        carList = new ArrayList<>();
        carList.add(new Car(1L, "BMW", "M6"));
        carList.add(new Car(2L, "Fiat", "126p"));
        carList.add(new Car(3L, "Polonez", "Caro"));
        carList.add(new Car(4L, "Mazda", "6"));
        carList.add(new Car(5L, "Porsche", "911"));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public Car getCarById(long id) {
        Car selectedCar = carList.stream().filter(car -> car.getId() == id).findFirst().get();
        return selectedCar;
    }

    public void deleteCar(Car car){
        Car carToDelete = getCarById(car.getId());
        carList.remove(carToDelete);

    }

}
