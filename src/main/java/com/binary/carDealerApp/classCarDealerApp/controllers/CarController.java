package com.binary.carDealerApp.classCarDealerApp.controllers;

import com.binary.carDealerApp.classCarDealerApp.entities.Car;
import com.binary.carDealerApp.classCarDealerApp.entities.Dealer;
import com.binary.carDealerApp.classCarDealerApp.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/api/cars")
    public class CarController {

    @Autowired
    private CarService carService;

        @GetMapping("/home")
        public String home() {
            return "Welcome to Car Dealer!";
        }

        @GetMapping("/all")
        public ResponseEntity<List<Car>> getAllCars() {
            List<Car> cars = carService.getAllCars();

            return new ResponseEntity<>(cars, HttpStatus.OK);
        }


}
