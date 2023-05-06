package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.config.SortSetting;
import spring.service.CarService;

@Controller
public class CarsController {

    @Autowired
    private CarService carService;

    @Autowired
    private SortSetting sortSetting;

    @GetMapping("/cars")
    public String getByValue(@RequestParam(value = "count", required = false) String count,
                             @RequestParam(value = "sortBy", required = false) String sortBy,
                             Model model) {
        if (sortSetting.getSortOf().contains(sortBy)) {
            return "errorPage";
        }
        model.addAttribute("cars", carService.findCars(count, sortBy));
        return "cars";

    }
}

