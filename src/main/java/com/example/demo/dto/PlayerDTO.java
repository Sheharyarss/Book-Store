package com.example.demo.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PlayerDTO {


    private Long id;
    @Size(min=3,message = "Firstname must be of minimum 3 characters!")
    @NotEmpty
    private String firstName;
    @Size(min=3,message = "Lastname must be of minimum 3 characters!")
    @NotEmpty
    private String lastName;

    @Email(message = "Email address is invalid!")
    @NotEmpty
    private String email;

}
