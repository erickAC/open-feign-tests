package br.com.feign.feign.models;

public record Comment(Integer id, Integer postId, String name, String email, String body) {
    
}
