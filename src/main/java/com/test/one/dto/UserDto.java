package com.test.one.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto {
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("level_id")
    private Integer levelId;

    @JsonProperty("result")
    private Integer result;

}
