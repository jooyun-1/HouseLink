package com.houselink.service;

import com.houselink.mapper.HouseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService{
    private final HouseMapper houseMapper;
    @Override
    public Long getAptCode(String houseName) {
        return houseMapper.findAptCodeByHouseName(houseName);
    }
}
