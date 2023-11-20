package com.houselink.mapper;

import com.houselink.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.Map;

@Mapper
public interface UserMapper {
    UserDto login(UserDto userDto) throws SQLException;
    UserDto userInfo(String userId) throws SQLException;
    void saveRefreshToken(Map<String, String> map) throws SQLException;
    String getRefreshToken(String userid) throws SQLException;
    void deleteRefreshToken(Map<String, String> map) throws SQLException;

    Long signup(UserDto userDto) throws Exception;
}
