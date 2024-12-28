package br.com.feign.feign.models;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "post", url = "https://jsonplaceholder.typicode.com")
public interface PostFeignClient {
    
    @GetMapping(value = "/posts")
    public String get();

}
