package com.example.swagger.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRes {

    @ApiModelProperty(value = "User name",example = "park",required = true)
    private String name;
    @ApiModelProperty(value = "User age",example = "12",required = true)
    private int age;
}
