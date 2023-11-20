package com.houselink.service;

import com.github.pagehelper.Page;
import com.houselink.dto.ReviewDto;

import com.houselink.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewMapper reviewMapper;

    @Override
    public Long createReview(ReviewDto reviewDto) {
        return reviewMapper.createReview(reviewDto);
    }

    @Override
    public Page<ReviewDto> findAllReview(Long aptCode) {
        return reviewMapper.findAllReview(aptCode);
    }

    @Override
    public ReviewDto findReviewDetail(Long aptCode, Long reviewId) {
        return reviewMapper.findReviewDetail(aptCode,reviewId);
    }

    @Override
    public Long updateReview(Long aptCode, Long reviewId, ReviewDto reviewDto) {
        return reviewMapper.updateReview(aptCode,reviewId,reviewDto);
    }

    @Override
    public void deleteReview(Long aptCode, Long reviewId) {
        reviewMapper.deleteReview(aptCode,reviewId);
    }
}
