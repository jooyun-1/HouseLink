package com.houselink.service;

import com.houselink.dto.HouseSearchResponseDto;
import com.houselink.dto.LikeDto;

import java.util.List;

public interface LikeService {
    Long likeHouse(String token, LikeDto userDto);

    Long cancelLikeHouse(String token, LikeDto userDto);

    List<HouseSearchResponseDto> findLikeHouse(String token);

    Long confirmLikeHouse(String token, String houseName);
}
