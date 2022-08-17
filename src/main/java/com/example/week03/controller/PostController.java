package com.example.week03.controller;

import com.example.week03.dto.PostDto;
import com.example.week03.entity.Detail;
import com.example.week03.entity.ListPage;
import com.example.week03.entity.Post;
import com.example.week03.repository.PostRepository;
import com.example.week03.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;

    //전체 게시글 목록 조회
    @GetMapping("/post") //Post ->Object 로 변경해보기
    public List<ListPage> getList() {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        List<ListPage> listPage = postRepository.findAllBy(sort);
        return listPage;
        //아이디가 오름차순 아닌가?
    }

    //게시글 작성
    @PostMapping("/post")
    public Post createPost(@RequestBody PostDto postDto) {
        Post post = new Post(postDto);
        postRepository.save(post);
        return post;
    }

    //게시글 조회
    @GetMapping("post/{id}")
    public Optional<Detail> getPost(@PathVariable Long id) {
        return postRepository.findOneById(id);
    }

    //게시글 비밀번호 확인
    @GetMapping("post/{id}/check")
    public Boolean checkPW(@PathVariable Long id, @RequestBody String password) {
        return postService.checkPW(id, password);
    }

    //게시글 수정
    @PutMapping("post/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        postService.update(id, postDto);
        return id;
    }

    //게시물 삭제
    @DeleteMapping("post/{id}")
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }

}
