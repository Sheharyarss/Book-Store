package com.example.demo.dto;

import com.example.demo.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class InventoryDto {

    private Integer inventoryId;
    private Integer inStock;
    private String  status;
    private Book    bookId;
}
