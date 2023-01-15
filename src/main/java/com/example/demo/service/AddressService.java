package com.example.demo.service;


import com.example.demo.dto.AddressDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.Address;
import com.example.demo.model.Book;
import com.example.demo.repository.AddressRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {


    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    ModelMapper modelMapper;

    public AddressDto postAddress(AddressDto addressDto) {

        Address address=modelMapper.map(addressDto , Address.class);
        Address address1=addressRepo.save(address);
        AddressDto addressDto1=modelMapper.map(address1 , AddressDto.class);
        return addressDto1;
    }

    public List<AddressDto> getAllAddress() {
            List<Address> addressList=addressRepo.findAll();
           return addressList.stream().map(address -> modelMapper.map(
                   address , AddressDto.class
           )).collect(Collectors.toList());
    }

    public AddressDto getAddressById(Long id) {
        Optional<Address> address=addressRepo.findById(id);
        if(address.isPresent()){
            Address address1=address.get();
            AddressDto addressDto=modelMapper.map(address1 , AddressDto.class);
            return addressDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public AddressDto updateAddressById(Long id, AddressDto addressDto) {
        Optional<Address> address=addressRepo.findById(id);
        if (address.isPresent()){
            Address address1=address.get();
            address1.setAddress(addressDto.getAddress());
            address1.setCity(addressDto.getCity());
            Address address2=addressRepo.save(address1);
            return modelMapper.map(address2 , AddressDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteAddressById(Long id) {
        Optional<Address> address = addressRepo.findById(id);
        if (address.isPresent()) {
            addressRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }

    }
}
