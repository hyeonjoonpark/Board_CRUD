package com.hyeonjoonpark.board_crud.Controller;

import com.hyeonjoonpark.board_crud.Dto.ResponseDto;
import com.hyeonjoonpark.board_crud.Dto.LoginResponseDto;
import com.hyeonjoonpark.board_crud.Dto.LoginDto;
import com.hyeonjoonpark.board_crud.Dto.SignupDto;
import com.hyeonjoonpark.board_crud.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired AuthService authService;
    @PostMapping("/signUp")
    public ResponseDto<?> signUp(@RequestBody SignupDto requestBody) {
        ResponseDto<?> result = authService.signUp(requestBody);
        return result;
    }

    @PostMapping("/login")
    public ResponseDto<LoginResponseDto> login(@RequestBody LoginDto requestBody) {
        ResponseDto<LoginResponseDto> result = authService.login(requestBody);
        return result;
    }
}
