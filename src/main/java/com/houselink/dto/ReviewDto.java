package com.houselink.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(value = "ReviewDto : 리뷰 정보", description = "리뷰의 상세 정보를 나타낸다.")
public class ReviewDto {

    private Long reviewId;
    private String email;
    private String content;
    private LocalDate createdAt;
    private Long aptCode;
    private String apartmentName;
}
