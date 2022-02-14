package com.web.ls.model.dto.linkbox.like;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LikeUserResponse {

    @ApiModelProperty(value = "user id", position = 1, required = true)
    private Integer uid;

    @ApiModelProperty(value = "user email", position = 2, required = true)
    private String email;
    
    @ApiModelProperty(value = "user nickname", position = 3, required = true)
    private String nickname;
    
}
