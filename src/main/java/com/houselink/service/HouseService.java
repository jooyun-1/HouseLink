package com.houselink.service;

import com.houselink.dto.HouseSearchRequestDto;
import com.houselink.dto.HouseSearchResponseDto;

import java.util.List;

public interface HouseService {
    Long getAptCode(String houseName);
    List<HouseSearchResponseDto> findHouseBySigungu(HouseSearchRequestDto houseSearchRequestDto);
    List<HouseSearchResponseDto> findHouseBySearch(String searchInput);

}
