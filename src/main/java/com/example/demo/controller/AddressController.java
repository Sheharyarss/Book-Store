package com.example.demo.controller;


import com.example.demo.dto.AddressDto;
import com.example.demo.dto.BookDto;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {


    @Autowired
    private AddressService addressService;

    @PostMapping("/address")
    public ResponseEntity<AddressDto> postAddress(@RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(addressService.postAddress(addressDto));
    }

    @GetMapping("/address")
    public ResponseEntity<List<AddressDto>> getAllAddress(){
        return  ResponseEntity.ok(addressService.getAllAddress());
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @PutMapping("/address/{id}")
    public ResponseEntity<AddressDto> updateAddressById(@PathVariable Long id , @RequestBody AddressDto addressDto){
        return ResponseEntity.ok(addressService.updateAddressById(id , addressDto));
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<Void> deleteAddressById(@PathVariable Long id) {

        addressService.deleteAddressById(id);
        return ResponseEntity.ok().build();

    }

}
