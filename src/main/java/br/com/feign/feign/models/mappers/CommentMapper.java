package br.com.feign.feign.models.mappers;

import com.google.gson.JsonObject;

import br.com.feign.feign.models.Comment;

public class CommentMapper {
    
    public static Comment jsonObjectToObj(JsonObject jsonObject) {
        return new Comment(jsonObject.get("id").getAsInt(), jsonObject.get("postId").getAsInt(), jsonObject.get("name").getAsString(), jsonObject.get("email").getAsString(), jsonObject.get("body").getAsString());
    }

}
