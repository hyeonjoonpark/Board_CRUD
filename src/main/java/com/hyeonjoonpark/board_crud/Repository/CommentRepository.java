package com.hyeonjoonpark.board_crud.Repository;

import com.hyeonjoonpark.board_crud.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

}
