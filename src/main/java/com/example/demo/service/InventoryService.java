package com.example.demo.service;

import com.example.demo.dto.GiftCardDto;
import com.example.demo.dto.InventoryDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.GiftCard;
import com.example.demo.model.Inventory;
import com.example.demo.repository.GiftCardRepo;
import com.example.demo.repository.InventoryRepo;
import io.swagger.models.auth.In;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    InventoryRepo inventoryRepo;
    @Autowired
    ModelMapper modelMapper;

    public InventoryDto postInventory(InventoryDto inventoryDto) {

        Inventory inventory=modelMapper.map(inventoryDto , Inventory.class);
        Inventory inventory1=inventoryRepo.save(inventory);

        InventoryDto inventoryDto1=modelMapper.map(inventory1 , InventoryDto.class);
        return inventoryDto1;
    }

    public List<InventoryDto> getAllInventory() {
        List<Inventory> inventoryList=inventoryRepo.findAll();
        return inventoryList.stream().map(inventory -> modelMapper.map(
                inventory , InventoryDto.class
        )).collect(Collectors.toList());
    }

    public InventoryDto getInventoryById(Long id) {
        Optional<Inventory> inventory=inventoryRepo.findById(id);
        if(inventory.isPresent()){
            Inventory inventory1=inventory.get();
            InventoryDto inventoryDto=modelMapper.map(inventory1 , InventoryDto.class);
            return inventoryDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public InventoryDto updateInventoryById(Long id, InventoryDto inventoryDto) {
        Optional<Inventory> inventory=inventoryRepo.findById(id);
        if (inventory.isPresent()){
            Inventory inventory1=inventory.get();
            inventory1.setInStock(inventoryDto.getInStock());
            inventory1.setStatus(inventoryDto.getStatus());
            inventory1.setBookId(inventoryDto.getBookId());
            Inventory inventory2=inventoryRepo.save(inventory1);
            return modelMapper.map(inventory2 , InventoryDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteInventoryById(Long id) {
        Optional<Inventory> inventory = inventoryRepo.findById(id);
        if (inventory.isPresent()) {
            inventoryRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }

}
