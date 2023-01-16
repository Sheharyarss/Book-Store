package com.example.demo.controller;


import com.example.demo.dto.OrderDto;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderContoller {
    @Autowired
    OrderService orderService;



    @PostMapping("/order")
    public ResponseEntity<OrderDto> postOrder(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(orderService.postOrder(orderDto));
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderDto>> getAllOrder(){
        return  ResponseEntity.ok(orderService.getAllOrder());
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("/order/{id}")
    public  ResponseEntity<OrderDto> updateOrderById(@PathVariable Long id , @RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderService.updateOrderById(id,orderDto));
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {

        orderService.deleteOrderById(id);
        return ResponseEntity.ok().build();

    }
}
