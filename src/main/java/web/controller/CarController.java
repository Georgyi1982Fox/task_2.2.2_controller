package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarService;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public String localSwitcher(ModelMap modelMap, @RequestParam(value = "locale", defaultValue = "List") String locale){
        List<Car> allCars = carService.getCars();
        modelMap.addAttribute("carList", allCars);

        modelMap.addAttribute("locale",locale);
        if("ru".equals(locale)){
            modelMap.addAttribute("local", "Машины");
        } else if("en".equals(locale)){
            modelMap.addAttribute("local", "Cars");
        }else {
            modelMap.addAttribute("local", "List of Cars");
        }
        return "cars";
    }
}












