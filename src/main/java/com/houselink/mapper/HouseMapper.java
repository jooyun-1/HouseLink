package com.houselink.mapper;

import com.houselink.dto.HouseSearchRequestDto;
import com.houselink.dto.HouseSearchResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HouseMapper {
    Long findAptCodeByHouseName(String houseName);
    List<HouseSearchResponseDto> findHouseBySigungu(HouseSearchRequestDto houseSearchRequestDto);

    List<HouseSearchResponseDto> findHouseBySearch(String searchInput);
}
