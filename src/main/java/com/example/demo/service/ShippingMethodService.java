package com.example.demo.service;

import com.example.demo.dto.SalesDto;
import com.example.demo.dto.ShippingMethodDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.Sales;
import com.example.demo.model.ShippingMethod;
import com.example.demo.repository.SalesRepo;
import com.example.demo.repository.ShippingMethodRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShippingMethodService {


    @Autowired
    ShippingMethodRepo shippingMethodRepo;
    @Autowired
    ModelMapper modelMapper;

    public ShippingMethodDto postShippingMethod(ShippingMethodDto shippingMethodDto) {

        ShippingMethod shippingMethod =modelMapper.map(shippingMethodDto , ShippingMethod.class);
        ShippingMethod shippingMethod1=shippingMethodRepo.save(shippingMethod);

        ShippingMethodDto shippingMethodDto1=modelMapper.map(shippingMethod1, ShippingMethodDto.class);
        return shippingMethodDto1;
    }

    public List<ShippingMethodDto> getAllShippingMethod() {
        List<ShippingMethod> shippingMethodList=shippingMethodRepo.findAll();
        return shippingMethodList.stream().map(shippingMethod -> modelMapper.map(
                shippingMethod , ShippingMethodDto.class
        )).collect(Collectors.toList());
    }

    public ShippingMethodDto getShippingMethodById(Long id) {
        Optional<ShippingMethod> shippingMethod=shippingMethodRepo.findById(id);
        if(shippingMethod.isPresent()){
            ShippingMethod shippingMethod1 =shippingMethod.get();
            ShippingMethodDto shippingMethodDto=modelMapper.map(shippingMethod1 , ShippingMethodDto.class);
            return shippingMethodDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public ShippingMethodDto updateShippingMethodById(Long id, ShippingMethodDto shippingMethodDto) {
        Optional<ShippingMethod> shippingMethod =shippingMethodRepo.findById(id);
        if (shippingMethod.isPresent()){
            ShippingMethod shippingMethod1=shippingMethod.get();
            shippingMethod1.setMethodName(shippingMethodDto.getMethodName());
            shippingMethod1.setCost(shippingMethodDto.getCost());
            ShippingMethod shippingMethod2=shippingMethodRepo.save(shippingMethod1);
            return modelMapper.map(shippingMethod2 , ShippingMethodDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteShippingMethodById(Long id) {
        Optional<ShippingMethod> shippingMethod = shippingMethodRepo.findById(id);
        if (shippingMethod.isPresent()) {
            shippingMethodRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }

}
