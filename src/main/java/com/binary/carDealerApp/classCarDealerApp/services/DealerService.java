package com.binary.carDealerApp.classCarDealerApp.services;

import com.binary.carDealerApp.classCarDealerApp.dto.DealerDto;
import com.binary.carDealerApp.classCarDealerApp.entities.Dealer;
import com.binary.carDealerApp.classCarDealerApp.repositories.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DealerService {

    List<Dealer> getAllDealers();
    Dealer getDealerById(Long id);
    Dealer createDealer(Dealer dealer);
    Dealer updateDealer(Long id, DealerDto dealerDto);
    void deleteDealer(Long id);
}

