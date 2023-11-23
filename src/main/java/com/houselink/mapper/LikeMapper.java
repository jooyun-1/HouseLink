package com.houselink.mapper;

import com.houselink.dto.HouseSearchResponseDto;
import com.houselink.dto.LikeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {
    Long likeHouse(LikeDto likeDto);

    Long cancelLikeHouse(LikeDto likeDto);

    List<HouseSearchResponseDto> findLikeHouse(String userId);

    Long confirmLikeHouse(LikeDto likeDto);
}
