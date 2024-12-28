package br.com.feign.feign.services;

import java.util.List;

import br.com.feign.feign.models.Post;

public interface PostService {
    
    public List<Post> get();

}
