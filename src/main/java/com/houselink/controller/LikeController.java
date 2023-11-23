package com.houselink.controller;

import com.houselink.dto.HouseDto;
import com.houselink.dto.HouseSearchResponseDto;
import com.houselink.dto.LikeDto;
import com.houselink.dto.UserDto;
import com.houselink.service.LikeService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
@Slf4j
public class LikeController {
    private final LikeService likeService;

    @ApiOperation(value = "아파트 찜하기", notes = "아파트 찜하기")
    @PostMapping
    public ResponseEntity<Long> likeHouse(@RequestHeader("Authorization") String token,
                                            @RequestBody LikeDto likeDto) throws Exception {
        return ResponseEntity.ok(likeService.likeHouse(token,likeDto));
    }

    @ApiOperation(value = "내가 찜한 아파트 목록 보기", notes = "내가 찜한 아파트 목록 보기")
    @GetMapping("/list")
    public ResponseEntity<List<HouseSearchResponseDto>> findLikeHouse(@RequestHeader("Authorization") String token) {

        return ResponseEntity.ok(likeService.findLikeHouse(token));
    }

    @ApiOperation(value = "내가 찜한 아파트인지 확인", notes = "내가 찜한 아파트인지 확인")
    @GetMapping("/{houseName}")
    public ResponseEntity<Long> confirmLikeHouse(@RequestHeader("Authorization") String token,
                                                 @PathVariable String houseName) {
        return ResponseEntity.ok(likeService.confirmLikeHouse(token,houseName));
    }

    @ApiOperation(value = "아파트 찜하기 취소", notes = "아파트 찜하기 취소")
    @DeleteMapping
    public ResponseEntity<Long> cancelLikeHouse(@RequestHeader("Authorization") String token,
                                            @RequestBody LikeDto likeDto) throws Exception {
        System.out.println(likeDto.getApartmentName());
        return ResponseEntity.ok(likeService.cancelLikeHouse(token,likeDto));
    }
}
