package com.hyeonjoonpark.board_crud.Repository;

import com.hyeonjoonpark.board_crud.Entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Integer> {

}
