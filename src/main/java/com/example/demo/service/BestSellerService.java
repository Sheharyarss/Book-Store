package com.example.demo.service;


import com.example.demo.dto.BestSellerDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.BestSeller;
import com.example.demo.repository.BestSellerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BestSellerService {

    @Autowired
    BestSellerRepo bestSellerRepo;
    @Autowired
    ModelMapper modelMapper;

    public BestSellerDto postBestSeller(BestSellerDto bestSellerDto) {

        BestSeller bestSeller=modelMapper.map(bestSellerDto , BestSeller.class);
        BestSeller bestSeller1=bestSellerRepo.save(bestSeller);
        BestSellerDto bestSellerDto1=modelMapper.map(bestSeller1 , BestSellerDto.class);
        return bestSellerDto1;
    }

    public List<BestSellerDto> getAllBestSeller() {
        List<BestSeller> bestSellerList=bestSellerRepo.findAll();
        return bestSellerList.stream().map(bestSeller -> modelMapper.map(
                bestSeller , BestSellerDto.class
        )).collect(Collectors.toList());
    }

    public BestSellerDto getBestSellerById(Long id) {
        Optional<BestSeller> bestSeller=bestSellerRepo.findById(id);
        if(bestSeller.isPresent()){
            BestSeller bestSeller1=bestSeller.get();
            BestSellerDto bestSellerDto=modelMapper.map(bestSeller1 , BestSellerDto.class);
            return bestSellerDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public BestSellerDto updateBestSellerById(Long id, BestSellerDto bestSellerDto) {

        Optional<BestSeller> bestSeller=bestSellerRepo.findById(id);
        if (bestSeller.isPresent()){
            BestSeller bestSeller1=bestSeller.get();
            bestSeller1.setSalesId(bestSellerDto.getSalesId());
            BestSeller bestSeller2=bestSellerRepo.save(bestSeller1);
            return modelMapper.map(bestSeller2 , BestSellerDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteBestSellerById(Long id) {
        Optional<BestSeller> bestSeller = bestSellerRepo.findById(id);
        if (bestSeller.isPresent()) {
            bestSellerRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }
}
