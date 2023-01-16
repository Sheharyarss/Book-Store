package com.example.demo.service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.GiftCardDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.Customer;
import com.example.demo.model.GiftCard;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.GiftCardRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GiftCardService {

    @Autowired
    GiftCardRepo giftCardRepo;
    @Autowired
    ModelMapper modelMapper;

    public GiftCardDto postGiftCard(GiftCardDto giftCardDto) {

        GiftCard giftCard=modelMapper.map(giftCardDto , GiftCard.class);
        GiftCard giftCard1=giftCardRepo.save(giftCard);

        GiftCardDto giftCardDto1=modelMapper.map(giftCard1 , GiftCardDto.class);
        return giftCardDto1;
    }

    public List<GiftCardDto> getAllGiftCard() {
        List<GiftCard> giftCardList=giftCardRepo.findAll();
        return giftCardList.stream().map(giftCard -> modelMapper.map(
                giftCard , GiftCardDto.class
        )).collect(Collectors.toList());
    }

    public GiftCardDto getGiftCardById(Long id) {
        Optional<GiftCard> giftCard=giftCardRepo.findById(id);
        if(giftCard.isPresent()){
            GiftCard giftCard1=giftCard.get();
            GiftCardDto giftCardDto=modelMapper.map(giftCard1 , GiftCardDto.class);
            return giftCardDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public GiftCardDto updateGiftCardById(Long id, GiftCardDto giftCardDto) {
        Optional<GiftCard> giftCard=giftCardRepo.findById(id);
        if (giftCard.isPresent()){
            GiftCard giftCard1=giftCard.get();
            giftCard1.setGift(giftCardDto.getGift());
            GiftCard giftCard2=giftCardRepo.save(giftCard1);
            return modelMapper.map(giftCard2 , GiftCardDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteGiftCardById(Long id) {
        Optional<GiftCard> giftCard = giftCardRepo.findById(id);
        if (giftCard.isPresent()) {
            giftCardRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }
}
