package com.binary.carDealerApp.classCarDealerApp.controllers;

import com.binary.carDealerApp.classCarDealerApp.dto.DealerDto;
import com.binary.carDealerApp.classCarDealerApp.entities.Dealer;
import com.binary.carDealerApp.classCarDealerApp.services.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dealers")
public class DealerController {

    @Autowired
    private DealerService dealerService;

    @GetMapping("/all")
    public ResponseEntity<List<Dealer>> getAllDealers() {
        List<Dealer> dealers = dealerService.getAllDealers();
        return new ResponseEntity<>(dealers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dealer> getDealerById(@PathVariable Long id) {
        Dealer dealer = dealerService.getDealerById(id);
        return new ResponseEntity<>(dealer, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Dealer> createDealer(@RequestBody DealerDto dealerDto) {
        Dealer dealer = new Dealer();
        dealer.setDealerName(dealerDto.getName());
        return new ResponseEntity<>(dealerService.createDealer(dealer), HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Dealer> updateDealer(@RequestBody DealerDto dealerDto, @PathVariable Long id) {
        return new ResponseEntity<>(dealerService.updateDealer(id, dealerDto), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDealer(@PathVariable Long id) {
        dealerService.deleteDealer(id);
        return new ResponseEntity<>("Dealer deleted with ID "+id, HttpStatus.OK);
    }
}
