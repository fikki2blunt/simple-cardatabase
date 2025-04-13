package learn.spring_boot.hands_on.controller;

import learn.spring_boot.hands_on.domain.Car;
import learn.spring_boot.hands_on.domain.Owner;
import learn.spring_boot.hands_on.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    CarRepository carRepository;

   @RequestMapping("/cars")
    public Iterable<Car> getCar (){
        return carRepository.findAll();
    }
}
