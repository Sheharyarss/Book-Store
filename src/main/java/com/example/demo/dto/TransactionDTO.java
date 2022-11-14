package com.example.demo.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class TransactionDTO {
    private Long id;
    @NotNull
    @Min(value = 0,message = "Invalid Transaction")
    private Double amount;
    @NotNull
    private UUID uniqueId;
    private String type;
    private LocalDateTime dateTime;


}
