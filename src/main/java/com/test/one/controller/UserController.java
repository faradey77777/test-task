package com.test.one.controller;

import com.test.one.dto.UserDto;
import com.test.one.service.UserService;
import com.test.one.service.mapper.SelmaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SelmaMapper selmaMapper;


    @GetMapping(value = "userinfo/{user_id}")
    public List<UserDto> topUserInfoById(@PathVariable("user_id") Integer userId) {
        return userService.getInfoByUserId(userId).stream()
                .map(selmaMapper::mapFrom)
                .collect(Collectors.toList());

    }

    @GetMapping(value = "/levelinfo/{level_id}")
    public List<UserDto> topUserInfoByLevel(@PathVariable("level_id") Integer levelId) {
        return userService.getInfoByLevelId(levelId).stream()
                .map(selmaMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @PutMapping("setinfo")
    public HttpStatus changeResultByIdAndLevel(@RequestBody UserDto request) {
        if (userService.saveUserAndChangeResult(selmaMapper.mapTo(request))) {
            return HttpStatus.ACCEPTED;
        }
        return HttpStatus.BAD_REQUEST;
    }
}