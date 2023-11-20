package com.houselink.controller;


import com.houselink.service.HouseService;
import com.houselink.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/house")
@RequiredArgsConstructor
@Slf4j
public class HouseController {
    private final HouseService houseService;

}
