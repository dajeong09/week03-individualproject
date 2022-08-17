package com.example.week03.service;

import com.example.week03.dto.PostDto;
import com.example.week03.entity.Detail;
import com.example.week03.entity.Post;
import com.example.week03.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long update(Long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("글이 존재하지 않습니다.")
        );
        post.update(postDto);
        return post.getId();
    }

    public Boolean checkPW(Long id, String password) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("글이 존재하지 않습니다.")
        );
        if (post.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
