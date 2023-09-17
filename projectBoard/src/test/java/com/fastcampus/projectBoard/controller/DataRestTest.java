package com.fastcampus.projectBoard.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

// @WebMvcTest
@DisplayName("Data REST - API 테스트")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    };

    @DisplayName("[api] 게시글 리스트 조회")
    @Test
    void givenNothing_whenRequestingAtricles_thenReturnsAtriclesJsonResponse(){
        // Given
        
        // When & Then
        try {
            mvc.perform(MockMvcRequestBuilders.get("/api/articles"))    // 알아서 entity의 클래스명에 복수형이됨. fairy 라는 테이블이라면 fairys 가 아닌 알아서 fairies 가 됨.
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("[api] 게시글 단건 조회")
    @Test
    void givenNothing_whenRequestingAtricle_thenReturnsAtricleJsonResponse(){
        // Given
        
        // When & Then
        try {
            mvc.perform(MockMvcRequestBuilders.get("/api/articles/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("[api] 게시글 -> 댓글 리스트 조회")
    @Test
    void givenNothing_whenRequestingAtricleCommentFromArticle_thenReturnsAtricleCommentJsonResponse(){
        // Given
        
        // When & Then
        try {
            mvc.perform(MockMvcRequestBuilders.get("/api/articles/1/articleComment"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("[api] 댓글 리스트 조회")
    @Test
    void givenNothing_whenRequestingAtricleComments_thenReturnsAtricleCommentsJsonResponse(){
        // Given
        
        // When & Then
        try {
            mvc.perform(MockMvcRequestBuilders.get("/api/articles/1/articleComment"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("[api] 댓글 단건 조회")
    @Test
    void givenNothing_whenRequestingAtricleComment_thenReturnsAtricleCommentJsonResponse(){
        // Given
        
        // When & Then
        try {
            mvc.perform(MockMvcRequestBuilders.get("/api/articleComments/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
