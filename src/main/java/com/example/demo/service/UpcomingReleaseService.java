package com.example.demo.service;

import com.example.demo.dto.ShippingMethodDto;
import com.example.demo.dto.UpcomingReleaseDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.ShippingMethod;
import com.example.demo.model.UpcomingRelease;
import com.example.demo.repository.ShippingMethodRepo;
import com.example.demo.repository.UpcomingReleaseRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UpcomingReleaseService {


    @Autowired
    UpcomingReleaseRepo upcomingReleaseRepo;
    @Autowired
    ModelMapper modelMapper;

    public UpcomingReleaseDto postUpcomingRelease(UpcomingReleaseDto upcomingReleaseDto) {

        UpcomingRelease upcomingRelease =modelMapper.map(upcomingReleaseDto , UpcomingRelease.class);
       UpcomingRelease upcomingRelease1=upcomingReleaseRepo.save(upcomingRelease);

        UpcomingReleaseDto upcomingReleaseDto1=modelMapper.map(upcomingRelease1, UpcomingReleaseDto.class);
        return upcomingReleaseDto1;
    }

    public List<UpcomingReleaseDto> getAllUpcomingRelease() {
        List<UpcomingRelease> upcomingReleaseList=upcomingReleaseRepo.findAll();
        return upcomingReleaseList.stream().map(upcomingRelease -> modelMapper.map(
                upcomingRelease , UpcomingReleaseDto.class
        )).collect(Collectors.toList());
    }

    public UpcomingReleaseDto getUpcomingReleaseById(Long id) {
        Optional<UpcomingRelease> upcomingRelease=upcomingReleaseRepo.findById(id);
        if(upcomingRelease.isPresent()){
            UpcomingRelease upcomingRelease1 =upcomingRelease.get();
            UpcomingReleaseDto upcomingReleaseDto=modelMapper.map(upcomingRelease1 , UpcomingReleaseDto.class);
            return upcomingReleaseDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public UpcomingReleaseDto updateUpcomingReleaseById(Long id, UpcomingReleaseDto upcomingReleaseDto) {
        Optional<UpcomingRelease> upcomingRelease =upcomingReleaseRepo.findById(id);
        if (upcomingRelease.isPresent()){
            UpcomingRelease upcomingRelease1=upcomingRelease.get();
            upcomingRelease1.setBookId(upcomingReleaseDto.getBookId());
            UpcomingRelease upcomingRelease2=upcomingReleaseRepo.save(upcomingRelease1);
            return modelMapper.map(upcomingRelease2 , UpcomingReleaseDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteUpcomingReleaseById(Long id) {
        Optional<UpcomingRelease> upcomingRelease = upcomingReleaseRepo.findById(id);
        if (upcomingRelease.isPresent()) {
            upcomingReleaseRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }


}
