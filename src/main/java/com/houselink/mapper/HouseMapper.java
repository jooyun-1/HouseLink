package com.houselink.mapper;


import com.houselink.dto.HouseSearchRequestDto;
import com.houselink.dto.HouseSearchResponseDto;

import com.houselink.dto.HouseDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HouseMapper {
    Long findAptCodeByHouseName(String houseName);

    List<HouseSearchResponseDto> findHouseBySigungu(HouseSearchRequestDto houseSearchRequestDto);

    List<HouseSearchResponseDto> findHouseBySearch(String searchInput);


    Long deleteHouse(HouseDto houseDto);

    Long updateHouse(HouseDto houseDto);

    Long createHouse(HouseDto houseDto);

    Long findAptByAptCode(Long aptCode);

    Long findAptByAptNo(Long no);

}
