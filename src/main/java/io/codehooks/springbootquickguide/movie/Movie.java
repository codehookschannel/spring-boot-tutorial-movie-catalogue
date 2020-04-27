package io.codehooks.springbootquickguide.movie;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;

@Data
@Builder
@Document(collection = "movie")
public class Movie {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @NotNull
    @Field(value = "name")
    private String name;
    private String comment;
    private double rating;
    private String type;

}
