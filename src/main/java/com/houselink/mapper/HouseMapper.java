package com.houselink.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseMapper {
    Long findAptCodeByHouseName(String houseName);
}
