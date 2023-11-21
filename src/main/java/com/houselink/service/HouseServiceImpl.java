package com.houselink.service;

import com.houselink.dto.HouseSearchRequestDto;
import com.houselink.dto.HouseSearchResponseDto;
import com.houselink.mapper.HouseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService{
    private final HouseMapper houseMapper;
    @Override
    public Long getAptCode(String houseName) {
        return houseMapper.findAptCodeByHouseName(houseName);
    }

    @Override
    public List<HouseSearchResponseDto> findHouseBySigungu(HouseSearchRequestDto houseSearchRequestDto) {
        return houseMapper.findHouseBySigungu(houseSearchRequestDto);
    }

    @Override
    public List<HouseSearchResponseDto> findHouseBySearch(String searchInput) {
        return houseMapper.findHouseBySearch(searchInput);
    }
}
