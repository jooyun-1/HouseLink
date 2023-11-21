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
@ApiModel(value = "HouseSearchResponseDto", description = "시,군,구, 매매년도, 매매월에 따른 매물 검색 결과 정보를 나타낸다.")
public class HouseSearchResponseDto {
    private String floor;
    private String area;
    private String dealAmount;
    private String dealYear;
    private String dealMonth;
    private String dealDay;
    private String apartmentName;
    private String lat;
    private String lng;
    private String roadName;
    private String roadNameBonbun;
}
