package com.hyeonjoonpark.board_crud.Repository;

import com.hyeonjoonpark.board_crud.Entity.PopularSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularSearchRepository extends JpaRepository<PopularSearchEntity, String> {

}
