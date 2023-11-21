package com.houselink.mapper;

import com.houselink.dto.HouseDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseMapper {
    Long findAptCodeByHouseName(String houseName);

    Long deleteHouse(HouseDto houseDto);

    Long updateHouse(HouseDto houseDto);

    Long createHouse(HouseDto houseDto);

    Long findAptByAptCode(Long aptCode);

    Long findAptByAptNo(Long no);
}
