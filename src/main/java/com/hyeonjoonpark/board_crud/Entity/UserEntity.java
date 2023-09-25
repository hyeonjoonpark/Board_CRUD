package com.hyeonjoonpark.board_crud.Entity;

import com.hyeonjoonpark.board_crud.Dto.LoginDto;
import com.hyeonjoonpark.board_crud.Dto.SignupDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="User")
@Table(name="User")
public class UserEntity {
    @Id
    private String userEmail;
    private String userPassword;
    private String userNickname;
    private String userPhoneNumber;
    private String userAddress;
    private String userProfile;

    public UserEntity(SignupDto dto) {
        this.userEmail = dto.getUserEmail();
        this.userPassword = dto.getUserPassword();
        this.userNickname = dto.getUserNickname();
        this.userPhoneNumber = dto.getUserPhoneNumber();
        this.userAddress = dto.getUserAddress() + " " + dto.getUserAddressDetail();
    }
}
