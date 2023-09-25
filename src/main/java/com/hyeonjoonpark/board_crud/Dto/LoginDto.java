package com.hyeonjoonpark.board_crud.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NotBlank
    private String userEmail;
    @NotBlank
    private String userPassword;
}
