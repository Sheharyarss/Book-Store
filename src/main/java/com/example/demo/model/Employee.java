package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empID;
    private String empName;
    @ManyToOne
    private Designation designationId;


}
