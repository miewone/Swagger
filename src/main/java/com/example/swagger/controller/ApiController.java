package com.example.swagger.controller;

import com.example.swagger.dto.UserReq;
import com.example.swagger.dto.UserRes;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API 정보를 제공하는 Cnt"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }

    @ApiImplicitParams({
                    @ApiImplicitParam(name="x",value = "x value",required = true,paramType = "query"),
                    @ApiImplicitParam(name="y",value = "y value",required = true,paramType = "path")
    })
    @GetMapping("/plus/{x}")
    public int plus(
//            @ApiParam(value = "Y 값")
            @RequestParam int y,
//            @ApiParam(value = "X 값")
            @PathVariable int x
    )
    {
        return x+y;
    }

    @ApiResponse(code = 1,message = "test")
    @ApiOperation(value = "사용자 이름,나이 리턴")
    @GetMapping("/user")
    public UserRes user(UserReq userReq)
    {
        return new UserRes(userReq.getName(),userReq.getAge());
    }

    @PostMapping("/user")
    public UserRes userPost(@RequestBody UserReq userReq)
    {
        return new UserRes(userReq.getName(),userReq.getAge());
    }
}
