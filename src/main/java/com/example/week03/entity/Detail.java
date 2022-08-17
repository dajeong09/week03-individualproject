package com.example.week03.entity;

import java.time.LocalDateTime;

public interface Detail {
    String getTitle();
    String getWriter();
    LocalDateTime getCreatedAt();
    String getContent();
}
