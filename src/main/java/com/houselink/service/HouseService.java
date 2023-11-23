package com.houselink.service;


import com.github.pagehelper.Page;

import com.houselink.dto.HouseSearchRequestDto;
import com.houselink.dto.HouseSearchResponseDto;
import com.houselink.dto.HouseDto;
import com.houselink.dto.LikeDto;


import java.sql.SQLException;
import java.util.List;

public interface HouseService {
    Long getAptCode(String houseName);


    String findHouseNameByAptCode(Long aptCode);

    List<HouseSearchResponseDto> findHouseBySigungu(HouseSearchRequestDto houseSearchRequestDto);

    List<HouseSearchResponseDto> findHouseBySearch(String searchInput);


    Long createHouse(String token, HouseDto houseDto) throws Exception;

    Long updateHouse(String token, HouseDto houseDto) throws Exception;

    Long deleteHouse(String token, HouseDto houseDto) throws Exception;

    List<HouseSearchResponseDto> findHouseByAptCode(LikeDto likeDto);
}


