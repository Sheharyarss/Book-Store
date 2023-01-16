package com.example.demo.service;

import com.example.demo.dto.InventoryDto;
import com.example.demo.dto.LanguageDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.Inventory;
import com.example.demo.model.Language;
import com.example.demo.repository.InventoryRepo;
import com.example.demo.repository.LanguageRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LanguageService {


    @Autowired
    LanguageRepo languageRepo;
    @Autowired
    ModelMapper modelMapper;

    public LanguageDto postLanguage(LanguageDto languageDto) {

        Language language =modelMapper.map(languageDto , Language.class);
        Language language1=languageRepo.save(language);

        LanguageDto languageDto1=modelMapper.map(language1 , LanguageDto.class);
        return languageDto1;
    }

    public List<LanguageDto> getAllLanguage() {
        List<Language> languageList=languageRepo.findAll();
        return languageList.stream().map(language -> modelMapper.map(
                language , LanguageDto.class
        )).collect(Collectors.toList());
    }

    public LanguageDto getLanguageById(Long id) {
        Optional<Language> language=languageRepo.findById(id);
        if(language.isPresent()){
            Language language1=language.get();
            LanguageDto languageDto=modelMapper.map(language1 , LanguageDto.class);
            return languageDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public LanguageDto updateLanguageById(Long id, LanguageDto languageDto) {
        Optional<Language> language=languageRepo.findById(id);
        if (language.isPresent()){
            Language language1=language.get();
            language1.setLanguageCode(languageDto.getLanguageCode());
            language1.setLanguageName(languageDto.getLanguageName());
            Language language2=languageRepo.save(language1);
            return modelMapper.map(language2 , LanguageDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteLanguageById(Long id) {
        Optional<Language> language = languageRepo.findById(id);
        if (language.isPresent()) {
            languageRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }

}
