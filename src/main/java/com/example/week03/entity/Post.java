package com.example.week03.entity;

import com.example.week03.dto.PostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String writer;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String content;

    public Post(PostDto postDto) {
        this.title = postDto.getTitle();
        this.writer = postDto.getWriter();
        this.password = postDto.getPassword();
        this.content = postDto.getContent();
    }

    public void update(PostDto postDto) {
        this.title = postDto.getTitle();
        this.writer = postDto.getWriter();
        this.password = postDto.getPassword();
        this.content = postDto.getContent();
    }

    public void list(PostDto postDto) {
        this.title = postDto.getTitle();
        this.writer = postDto.getWriter();
        this.content = postDto.getContent();
    }


}
