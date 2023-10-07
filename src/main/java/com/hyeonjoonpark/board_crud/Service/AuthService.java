package com.hyeonjoonpark.board_crud.Service;

import antlr.Token;
import com.hyeonjoonpark.board_crud.Dto.LoginResponseDto;
import com.hyeonjoonpark.board_crud.Dto.ResponseDto;
import com.hyeonjoonpark.board_crud.Dto.LoginDto;
import com.hyeonjoonpark.board_crud.Dto.SignupDto;
import com.hyeonjoonpark.board_crud.Entity.UserEntity;
import com.hyeonjoonpark.board_crud.Repository.UserRepository;
import com.hyeonjoonpark.board_crud.Security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired UserRepository userRepository;
    @Autowired TokenProvider tokenProvider;
    public ResponseDto<?> signUp(SignupDto dto) {
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        String userPasswordCheck = dto.getUserPasswordCheck();

        // email 중복 확인
        try {
            if(userRepository.existsById(userEmail)) { // userEmail이 존재하는지 확인 -> 존재 시 true 존재하지 않으면 false 반환
                return ResponseDto.setFailed("Existed Email!");
            }
        } catch (Exception e) {
            return ResponseDto.setFailed("Database Error");
        }

        if(!userPassword.equals(userPasswordCheck)) {
            return ResponseDto.setFailed("Password is Wrong!");
        } // userPassword와 userPasswordCheck가 일치하지 않으면

        UserEntity userEntity = new UserEntity(dto); // UserEntity 생성

        try {
            // UserRepository를 이용해서 DB에 Entity 저쟝
            userRepository.save(userEntity);
        } catch (Exception e) {
            ResponseDto.setFailed("Database Error");
        }

        return ResponseDto.setSuccess("SignUp Success!", null);
    }

    public ResponseDto<LoginResponseDto> login(LoginDto dto) {
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();

        try {
            boolean existed =  userRepository.existsByUserEmailAndUserPassword(userEmail, userPassword);
            if(!existed) {
                return ResponseDto.setFailed("Login Info is Wrong");
            }
        } catch (Exception e) {
            return ResponseDto.setFailed("Database Error");
        }

        UserEntity userEntity = null;
        try {
            // 값이 존재하면
            userEntity = userRepository.findById(userEmail).get(); // 사용자 이메일을 가져옴
        } catch(Exception e) {
            return ResponseDto.setFailed("Database Error");
        }

        userEntity.setUserPassword("");

        String token = tokenProvider.createJwt(userEmail);
        int exprTime = 3600000; // 한 시간

        LoginResponseDto loginResponseDto = new LoginResponseDto(token, exprTime, userEntity);
        return ResponseDto.setSuccess("Login Success", loginResponseDto);
    }
}
