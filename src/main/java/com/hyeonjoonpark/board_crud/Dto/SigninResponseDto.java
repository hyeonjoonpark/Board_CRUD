package com.hyeonjoonpark.board_crud.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SigninResponseDto {
    private String token;
    private int exprTime;
}
