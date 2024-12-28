package br.com.feign.feign.models;

import java.util.List;

public record Post(Integer id, Integer userId, String title, String body, List<Comment> comments) {
    
}
