package io.codehooks.springbootquickguide.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {

    private Boolean success;
    private String message;
    private Object data;
}
