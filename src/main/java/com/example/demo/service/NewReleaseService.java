package com.example.demo.service;

import com.example.demo.dto.LanguageDto;
import com.example.demo.dto.NewReleaseDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.Language;
import com.example.demo.model.NewRelease;
import com.example.demo.repository.LanguageRepo;
import com.example.demo.repository.NewReleaseRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewReleaseService {

    @Autowired
    NewReleaseRepo newReleaseRepo;
    @Autowired
    ModelMapper modelMapper;

    public NewReleaseDto postNewRelease(NewReleaseDto newReleaseDto) {

        NewRelease newRelease =modelMapper.map(newReleaseDto , NewRelease.class);
        NewRelease newRelease1=newReleaseRepo.save(newRelease);

        NewReleaseDto newReleaseDto1=modelMapper.map(newRelease1 , NewReleaseDto.class);
        return newReleaseDto1;
    }

    public List<NewReleaseDto> getAllNewRelease() {
        List<NewRelease> newReleaseList=newReleaseRepo.findAll();
        return newReleaseList.stream().map(newRelease -> modelMapper.map(
               newRelease , NewReleaseDto.class
        )).collect(Collectors.toList());
    }

    public NewReleaseDto getNewReleaseById(Long id) {
        Optional<NewRelease> newRelease=newReleaseRepo.findById(id);
        if(newRelease.isPresent()){
            NewRelease newRelease1=newRelease.get();
            NewReleaseDto newReleaseDto=modelMapper.map(newRelease1 , NewReleaseDto.class);
            return newReleaseDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public NewReleaseDto updateNewReleaseById(Long id, NewReleaseDto newReleaseDto) {
        Optional<NewRelease> newRelease=newReleaseRepo.findById(id);
        if (newRelease.isPresent()){
            NewRelease newRelease1=newRelease.get();
            newRelease1.setBookId(newReleaseDto.getBookId());
            NewRelease newRelease2=newReleaseRepo.save(newRelease1);
            return modelMapper.map(newRelease2 , NewReleaseDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteNewReleaseById(Long id) {
        Optional<NewRelease> newRelease = newReleaseRepo.findById(id);
        if (newRelease.isPresent()) {
            newReleaseRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }

}
