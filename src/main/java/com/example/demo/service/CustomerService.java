package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.Category;
import com.example.demo.model.Customer;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {


    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ModelMapper  modelMapper;

    public CustomerDto postCustomer(CustomerDto customerDto) {

        Customer customer=modelMapper.map(customerDto , Customer.class);
        Customer customer1=customerRepo.save(customer);

        CustomerDto customerDto1=modelMapper.map(customer1 , CustomerDto.class);
        return customerDto1;
    }

    public List<CustomerDto> getAllCustomer() {
        List<Customer> customerList=customerRepo.findAll();
        return customerList.stream().map(customer -> modelMapper.map(
                customer , CustomerDto.class
        )).collect(Collectors.toList());
    }

    public CustomerDto getCustomerById(Long id) {
        Optional<Customer> customer=customerRepo.findById(id);
        if(customer.isPresent()){
            Customer customer1=customer.get();
            CustomerDto customerDto=modelMapper.map(customer1 , CustomerDto.class);
            return customerDto;
        }
        else throw new DoesNotExist("Not present");
    }

    public CustomerDto updateCustomerById(Long id, CustomerDto customerDto) {
        Optional<Customer> customer=customerRepo.findById(id);
        if (customer.isPresent()){
            Customer customer1=customer.get();
            customer1.setFirstName(customerDto.getFirstName());
            customer1.setLastName(customerDto.getLastName());
            customer1.setEmail(customerDto.getEmail());
            customer1.setAddress(customerDto.getAddress());
            Customer customer2=customerRepo.save(customer1);
            return modelMapper.map(customer2 , CustomerDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteCustomerById(Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            customerRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }
}
