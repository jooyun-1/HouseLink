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
@ApiModel(value = "HouseDto : 아파트 정보", description = "아파트 정보를 나타낸다.")
public class HouseDto {
    private Long no;
    private String houseName;
    private String sigunguCode;
    private String floor;
    private String area;
    private int dealYear;
    private int dealMonth;
    private int dealDay;
    private String dealAmount;
    private Long aptCode;

}