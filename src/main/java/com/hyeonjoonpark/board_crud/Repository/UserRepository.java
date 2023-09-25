package com.hyeonjoonpark.board_crud.Repository;

import com.hyeonjoonpark.board_crud.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    public boolean existsByUserEmailAndUserPassword(String userEmail, String userPassword);
}
