package com.binary.carDealerApp.classCarDealerApp.services;

import com.binary.carDealerApp.classCarDealerApp.dto.DealerDto;
import com.binary.carDealerApp.classCarDealerApp.entities.Dealer;
import com.binary.carDealerApp.classCarDealerApp.repositories.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealerServiceImpl implements DealerService{

    @Autowired
    private DealerRepository dealerRepository;

    @Override
    public List<Dealer> getAllDealers() {
        return dealerRepository.findAll();
    }

    @Override
    public Dealer getDealerById(Long id) {
      Optional<Dealer> optionalDealer = dealerRepository.findById(id);

      if (optionalDealer.isPresent()){
          return optionalDealer.get();
      }
        return null;
    }

    @Override
    public Dealer createDealer(Dealer dealer) {
        return dealerRepository.save(dealer);
    }

    @Override
    public Dealer updateDealer(Long id, DealerDto dealerDto) {
        Optional<Dealer> optionalDealer = dealerRepository.findById(id);
        if (optionalDealer.isPresent()) {
            Dealer tobeUpdatedDealer = optionalDealer.get();
            if (dealerDto.getName()!=null) {
                tobeUpdatedDealer.setDealerName(dealerDto.getName());
                return dealerRepository.save(tobeUpdatedDealer);
            }
        }
        return null;
    }

    @Override
    public void deleteDealer(Long id) {

        dealerRepository.deleteById(id);

    }
}
