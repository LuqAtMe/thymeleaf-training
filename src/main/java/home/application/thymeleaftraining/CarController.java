package home.application.thymeleaftraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping ("/cars")
    public String showCars(Model model){
        model.addAttribute("allCars", carService.getCarList());
        model.addAttribute("car", new Car());
        return "cars";
    }
    @PostMapping ("/addCar")
    public String addCar(@ModelAttribute Car car){
        carService.addCar(car);
        return "redirect:/cars";
    }

    @PostMapping ("/deleteCar")
    public String deleteCar(@RequestParam long id){
        carService.deleteCar(carService.getCarById(id));
        return "redirect:/cars";
    }

    @GetMapping ("/modifyCar")
    public String modifyCar(){
        
        return "updateCar";
    }



}
