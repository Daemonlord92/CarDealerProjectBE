package com.binary.carDealerApp.classCarDealerApp.controllers;

import com.binary.carDealerApp.classCarDealerApp.entities.Car;
import com.binary.carDealerApp.classCarDealerApp.entities.Dealer;
import com.binary.carDealerApp.classCarDealerApp.services.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/cars")
    public class CarController {

    private static final Logger log = LoggerFactory.getLogger(CarController.class);
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

    @PostMapping("/")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car returnCar = carService.createCar(car);
        return new ResponseEntity<>(returnCar, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        log.info(car.toString());
        Car updatedCar = carService.updateCar(car, id);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }
}
