package com.houselink.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.houselink.dto.ReviewDto;
import com.houselink.service.ReviewService;
import com.houselink.util.JWTUtil;
import io.swagger.annotations.ApiOperation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;
    private final JWTUtil jwtUtil;

    @ApiOperation(value = "리뷰 추가", notes = "리뷰 추가")
    @PostMapping("/{aptCode}")
    public ResponseEntity<Long> createReview(@PathVariable Long aptCode, @RequestBody ReviewDto reviewDto) throws IOException {
        reviewDto.setAptCode(aptCode);
        return new ResponseEntity<>(reviewService.createReview(reviewDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "아파트 리뷰 전체 조회", notes = "해당 아파트의 리뷰를 모두 조회한다.")
    @GetMapping("/{aptCode}")
    public ResponseEntity<Page<ReviewDto>> findAllReview(@PathVariable Long aptCode, @RequestParam(defaultValue = "1") Integer pageNum) throws IOException {
        PageHelper.startPage(pageNum, 10);
        return ResponseEntity.ok(reviewService.findAllReview(aptCode));
    }

    @ApiOperation(value = "해당 아파트 리뷰 상세 조회", notes = "해당 아파트의 리뷰를 상세 조회한다.")
    @GetMapping("/{aptCode}/{reviewId}")
    public ResponseEntity<ReviewDto> findReviewDetail(@PathVariable Long aptCode, @PathVariable Long reviewId) throws IOException {
        return ResponseEntity.ok(reviewService.findReviewDetail(aptCode,reviewId));
    }

    @ApiOperation(value = "리뷰 수정", notes = "리뷰 수정")
    @PutMapping("/{aptCode}/{reviewId}")
    public ResponseEntity<Long> updateReview(@PathVariable Long aptCode, @PathVariable Long reviewId, @RequestBody ReviewDto reviewDto) throws IOException {
        return new ResponseEntity<>(reviewService.updateReview(aptCode, reviewId, reviewDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "리뷰 삭제", notes = "리뷰 삭제")
    @DeleteMapping("/{aptCode}/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long aptCode, @PathVariable Long reviewId) throws IOException {
        reviewService.deleteReview(aptCode,reviewId);
        return ResponseEntity.noContent().build();
    }
}
