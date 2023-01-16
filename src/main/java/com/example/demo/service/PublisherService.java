package com.example.demo.service;

import com.example.demo.dto.PaymentOptionsDto;
import com.example.demo.dto.PublisherDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.PaymentOptions;
import com.example.demo.model.Publisher;
import com.example.demo.repository.PaymentOptionsRepo;
import com.example.demo.repository.PublisherRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    @Autowired
    PublisherRepo publisherRepo;
    @Autowired
    ModelMapper modelMapper;

    public PublisherDto postPublisher(PublisherDto publisherDto) {

        Publisher publisher =modelMapper.map(publisherDto , Publisher.class);
        Publisher publisher1=publisherRepo.save(publisher);

        PublisherDto publisherDto1=modelMapper.map(publisher1 , PublisherDto.class);
        return publisherDto1;
    }

    public List<PublisherDto> getAllPublisher() {
        List<Publisher> publisherList=publisherRepo.findAll();
        return publisherList.stream().map(publisher -> modelMapper.map(
                publisher , PublisherDto.class
        )).collect(Collectors.toList());
    }

    public PublisherDto getPublisherById(Long id) {
        Optional<Publisher> publisher=publisherRepo.findById(id);
        if(publisher.isPresent()){
            Publisher publisher1=publisher.get();
            PublisherDto publisherDto=modelMapper.map(publisher1 , PublisherDto.class);
            return publisherDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public PublisherDto updatePublisherById(Long id, PublisherDto publisherDto) {
        Optional<Publisher> publisher =publisherRepo.findById(id);
        if (publisher.isPresent()){
            Publisher publisher1=publisher.get();
            publisher1.setPublisherName(publisherDto.getPublisherName());
            Publisher publisher2=publisherRepo.save(publisher1);
            return modelMapper.map(publisher2 , PublisherDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deletePublisherById(Long id) {
        Optional<Publisher> publisher = publisherRepo.findById(id);
        if (publisher.isPresent()) {
            publisherRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }
}
