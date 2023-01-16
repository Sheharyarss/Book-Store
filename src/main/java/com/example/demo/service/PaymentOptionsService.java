package com.example.demo.service;

import com.example.demo.dto.LanguageDto;
import com.example.demo.dto.PaymentOptionsDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.Language;
import com.example.demo.model.PaymentOptions;
import com.example.demo.repository.LanguageRepo;
import com.example.demo.repository.PaymentOptionsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentOptionsService {


    @Autowired
    PaymentOptionsRepo paymentOptionsRepo;
    @Autowired
    ModelMapper modelMapper;

    public PaymentOptionsDto postPaymentOptions(PaymentOptionsDto paymentOptionsDto) {

        PaymentOptions paymentOptions =modelMapper.map(paymentOptionsDto , PaymentOptions.class);
        PaymentOptions paymentOptions1=paymentOptionsRepo.save(paymentOptions);

        PaymentOptionsDto paymentOptionsDto1=modelMapper.map(paymentOptions1 , PaymentOptionsDto.class);
        return paymentOptionsDto1;
    }

    public List<PaymentOptionsDto> getAllPaymentOptions() {
        List<PaymentOptions> paymentOptionsList=paymentOptionsRepo.findAll();
        return paymentOptionsList.stream().map(paymentOptions -> modelMapper.map(
                paymentOptions , PaymentOptionsDto.class
        )).collect(Collectors.toList());
    }

    public PaymentOptionsDto getPaymentOptionsById(Long id) {
        Optional<PaymentOptions> paymentOptions=paymentOptionsRepo.findById(id);
        if(paymentOptions.isPresent()){
            PaymentOptions paymentOptions1=paymentOptions.get();
            PaymentOptionsDto paymentOptionsDto=modelMapper.map(paymentOptions1 , PaymentOptionsDto.class);
            return paymentOptionsDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public PaymentOptionsDto updatePaymentOptionsById(Long id, PaymentOptionsDto paymentOptionsDto) {
        Optional<PaymentOptions> paymentOptions =paymentOptionsRepo.findById(id);
        if (paymentOptions.isPresent()){
            PaymentOptions paymentOptions1=paymentOptions.get();
            paymentOptions1.setPaymentOptionName(paymentOptionsDto.getPaymentOptionName());
            PaymentOptions paymentOptions2=paymentOptionsRepo.save(paymentOptions1);
            return modelMapper.map(paymentOptions2 , PaymentOptionsDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deletePaymentOptionsById(Long id) {
        Optional<PaymentOptions> paymentOptions = paymentOptionsRepo.findById(id);
        if (paymentOptions.isPresent()) {
            paymentOptionsRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }

}
