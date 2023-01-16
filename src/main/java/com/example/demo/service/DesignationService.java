package com.example.demo.service;


import com.example.demo.dto.DesignationDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.Designation;
import com.example.demo.repository.DesignationRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DesignationService {
    @Autowired
    DesignationRepo designationRepo;
    @Autowired
    ModelMapper     modelMapper;

    public DesignationDto postDesignation(DesignationDto designationDto) {

        Designation designation=modelMapper.map(designationDto , Designation.class);
        Designation designation1=designationRepo.save(designation);

        DesignationDto designationDto1=modelMapper.map(designation1 , DesignationDto.class);
        return designationDto1;
    }

    public List<DesignationDto> getAllDesignation() {
        List<Designation> designationList=designationRepo.findAll();
        return designationList.stream().map(designation -> modelMapper.map(
                designation , DesignationDto.class
        )).collect(Collectors.toList());
    }

    public DesignationDto getDesignationById(Long id) {
        Optional<Designation> designation=designationRepo.findById(id);
        if(designation.isPresent()){
            Designation designation1=designation.get();
            DesignationDto designationDto=modelMapper.map(designation1 , DesignationDto.class);
            return designationDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public DesignationDto updateDesignationById(Long id, DesignationDto designationDto) {
        Optional<Designation> designation=designationRepo.findById(id);
        if (designation.isPresent()){
            Designation designation1=designation.get();
            designation1.setDesignationName(designationDto.getDesignationName());
            designation1.setSalary(designationDto.getSalary());
            Designation designation2=designationRepo.save(designation1);
            return modelMapper.map(designation2 , DesignationDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteDesignationById(Long id) {
        Optional<Designation> designation = designationRepo.findById(id);
        if (designation.isPresent()) {
            designationRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }
}
