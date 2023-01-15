package com.example.demo.dto;

import com.example.demo.model.Designation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmployeeDto {

    private Integer     empID;
    private String      empName;
    private Designation designationId;
}
