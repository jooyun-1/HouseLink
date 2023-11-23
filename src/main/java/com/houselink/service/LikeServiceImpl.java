package com.houselink.service;

import com.houselink.dto.HouseSearchResponseDto;
import com.houselink.dto.LikeDto;
import com.houselink.mapper.HouseMapper;
import com.houselink.mapper.LikeMapper;
import com.houselink.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService{
    private final JWTUtil jwtUtil;
    private final LikeMapper likeMapper;
    private final HouseMapper houseMapper;
    @Override
    public Long likeHouse(String token, LikeDto likeDto) {
        String userId = jwtUtil.getUserId(token);
        likeDto.setUserId(userId);
        Long aptCode = houseMapper.findAptCodeByHouseName(likeDto.getApartmentName());
        likeDto.setAptCode(aptCode);
        return likeMapper.likeHouse(likeDto);
    }

    @Override
    public Long cancelLikeHouse(String token, LikeDto likeDto) {
        String userId = jwtUtil.getUserId(token);
        likeDto.setUserId(userId);
        Long aptCode = houseMapper.findAptCodeByHouseName(likeDto.getApartmentName());
        likeDto.setAptCode(aptCode);
        return likeMapper.cancelLikeHouse(likeDto);
    }

    @Override
    public List<HouseSearchResponseDto> findLikeHouse(String token) {
        String userId = jwtUtil.getUserId(token);
        return likeMapper.findLikeHouse(userId);
    }

    @Override
    public Long confirmLikeHouse(String token, String houseName) {
        LikeDto likeDto = new LikeDto();
        String userId = jwtUtil.getUserId(token);
        likeDto.setUserId(userId);
        likeDto.setApartmentName(houseName);
        return likeMapper.confirmLikeHouse(likeDto);
    }
}
