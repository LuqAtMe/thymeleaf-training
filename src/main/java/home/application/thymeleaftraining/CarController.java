package home.application.thymeleaftraining;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    @GetMapping ("/car")
    public String hello(Model model){
        Car car = new Car ("BMW", "i8");
        model.addAttribute("car", car);
        return "car";
    }

}
