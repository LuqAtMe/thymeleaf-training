package home.application.thymeleaftraining;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private List<Car> carList;

    public CarController() {
        Car car1 = new Car("BMW", "i8");
        Car car2 = new Car("Mazda", "6");
        Car car3 = new Car("Fiat", "126p");
        Car car4 = new Car("Polonez", "Caro");
        carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
    }

    @GetMapping("/car")
    public String getCar(Model model) {
        model.addAttribute("cars", carList);
        model.addAttribute("newCar", new Car());
        return "car";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        carList.add(car);
        return "redirect:/car";
    }

}
