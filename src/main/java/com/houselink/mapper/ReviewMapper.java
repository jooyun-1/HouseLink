package com.houselink.mapper;

import com.github.pagehelper.Page;
import com.houselink.dto.ReviewDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    Long createReview(ReviewDto reviewDto);

    Page<ReviewDto> findAllReview(Long aptCode);

    ReviewDto findReviewDetail(Long aptCode, Long reviewId);

    Long updateReview(Long aptCode, Long reviewId, ReviewDto reviewDto);

    void deleteReview(Long aptCode, Long reviewId);
}
