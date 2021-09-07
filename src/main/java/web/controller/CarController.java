package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.CarService;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCar(HttpServletRequest request1, Model model2) {
        String count = request1.getParameter("count");
        carService = new CarService();
        if (count != null) {
            int number = Integer.parseInt(count);
            model2.addAttribute("carList", carService.getCars(number));
        } else {
            model2.addAttribute("carList", carService.getCars(5));
        }
        return "cars";
    }
}
