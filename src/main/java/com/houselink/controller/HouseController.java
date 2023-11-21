package com.houselink.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.houselink.dto.HouseSearchRequestDto;
import com.houselink.dto.HouseSearchResponseDto;
import com.houselink.dto.ReviewDto;
import com.houselink.service.HouseService;
import com.houselink.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/house")
@RequiredArgsConstructor
@Slf4j
public class HouseController {
    private final HouseService houseService;
    @ApiOperation(value = "aptCode 조회", notes = "아파트 이름으로 aptCode를 조회한다.")
    @GetMapping("/{houseName}")
    public ResponseEntity<Long> findAllReview(@PathVariable String houseName) throws IOException {

        return ResponseEntity.ok(houseService.getAptCode(houseName));
    }

    @GetMapping
    public ResponseEntity<List<HouseSearchResponseDto>> findHouseBySigungu(HouseSearchRequestDto houseSearchRequestDto) {
        return ResponseEntity.ok(houseService.findHouseBySigungu(houseSearchRequestDto));
    }

    @GetMapping("/search/{searchInput}")
    public ResponseEntity<List<HouseSearchResponseDto>> findHouseBySearch(@PathVariable String searchInput) {
        return ResponseEntity.ok(houseService.findHouseBySearch(searchInput));
    }
}
