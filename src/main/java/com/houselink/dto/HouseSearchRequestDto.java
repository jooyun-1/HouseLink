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
@ApiModel(value = "HouseSearchRequestDto", description = "시,군,구, 매매년도, 매매월에 따른 매물 검색을 할 때 필요한 정보를 나타낸다.")
public class HouseSearchRequestDto {
    private String sigunguCode;
    private int dealYear;
    private int dealMonth;
    private String dong;
    private String roadName;
    private String apartmentName;
    private String searchInput;
}
