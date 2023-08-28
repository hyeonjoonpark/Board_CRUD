package com.hyeonjoonpark.board_crud.Repository;

import com.hyeonjoonpark.board_crud.Entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

}
