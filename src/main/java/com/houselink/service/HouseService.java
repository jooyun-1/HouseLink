package com.houselink.service;

import com.houselink.dto.HouseDto;

import java.sql.SQLException;

public interface HouseService {
    Long getAptCode(String houseName);

    Long createHouse(String token, HouseDto houseDto) throws Exception;

    Long updateHouse(String token, HouseDto houseDto) throws Exception;

    Long deleteHouse(String token, HouseDto houseDto) throws Exception;
}
