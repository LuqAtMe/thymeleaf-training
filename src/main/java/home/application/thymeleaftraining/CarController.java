package home.application.thymeleaftraining;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {

    @GetMapping("/car")
    public String hello(Model model) {
        Car car1 = new Car("BMW", "i8");
        Car car2 = new Car("Mazda", "6");
        Car car3 = new Car("Fiat", "126p");
        Car car4 = new Car("Polonez", "Caro");
        List<Car> carList = Arrays.asList(car1, car2, car3, car4);
        model.addAttribute("cars", carList);
        return "car";
    }

}
