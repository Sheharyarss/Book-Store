package com.example.demo.service;

import com.example.demo.dto.PublisherDto;
import com.example.demo.dto.SalesDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.Publisher;
import com.example.demo.model.Sales;
import com.example.demo.repository.PublisherRepo;
import com.example.demo.repository.SalesRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalesService {

    @Autowired
    SalesRepo salesRepo;
    @Autowired
    ModelMapper modelMapper;

    public SalesDto postSales(SalesDto salesDto) {

        Sales sales =modelMapper.map(salesDto , Sales.class);
        Sales sales1=salesRepo.save(sales);

        SalesDto salesDto1=modelMapper.map(sales1 , SalesDto.class);
        return salesDto1;
    }

    public List<SalesDto> getAllSales() {
        List<Sales> salesList=salesRepo.findAll();
        return salesList.stream().map(sales -> modelMapper.map(
                sales , SalesDto.class
        )).collect(Collectors.toList());
    }

    public SalesDto getSalesById(Long id) {
        Optional<Sales> sales=salesRepo.findById(id);
        if(sales.isPresent()){
            Sales sales1=sales.get();
            SalesDto salesDto=modelMapper.map(sales1 , SalesDto.class);
            return salesDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public SalesDto updateSalesById(Long id, SalesDto salesDto) {
        Optional<Sales> sales =salesRepo.findById(id);
        if (sales.isPresent()){
            Sales sales1=sales.get();
            sales1.setNoOfSale(salesDto.getNoOfSale());
            sales1.setProfit(salesDto.getProfit());
            sales1.setTotalAmount(salesDto.getTotalAmount());
            sales1.setBookId(salesDto.getBookId());
            Sales sales2=salesRepo.save(sales1);
            return modelMapper.map(sales2 , SalesDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteSalesById(Long id) {
        Optional<Sales> sales = salesRepo.findById(id);
        if (sales.isPresent()) {
            salesRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }
}
