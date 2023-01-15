package com.example.demo.service;


import com.example.demo.dto.AuthorDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {


    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    ModelMapper modelMapper;

    public AuthorDto postAuthor(AuthorDto authorDto) {
        Author author=modelMapper.map(authorDto , Author.class);
        Author author1=authorRepo.save(author);
        AuthorDto authorDto1=modelMapper.map(author1 , AuthorDto.class);
        return authorDto1;
    }

    public List<AuthorDto> getAllAuthor() {
        List<Author> authorList=authorRepo.findAll();
        return authorList.stream().map(author -> modelMapper.map(
                author , AuthorDto.class
        )).collect(Collectors.toList());

    }

    public AuthorDto getAuthorById(Long id) {
        Optional<Author> author=authorRepo.findById(id);
        if(author.isPresent()){
            Author author1=author.get();
            AuthorDto authorDto=modelMapper.map(author1 , AuthorDto.class);
            return authorDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public AuthorDto updateAuthorById(Long id, AuthorDto authorDto) {
        Optional<Author> author=authorRepo.findById(id);
        if (author.isPresent()){
            Author author1=author.get();
            author1.setAuthorName(authorDto.getAuthorName());
            Author author2=authorRepo.save(author1);
            return modelMapper.map(author2 , AuthorDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteAuthorById(Long id) {
        Optional<Author> author = authorRepo.findById(id);
        if (author.isPresent()) {
            authorRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }

    }
}
