package br.com.feign.feign.models.mappers;

import java.util.List;

import com.google.gson.JsonObject;

import br.com.feign.feign.models.Comment;
import br.com.feign.feign.models.Post;

public class PostMapper {
    
    public static Post jsonObjectToPost(JsonObject jsonObject, List<Comment> comments) {
        return new Post(jsonObject.get("id").getAsInt(), jsonObject.get("userId").getAsInt(), jsonObject.get("title").getAsString(), jsonObject.get("body").getAsString(), comments);
    }

}
