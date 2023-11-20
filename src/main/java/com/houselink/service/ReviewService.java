package com.houselink.service;

import com.github.pagehelper.Page;
import com.houselink.dto.ReviewDto;

public interface ReviewService {
    Long createReview(ReviewDto reviewDto);

    Page<ReviewDto> findAllReview(Long aptCode);

    ReviewDto findReviewDetail(Long aptCode, Long reviewId);

    Long updateReview(Long aptCode, Long reviewId, ReviewDto reviewDto);

    void deleteReview(Long aptCode, Long reviewId);
}
