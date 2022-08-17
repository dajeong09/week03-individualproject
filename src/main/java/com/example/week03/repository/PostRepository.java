package com.example.week03.repository;

import com.example.week03.entity.Detail;
import com.example.week03.entity.ListPage;
import com.example.week03.entity.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Long> {
    List<ListPage> findAllBy(Sort sort);
    Optional<Detail> findOneById(Long id);

}
