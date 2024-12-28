package br.com.feign.feign.models;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "comment", url = "https://jsonplaceholder.typicode.com")
public interface CommentFeignClient {

    @GetMapping(value = "/comments")
    public String getByPostId(
        @RequestParam("postId") Integer postId
    );
    
}
