package br.com.feign.feign.services.impls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import br.com.feign.feign.models.Comment;
import br.com.feign.feign.models.CommentFeignClient;
import br.com.feign.feign.models.Post;
import br.com.feign.feign.models.PostFeignClient;
import br.com.feign.feign.models.mappers.CommentMapper;
import br.com.feign.feign.models.mappers.PostMapper;
import br.com.feign.feign.services.PostService;

@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
    private PostFeignClient postFeignClient;

    @Autowired
    private CommentFeignClient commentFeignClient;

    @Autowired
    private Gson gson;

    @Override
    public List<Post> get() {
        List<Post> posts = new ArrayList<>();
        String response = this.postFeignClient.get();
        JsonArray responseList = gson.fromJson(response, JsonArray.class);
        posts = responseList.asList().stream().map(x -> {
            String responseComment = this.commentFeignClient.getByPostId(((JsonObject) x).get("id").getAsInt());
            JsonArray responseCommentList = gson.fromJson(responseComment, JsonArray.class);
            List<Comment> comments = responseCommentList.asList().stream().map(comment -> CommentMapper.jsonObjectToObj((JsonObject) comment)).toList();
            Post post = PostMapper.jsonObjectToPost((JsonObject) x, comments);
            return post;
        }).toList();
        return posts;
    }

}
