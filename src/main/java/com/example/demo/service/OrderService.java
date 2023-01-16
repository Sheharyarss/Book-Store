package com.example.demo.service;


import com.example.demo.dto.DesignationDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.exceptions.DoesNotExist;
import com.example.demo.model.Designation;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepo;
import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;
    @Autowired
    ModelMapper modelMapper;

    public OrderDto postOrder(OrderDto orderDto) {
        Order order=modelMapper.map(orderDto , Order.class);
        Order order1=orderRepo.save(order);
        return modelMapper.map(order1 , OrderDto.class);
    }

    public List<OrderDto> getAllOrder() {
        List<Order> order=orderRepo.findAll();
        return order.stream().map(order1 -> modelMapper.map(
                order1 , OrderDto.class)).collect(Collectors.toList());
    }

    public OrderDto getOrderById(Long id) {
        Optional<Order> order=orderRepo.findById(id);
        if(order.isPresent()){
            Order order1=order.get();
            OrderDto orderDto=modelMapper.map(order1 , OrderDto.class);
            return orderDto;
        }else{
            throw new DoesNotExist("Nothing is present on this id");
        }
    }

    public OrderDto updateOrderById(Long id, OrderDto orderDto) {
        Optional<Order> order=orderRepo.findById(id);
        if (order.isPresent()){
            Order order1=order.get();
          order1.setBookId(orderDto.getBookId());
          order1.setCustomerId(orderDto.getCustomerId());
          order1.setAddressId(orderDto.getAddressId());
          order1.setPaymentOptions(orderDto.getPaymentOptionId());
          order1.setMethodId(orderDto.getMethodId());
            Order order2=orderRepo.save(order1);
            return modelMapper.map(order2 , OrderDto.class);
        }
        else throw new DoesNotExist("Not Present");
    }

    public void deleteOrderById(Long id) {
        Optional<Order> order = orderRepo.findById(id);
        if (order.isPresent()) {
            orderRepo.deleteById(id);
        }else{
            throw new DoesNotExist("Book Does Not Exist on id: " + id);
        }
    }
}

