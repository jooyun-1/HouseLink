package com.houselink.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(value = "LikeDto : 찜하기", description = "")

public class LikeDto {
    private Long likeId;
    private String userId;
    private Long aptCode;
    private String apartmentName;
    private String floor;
    private Long dealYear;
    private Long dealMonth;
    private Long dealDay;
    private String area;
    private String dealAmount;
}
