package com.test.one.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private Integer userId;
    private Integer levelId;
    private Integer result;
}
